package cn.blueboz.elec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.blueboz.elec.dao.IElecTextDao;
import cn.blueboz.elec.domain.ElecText;
import cn.blueboz.elec.service.IElecTextService;


/**
 * 业务逻辑层，需要注入dao
 * 注入的时候可以指定名称，也可以不指定注入名称
 * @author Administrator
 *
 */
//加入IOC，开启声明式事务
@Service(IElecTextService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecTextServiceImpl implements IElecTextService {
	
	//DI
	private IElecTextDao elecTextDao;
	@Resource(name=IElecTextDao.SERVICE_NAME)
	public void setElecTextDao(IElecTextDao elecTextDao){
		this.elecTextDao=elecTextDao;
	}
	
	@Transactional(readOnly=false)
	public void saveElecText(ElecText elecText) {
		elecTextDao.save(elecText);
	}
	
}
