package com.alemand.resolve.dto;

/***
 * @ClassName:
 * @Description：
 * @author：周学胜
 * @Date:2018/12/26、20:54
 */
public class AddUserDto {


    private String roleIds;

    /**
     * 应用ID
     */
    private String appId;

    /***
     * 账户名
     */
    private String passport;
    /***
     * 密码
     */
    private String password;

    /***
     * 机构ID
     */
    private String orgGid;

    /***
     * 电话
     */
    private String tel;
    /***
     * 姓名
     */
    private String realName;

    /***
     * 昵称
     */
    private String nickName;


    /**
     * 性别  0女 1男
     */
    private String sex;
    /***
     * 邮箱
     */
    private String email;

    /***
     * 头像
     */
    private String headerPic;

    /***
     * 固定电话
     */
    private String fixedTel;


    private Integer adminState;

    /**
     * 获取 账户名
     *
     * @return passport 账户名
     */
    public String getPassport() {
        return this.passport;
    }

    /**
     * 设置 账户名
     *
     * @param passport 账户名
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
     * 获取 机构ID
     *
     * @return orgGid 机构ID
     */
    public String getOrgGid() {
        return this.orgGid;
    }

    /**
     * 设置 机构ID
     *
     * @param orgGid 机构ID
     */
    public void setOrgGid(String orgGid) {
        this.orgGid = orgGid;
    }

    /**
     * 获取 电话
     *
     * @return tel 电话
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * 设置 电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
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
     * 获取 性别  0女 1男
     *
     * @return sex 性别  0女 1男
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * 设置 性别  0女 1男
     *
     * @param sex 性别  0女 1男
     */
    public void setSex(String sex) {
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
     * 获取 头像
     *
     * @return headerPic 头像
     */
    public String getHeaderPic() {
        return this.headerPic;
    }

    /**
     * 设置 头像
     *
     * @param headerPic 头像
     */
    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }

    /**
     * 获取 固定电话
     *
     * @return fixedTel 固定电话
     */
    public String getFixedTel() {
        return this.fixedTel;
    }

    /**
     * 设置 固定电话
     *
     * @param fixedTel 固定电话
     */
    public void setFixedTel(String fixedTel) {
        this.fixedTel = fixedTel;
    }


    /**
     * 获取 应用ID
     *
     * @return appId 应用ID
     */
    public String getAppId() {
        return this.appId;
    }

    /**
     * 设置 应用ID
     *
     * @param appId 应用ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }


    /**
     * 获取
     *
     * @return adminState
     */
    public Integer getAdminState() {
        return this.adminState;
    }

    /**
     * 设置
     *
     * @param adminState
     */
    public void setAdminState(Integer adminState) {
        this.adminState = adminState;
    }


    /**
     * 获取
     *
     * @return roleIds
     */
    public String getRoleIds() {
        return this.roleIds;
    }

    /**
     * 设置
     *
     * @param roleIds
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "AddUserDto{" +
                "roleIds='" + roleIds + '\'' +
                ", appId='" + appId + '\'' +
                ", passport='" + passport + '\'' +
                ", password='" + password + '\'' +
                ", orgGid='" + orgGid + '\'' +
                ", tel='" + tel + '\'' +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", headerPic='" + headerPic + '\'' +
                ", fixedTel='" + fixedTel + '\'' +
                ", adminState=" + adminState +
                '}';
    }
}
