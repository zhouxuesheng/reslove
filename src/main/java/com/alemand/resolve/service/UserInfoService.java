package com.alemand.resolve.service;

import java.util.List;

import com.alemand.resolve.dto.AddUserDto;
import com.alemand.resolve.entity.UserInfoBO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserInfoService {

	
	/***
	 * 批量插入用户数据
	 * @param list
	 */
	public void batchInsertUserInfo(List<UserInfoBO> list,String orgName,String orgGid);


	/***
	 * @Description： 批量插入读者信息
	 * @params:[list] exce 读取的用户列表
	 * @return:void
	 * @throw:
	 * @Author: 周学胜
	 * @Data:2018/12/2、10:50
	 */
	public void batchInsertUserInfoByMySql(List<UserInfoBO> list,String orgName,String orgGid);

//
//	/***
//	 * 批量添加用户Mysql 2.0
//	 * @param addUserDto
//	 */
//	public void batchRegisterUser(AddUserDto addUserDto);
}
