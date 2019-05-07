package com.alemand.resolve.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.alemand.resolve.dao.UserInfoDAOByMySql;
import com.alemand.resolve.dto.AddUserDto;
import com.alemand.resolve.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alemand.resolve.dao.UserInfoDAO;
import com.alemand.resolve.service.UserInfoService;
import org.springframework.util.StringUtils;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Autowired
	private UserInfoDAOByMySql userInfoDAOByMySql;


//	private static String orgGids ="302835";
//	private static String orgName="甘肃农业大学";
	
//	private static Integer orgGid =1418;
//	private static String orgGids ="1418";
//	private static String orgName="兰州大学";

//	private static Integer orgGid =300403;
//	private static String orgGids ="300403";
//	private static String orgName="北京交通大学图书馆";

	
//	private static Integer orgGid =301191;
//	private static String orgGids ="301191";
//	private static String orgName="安徽国防科技职业学院";
	
	@Override
	@Transactional
	public void batchInsertUserInfo(List<UserInfoBO> list,String orgName,String orgGids) {
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
		list.forEach(bo -> {

			//insert into passport_info (GID, PASSPORT, USER_PSW, STATUS, NICK_NAME, USER_TEL, PASSPORT_TYPE, USERTYPE_CODE, UPDATE_FLAG, CREATE_DATE)
			// values (#{gid}, #{passport}, '123456', 1, #{nickName}, '', 4, '01', 0, sysdate)

			//
			String passport = NumberUtil.getRandomNun(8);

			String passportGid = String.valueOf(idWorker.nextId());

			PassportInfoBO infoBO = new PassportInfoBO();
			infoBO.setGid(passportGid);
			infoBO.setPassport(passport);
			infoBO.setNickName(bo.getNickName().trim());

			userInfoDAO.insertPassportInfo(infoBO);
			//	insert into PASSPORT_INFO_DETAIL (gid,PASSPORT_GID,REAL_NAME,SEX,DEPARTMENT,READER_TYPE)
			// values (#{gid},#{passportGid},#{realName},#{sex},#{department},#{readerType})
			PassportInfoDetailBO detailBO = new PassportInfoDetailBO();
			String detailGid = String.valueOf(idWorker.nextId());
			detailBO.setGid(detailGid);
			detailBO.setPassportGid(passportGid);
			if(StringUtils.isEmpty(bo.getNickName())){
				detailBO.setRealName("");
			}else{
				detailBO.setRealName(bo.getNickName().trim());
			}


			if(bo.getSex()==null){
				detailBO.setSex("-1");
			}else{
				detailBO.setSex(bo.getSex() == "女" ? "0":"1");
			}
			if(StringUtils.isEmpty(bo.getDenp())){
				detailBO.setDepartment("");
			}else{
				detailBO.setDepartment(bo.getDenp().trim());
			}
			if(StringUtils.isEmpty(bo.getReaderType())){
				detailBO.setReaderType("");
			}else{
				detailBO.setReaderType(bo.getReaderType().trim());
			}

			detailBO.setSchoolName(orgName);
			userInfoDAO.insertPassportInfoDetail(detailBO);


			//insert into user_cardcode (GID, CARD_CODE, CARD_PSW, MARK, PASSPORT_GID, ORG_GID, SUBMIT_TIME, CODE_STATUS, MAX_COPY, USER_TYPE, READER_TYPE, DEPT, NAME, USER_GID)
			//values (#{gid}, #{cardCode}, '123456', '', #{passportGid}, #{orgGid}, to_date(#{submitTime}, 'yyyy-mm-dd hh24:mi:ss'), 1, null, '', #{readerType}, #{dept}, #{name}, '');

			UserCardcodeBO cardcodeBO = new UserCardcodeBO();
			String cardGid = String.valueOf(idWorker.nextId());
			cardcodeBO.setGid(cardGid);
			if(StringUtils.isEmpty(bo.getCardCode())){
				cardcodeBO.setCardCode("");
			}else{
				cardcodeBO.setCardCode(bo.getCardCode().trim());
			}

			cardcodeBO.setPassportGid(passportGid);
			cardcodeBO.setOrgGid(orgGids);
//			cardcodeBO.setSubmitTime(LocalDateTime.now());
			if(StringUtils.isEmpty(bo.getReaderType())){
				cardcodeBO.setReaderType("");
			}else{
				cardcodeBO.setReaderType(bo.getReaderType().trim());
			}
			if(StringUtils.isEmpty(bo.getDenp())){
				cardcodeBO.setDept("");
			}else{
				cardcodeBO.setDept(bo.getDenp().trim());
			}
			if(StringUtils.isEmpty(bo.getNickName())){
				cardcodeBO.setName("");
			}else{
				cardcodeBO.setName(bo.getNickName().trim());
			}

			cardcodeBO.setPassport(passport);
			userInfoDAO.insertUserCardCode(cardcodeBO);

			PassPortOrg passPortOrg = new PassPortOrg();
			String passPortOrgGid = String.valueOf(idWorker.nextId());
			passPortOrg.setGid(passPortOrgGid);
			passPortOrg.setOrgGid(orgGids);
			passPortOrg.setPassportGid(passportGid);

			userInfoDAO.insertPassporOrg(passPortOrg);
		});

	}

	@Override
	@Transactional
	public void batchInsertUserInfoByMySql(List<UserInfoBO> list,String orgName,String orgGid) {
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
		list.forEach(bo -> {

//			insert into RMD_T_PASSPORT (GID, ORG_GID, PASSPORT, PASSWORD, PASSPORT_TYPE, USERTYPE_CODE, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME)
//			values (#{gid}, #{orgGid}, #{passport},#{password}, #{passportType}, #{usertypeCode}, 'system', now(), 'system', NOW())

			//insert into RMD_T_PASSPORT (GID, ORG_GID, PASSPORT, PASSWORD, PASSPORT_TYPE, USERTYPE_CODE, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME)
			// values ('123456', 1660, 'R00001', '123456', 5, '01', 'system', now(), 'system', NOW());
			String passport = NumberUtil.getRandomNun(8);

			Integer passportGid = Integer.valueOf(NumberUtil.getRandomNun(8));

			PassportInfoBOByMySql infoBO = new PassportInfoBOByMySql();
			infoBO.setGid(passportGid);
			infoBO.setOrgGid(Integer.valueOf(orgGid));
			infoBO.setPassport(bo.getCardCode().trim());
			infoBO.setPassword("123456");
			infoBO.setPassportType(5);
			infoBO.setUsertypeCode("01");
			userInfoDAOByMySql.insertPassportInfo(infoBO);

			// insert into RMD_T_PASSPORT_DETAIL (GID,PASSPORT_GID,NICK_NAME,TEL_PHONE,REAL_NAME,SEX,EMAIL,HEADER_IMG,DEPT,ADDRESS,MARK,CREATE_ID,CREATE_TIME,UPDATE_ID,UPDATE_TIME)
			// values ('111110','123456','张三昵称','13211223344','张三',1,'344819956@qq.com',null,'三新文化','联系地址','备注', 'system', now(), 'system', NOW());


			PassportInfoDetailBOByMySql detailBO = new PassportInfoDetailBOByMySql();
			Integer passportDetailGid =  Integer.valueOf(NumberUtil.getRandomNun(8));
			detailBO.setGid(passportDetailGid);
			detailBO.setPassportgid(passportGid);
			detailBO.setNickName(bo.getNickName().trim());
			//detailBO.setTelPhone("13211223344");
			detailBO.setRealName(bo.getNickName());
			detailBO.setSex(bo.getSex()=="男"?1:0);
			//detailBO.setEmail("");
			detailBO.setDept(bo.getDenp());

			userInfoDAOByMySql.insertPassportInfoDetail(detailBO);

//			INSERT INTO RMD_T_PASSPORT_CARD ( GID, CARD_CODE, PASSPORT_GID, READER_TYPE, READER_TYPE_NAME, CREATE_ID, CREATE_TIME, UPDATE_ID, UPDATE_TIME)
//			VALUES ( '111113', 'R00001', '123456', '01', '学生', 'system', now(), 'system', NOW());

			UserCardcodeBOByMySql cardcodeBO = new UserCardcodeBOByMySql();
			Integer cardcodeGid =  Integer.valueOf(NumberUtil.getRandomNun(8));
			cardcodeBO.setGid(cardcodeGid);
			cardcodeBO.setCardCode(bo.getCardCode().trim());
			cardcodeBO.setPassportgid(passportGid);
			cardcodeBO.setReaderType("02");
			cardcodeBO.setReaderTypeName("老师");
			userInfoDAOByMySql.insertUserCardCode(cardcodeBO);


		});

	}

}
