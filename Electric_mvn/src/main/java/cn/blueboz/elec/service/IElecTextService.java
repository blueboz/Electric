package cn.blueboz.elec.service;

import cn.blueboz.elec.domain.ElecText;

public interface IElecTextService {
	public static final String SERVICE_NAME="cn.blueboz.elec.service.impl.ElecTextServiceImpl";
	void saveElecText(ElecText elecText);
}
