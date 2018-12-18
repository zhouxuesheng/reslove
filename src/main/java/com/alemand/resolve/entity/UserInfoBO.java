package com.alemand.resolve.entity;

import javax.validation.constraints.NotBlank;

public class UserInfoBO {

	
	@NotBlank
	private String cardCode;
	@NotBlank
	private String nickName;
	@NotBlank
	private String sex;
	private String denp;
	@NotBlank
	private String readerType;

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDenp() {
		return denp;
	}

	public void setDenp(String denp) {
		this.denp = denp;
	}

	public String getReaderType() {
		return readerType;
	}

	public void setReaderType(String readerType) {
		this.readerType = readerType;
	}

}
