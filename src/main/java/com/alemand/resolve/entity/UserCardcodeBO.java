package com.alemand.resolve.entity;

import java.time.LocalDateTime;

public class UserCardcodeBO {

	private String gid;
	private String cardCode;
	private String cardPsd;
	private String passportGid;
	private String orgGid;
	//注册时间
	private LocalDateTime submitTime;
	//所属单位
	private String dept;
	//读者类型
	private String readerType;
	//姓名
	private String name;
	//
	private String passport;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getCardPsd() {
		return cardPsd;
	}

	public void setCardPsd(String cardPsd) {
		this.cardPsd = cardPsd;
	}

	public String getPassportGid() {
		return passportGid;
	}

	public void setPassportGid(String passportGid) {
		this.passportGid = passportGid;
	}

	public String getOrgGid() {
		return orgGid;
	}

	public void setOrgGid(String orgGid) {
		this.orgGid = orgGid;
	}

	public LocalDateTime getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(LocalDateTime submitTime) {
		this.submitTime = submitTime;
	}

	public String getReaderType() {
		return readerType;
	}

	public void setReaderType(String readerType) {
		this.readerType = readerType;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}


	
}
