package com.alemand.resolve.dao;

import com.alemand.resolve.entity.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDAOByMySql {

	public void insertPassportInfo(PassportInfoBOByMySql infoBO);

	public void insertPassportInfoDetail(PassportInfoDetailBOByMySql detailBO);

	public void insertUserCardCode(UserCardcodeBOByMySql cardcodeBO);

}
