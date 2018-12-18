package com.alemand.resolve.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import com.alemand.resolve.entity.PassPortOrg;
import com.alemand.resolve.entity.PassportInfoBO;
import com.alemand.resolve.entity.PassportInfoDetailBO;
import com.alemand.resolve.entity.UserCardcodeBO;

@Mapper
public interface UserInfoDAO {

	public void insertPassportInfo(PassportInfoBO infoBO);
	
	public void insertPassportInfoDetail(PassportInfoDetailBO detailBO);
	
	public void insertUserCardCode(UserCardcodeBO cardcodeBO);
	
	public void insertPassporOrg(PassPortOrg passPortOrg );
}
