package cn.blueboz.elec.domain;

import java.io.Serializable;
import java.util.Date;

public class ElecText implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3599481888579336253L;
	/**
	 * 这是一个JavaBean对象
	 * textID VARCHAR(50) NOT NULL PRIMARY KEY,
	 * textName VARCHAR(50),
	 * textDate DATETIME,
	 * textRemark VARCHAR(500)
	 */
	private String textID;		//主键ID
	private String textName;	//测试名称
	private Date textDate;		//测试日期
	private String textRemark;	//测试备注
	public String getTextID() {
		return textID;
	}
	public void setTextID(String textID) {
		this.textID = textID;
	}
	public String getTextName() {
		return textName;
	}
	public void setTextName(String textName) {
		this.textName = textName;
	}
	public Date getTextDate() {
		return textDate;
	}
	public void setTextDate(Date textDate) {
		this.textDate = textDate;
	}
	public String getTextRemark() {
		return textRemark;
	}
	public void setTextRemark(String textRemark) {
		this.textRemark = textRemark;
	}
	
}
