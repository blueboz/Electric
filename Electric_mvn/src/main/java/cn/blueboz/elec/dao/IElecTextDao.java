package cn.blueboz.elec.dao;

import cn.blueboz.elec.domain.ElecText;

public interface IElecTextDao extends ICommonDao<ElecText> {
	//存放于IOC容器中的对象名称
	public static final String SERVICE_NAME="cn.blueboz.elec.dao.impl.ElecTextDaoImpl";
}
