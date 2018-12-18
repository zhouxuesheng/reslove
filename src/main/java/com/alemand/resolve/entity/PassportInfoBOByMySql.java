package com.alemand.resolve.entity;

/***
 * @ClassName: 通行证BO
 * @Description：插入数据库BO对象
 * @author：zhouxuesheng
 * @Data:2018/12/2-10:24
 */
public class PassportInfoBOByMySql {



	/**
	 *
	 * insert into RMD_T_PASSPORT (GID, ORG_GID, PASSPORT, PASSWORD, PASSPORT_TYPE, USERTYPE_CODE, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME)
	 values (#{gid}, #{orgGid}, #{passport},#{password}, #{passportType}, #{usertypeCode}, 'system', now(), 'system', NOW())
	 * */

	/**
	 * 主键GID
	 */
	private Integer gid;
	/***
	 * 机构ID
	 */
	private Integer orgGid;
	/**
	 * 账号
	 */
	private String passport;
	/***
	 * 密码
	 */
	private String password;
	/***
	 * 账号类型
	 */
	private Integer passportType;
	/***
	 * 用户类型
	 */
	private String usertypeCode;

	/**
	 * 获取 主键GID
	 *
	 * @return gid 主键GID
	 */
	public Integer getGid() {
		return this.gid;
	}

	/**
	 * 设置 主键GID
	 *
	 * @param gid 主键GID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * 获取 机构ID
	 *
	 * @return orgGid 机构ID
	 */
	public Integer getOrgGid() {
		return this.orgGid;
	}

	/**
	 * 设置 机构ID
	 *
	 * @param orgGid 机构ID
	 */
	public void setOrgGid(Integer orgGid) {
		this.orgGid = orgGid;
	}

	/**
	 * 获取 账号
	 *
	 * @return passport 账号
	 */
	public String getPassport() {
		return this.passport;
	}

	/**
	 * 设置 账号
	 *
	 * @param passport 账号
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}

	/**
	 * 获取 密码
	 *
	 * @return password 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 设置 密码
	 *
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取 账号类型
	 *
	 * @return passportType 账号类型
	 */
	public Integer getPassportType() {
		return this.passportType;
	}

	/**
	 * 设置 账号类型
	 *
	 * @param passportType 账号类型
	 */
	public void setPassportType(Integer passportType) {
		this.passportType = passportType;
	}

	/**
	 * 获取 用户类型
	 *
	 * @return usertypeCode 用户类型
	 */
	public String getUsertypeCode() {
		return this.usertypeCode;
	}

	/**
	 * 设置 用户类型
	 *
	 * @param usertypeCode 用户类型
	 */
	public void setUsertypeCode(String usertypeCode) {
		this.usertypeCode = usertypeCode;
	}
}
