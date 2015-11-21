package cn.blueboz.elec.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface ICommonDao<T> {
	void save(T t);
	void update(T t);
	//根据主键查询
	T findObjectByID(Serializable id);
	//通过一系列的ID值删除s
	void deleteObjectByIDs(Serializable...ids);
	//通过集合删除对象
	void deleteObjectByCollections(List<T> list);
	//指定查询条件，不分页
	List<T> findCollectionByConditionNoPage(String condition,Object[] params,Map<String,String>orderby);
}
