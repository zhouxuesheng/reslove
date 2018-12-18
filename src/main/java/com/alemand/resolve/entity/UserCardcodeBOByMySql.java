package com.alemand.resolve.entity;

import java.time.LocalDateTime;

/**
 * @ClassName: 读者证表
 * @Description： 读者证BO
 * @author：zhouxuesheng
 * @Data:2018/12/2
 */
public class UserCardcodeBOByMySql {
/***
 * 	INSERT INTO RMD_T_PASSPORT_CARD ( GID, CARD_CODE, PASSPORT_GID, READER_TYPE, READER_TYPE_NAME, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME)
 VALUES (#{gid},#{cardCode}, #{passportgid},#{readerType}, #{readerTypeName}, 'system', now(), 'system', NOW());

 */

	/**
	 * Gid
	 */
	private Integer gid;
	/***
	 * 借阅证账号
	 */
	private String cardCode;
	/***
	 * 通行证外键
	 */
	private Integer passportgid;
	/***
	 * 读者类型
	 */
	private String readerType;
	/***
	 * 读者证类型名称
	 */
	private String readerTypeName;


	/**
	 * 获取 Gid
	 *
	 * @return gid Gid
	 */
	public Integer getGid() {
		return this.gid;
	}

	/**
	 * 设置 Gid
	 *
	 * @param gid Gid
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 获取 借阅证账号
	 *
	 * @return cardCode 借阅证账号
	 */
	public String getCardCode() {
		return this.cardCode;
	}

	/**
	 * 设置 借阅证账号
	 *
	 * @param cardCode 借阅证账号
	 */
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	/**
	 * 获取 通行证外键
	 *
	 * @return passportgid 通行证外键
	 */
	public Integer getPassportgid() {
		return this.passportgid;
	}

	/**
	 * 设置 通行证外键
	 *
	 * @param passportgid 通行证外键
	 */
	public void setPassportgid(Integer passportgid) {
		this.passportgid = passportgid;
	}

	/**
	 * 获取 读者类型
	 *
	 * @return readerType 读者类型
	 */
	public String getReaderType() {
		return this.readerType;
	}

	/**
	 * 设置 读者类型
	 *
	 * @param readerType 读者类型
	 */
	public void setReaderType(String readerType) {
		this.readerType = readerType;
	}

	/**
	 * 获取 读者证类型名称
	 *
	 * @return readerTypeName 读者证类型名称
	 */
	public String getReaderTypeName() {
		return this.readerTypeName;
	}

	/**
	 * 设置 读者证类型名称
	 *
	 * @param readerTypeName 读者证类型名称
	 */
	public void setReaderTypeName(String readerTypeName) {
		this.readerTypeName = readerTypeName;
	}
}
