package cn.blueboz.elec.web.action;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.blueboz.elec.domain.ElecText;
import cn.blueboz.elec.service.IElecTextService;

//指定为prototype原型，对应每一个请求都会产生一个实例对象
@Controller("elecTextAction")
@Scope(value="prototype")
public class ElecTextAction extends BaseAction<ElecText>  {
	//首先获得模型驱动对象
	
	ElecText elecText=getModel();
	protected ApplicationContext applicationContext;
	//注入Service指定从Spring的IOC容器中注入的对象的名称
	@Resource(name=IElecTextService.SERVICE_NAME)
	private IElecTextService elecTextService;
	
	public String save(){
		//从表单中传送过来的实例对象
		elecTextService.saveElecText(elecText);
		return "save";
	}
}
