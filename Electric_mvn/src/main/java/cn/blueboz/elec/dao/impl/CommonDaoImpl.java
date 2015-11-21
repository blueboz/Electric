package cn.blueboz.elec.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.blueboz.elec.dao.ICommonDao;
import cn.blueboz.elec.utils.TUtils;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {
	//泛型转换，获取真正对象实体
	Class<?> entityClass=TUtils.getTClass(this.getClass());
	//使用Resource标签注入资源sessionFactory必须在Spring的IOC容器中存在，否则报错
	@Resource(name="sessionFactory")
	public final void setSessionFactoryDi(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findObjectByID(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public void deleteObjectByIDs(Serializable... ids) {
		for(Serializable id:ids){
			Object object = this.getHibernateTemplate().get(entityClass, id);
			if(object!=null){
				//只有当查得到才将其删除
				this.getHibernateTemplate().delete(object);
			}
		}
	}

	@Override
	public void deleteObjectByCollections(List<T> list) {
		//注意一定要进行合法性检查
		if(list==null||list.size()==0)throw new NullPointerException();
		this.getHibernateTemplate().deleteAll(list);
	}
	
	//根据条件进行查找，condition是查询的条件语句，params是参数，orderby是排序方法
	/**
	 * 		这里1=1的目的是方便在Service层拼装sql或者hql语句，连接统一使用and
	 * 
	 * 		SELECT o FROM ElecText o WHERE 1=1           		#Dao层填写
	 *		AND o.textName LIKE '%张%'                			#Service拼装
	 *		AND o.textRemark LIKE '%张%'              			#Service拼装
	 *		ORDER BY o.textDate ASC,o.textName desc				#Service拼装
	 *		Condition 是And的字段
	 *		Orderby 是排序字段
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findCollectionByConditionNoPage(String condition,
			Object[] params, Map<String, String> orderby) {
		//condition是外加条件，paramount是参数，Orderby必须自己拼接
		String hql="SELECT o FROM "+entityClass.getName()+" o WHERE 1=1";
		String orderBy=initOrder(orderby);
		String sql=hql+condition+orderBy;
		//一共有三种查询方式
//		this.getHibernateTemplate().find(sql, params);
		//第二种
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(sql);
		if(params!=null&&params.length>0){
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}

	private String initOrder(Map<String, String> orderby) {
		StringBuffer sb=new StringBuffer();
		//合法性校验
		if(orderby!=null&&orderby.size()>0){
			sb.append("ORDER BY ");
			for(Entry<String, String> entry : orderby.entrySet()){
				String key = entry.getKey();
				String value = entry.getValue();
				sb.append(key+' ');
				sb.append(value+' ');
			}
			//记得一定要删除最后一个逗号
			sb.deleteCharAt(sb.length()-1);
		}
		return "";
	}

}
