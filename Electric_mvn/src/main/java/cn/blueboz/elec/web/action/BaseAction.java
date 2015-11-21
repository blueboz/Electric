package cn.blueboz.elec.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.blueboz.elec.utils.TUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware,ServletResponseAware {
	
	protected HttpServletResponse res;
	protected HttpServletRequest req;
	/**
	 * 通过构造器初始化模型驱动
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public BaseAction(){
		try {
			entity= (T) TUtils.getTClass(this.getClass()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	//模型驱动，我们需要创建
	private T entity;
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return entity;
	}
	//这样做Struts容器会
	@Override
	public void setServletResponse(HttpServletResponse res) {
		this.res=res;
	}
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req=req;
	}

}
