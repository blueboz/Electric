package cn.blueboz.elec.dao.impl;

import org.springframework.stereotype.Repository;

import cn.blueboz.elec.dao.IElecTextDao;
import cn.blueboz.elec.domain.ElecText;

//加入IOC容器，注入IOC容器的时候以名称SERVICE_NAME注入
@Repository(IElecTextDao.SERVICE_NAME)
public class ElecTextDaoImpl extends CommonDaoImpl<ElecText> implements IElecTextDao {
	

}
