package com.alemand.resolve.entity;

/**
 * @ClassName: 用户详情表
 * @Description： 插入用户详情表BO
 * @author：zhouxuesheng
 * @Data:2018/12/2
 */
public class PassportInfoDetailBOByMySql {

/**
 * 	insert into RMD_T_PASSPORT_DETAIL (GID,PASSPORT_GID,NICK_NAME,TEL_PHONE,REAL_NAME,SEX,EMAIL,HEADER_IMG,DEPT,ADDRESS,MARK,CREATE_ID,CREATE_TIME,UPDATE_ID,UPDATE_TIME)
 values (#{gid},#{passportgid},#{nickName},#{telPhone},#{realName},#{sex},#{email},null,#{dept},#{address},#{mark}, 'system', now(), 'system', NOW())
 */

	/***
	 * Gid
	 */
	private Integer gid;
	/***
	 * 用户GID 外键
	 */
	private Integer passportgid;
	/***
	 * 昵称
	 */
	private String nickName;
	/**
	 * 电话号码
	 */
	private String telPhone;
	/***
	 * 姓名
	 */
	private String realName;
	/**
	 * 性别 默认-1：保密
	 */
	private Integer sex;
	/***
	 * 邮箱
	 */
	private String email;
	/***
	 * 院系
	 */
	private String dept;
	/***
	 * 地址
	 */
	private String address;
	/**
	 * 备注
	 */
	private String mark;


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
	 * 获取 用户GID 外键
	 *
	 * @return passportgid 用户GID 外键
	 */
	public Integer getPassportgid() {
		return this.passportgid;
	}

	/**
	 * 设置 用户GID 外键
	 *
	 * @param passportgid 用户GID 外键
	 */
	public void setPassportgid(Integer passportgid) {
		this.passportgid = passportgid;
	}

	/**
	 * 获取 昵称
	 *
	 * @return nickName 昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 设置 昵称
	 *
	 * @param nickName 昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 获取 电话号码
	 *
	 * @return telPhone 电话号码
	 */
	public String getTelPhone() {
		return this.telPhone;
	}

	/**
	 * 设置 电话号码
	 *
	 * @param telPhone 电话号码
	 */
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	/**
	 * 获取 姓名
	 *
	 * @return realName 姓名
	 */
	public String getRealName() {
		return this.realName;
	}

	/**
	 * 设置 姓名
	 *
	 * @param realName 姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获取 性别 默认-1：保密
	 *
	 * @return sex 性别 默认-1：保密
	 */
	public Integer getSex() {
		return this.sex;
	}

	/**
	 * 设置 性别 默认-1：保密
	 *
	 * @param sex 性别 默认-1：保密
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 获取 邮箱
	 *
	 * @return email 邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置 邮箱
	 *
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取 院系
	 *
	 * @return dept 院系
	 */
	public String getDept() {
		return this.dept;
	}

	/**
	 * 设置 院系
	 *
	 * @param dept 院系
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * 获取 地址
	 *
	 * @return address 地址
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 设置 地址
	 *
	 * @param address 地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取 备注
	 *
	 * @return mark 备注
	 */
	public String getMark() {
		return this.mark;
	}

	/**
	 * 设置 备注
	 *
	 * @param mark 备注
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
}
