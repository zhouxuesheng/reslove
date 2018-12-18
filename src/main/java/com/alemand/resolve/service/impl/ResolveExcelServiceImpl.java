package com.alemand.resolve.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.alemand.resolve.entity.MarcBo;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alemand.resolve.entity.UserInfoBO;
import com.alemand.resolve.response.BusinessException;
import com.alemand.resolve.response.ReturnCode;
import com.alemand.resolve.service.ResolveExcelService;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

/**
 * <p>
 * 类说明
 * </p>
 *
 * @author Alemand
 * @since 2018/3/19
 */
@Service("resolveExcelServiceImpl")
public class ResolveExcelServiceImpl implements ResolveExcelService {
	
	@Autowired
	private UserInfoServiceImpl userInfoServiceImpl;
	
	
    /**
     *打印日志
     */
    private static final Log logger = LogFactory.get();
    /**
     * 注册url
     */
    private static final String SUFFIX_2003 = ".XLS";
    private static final String SUFFIX_2007 = ".XLSX";
    /**
     * 电话的正则
     */
    public static final String PHONE_NUMBER_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[01356789]|18[0-9]|19[89])\\d{8}$";
    /**
     * 密码长度
     */
    public static final int passWardLength = 6;

    @Override
    public List<UserInfoBO> resolveExcel(String  fileName) throws BusinessException {

    	
    	File file =  new File(fileName);
    	
        List<UserInfoBO> list = new ArrayList<>();
//        if (file == null) {
//            throw new BusinessException(ReturnCode.CODE_FAIL, "对象不能为空");
//        }
        //获取名字
        String originalFilename = file.getName().toUpperCase();
        FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        Workbook workbook = null;
        try {
            if (originalFilename.endsWith(SUFFIX_2003)) {
                workbook = new HSSFWorkbook(fileInputStream);
            } else if (originalFilename.endsWith(SUFFIX_2007)) {
                workbook = new XSSFWorkbook(fileInputStream);
            }
        } catch (Exception e) {
            logger.info(originalFilename);
            e.printStackTrace();
            throw new BusinessException(ReturnCode.CODE_FAIL, "格式错误");
        }
        if (workbook == null) {
            logger.info(originalFilename);
            throw new BusinessException(ReturnCode.CODE_FAIL, "格式错误");
        } else {
            //获取所有的工作表的的数量
            int numOfSheet = workbook.getNumberOfSheets();
            //遍历这个这些表
            for (int i = 0; i < numOfSheet; i++) {
                //获取一个sheet也就是一个工作簿
                Sheet sheet = workbook.getSheetAt(i);
                int lastRowNum = sheet.getLastRowNum();
                //从第一行开始第一行一般是标题
                for (int j = 1; j <= lastRowNum; j++) {
                    Row row = sheet.getRow(j);
                    //ReqImportClient reqImportClient = new ReqImportClient();
                    UserInfoBO bo = new UserInfoBO();
                    
                    //获取证件号单元格
                    if (row.getCell(0) != null) {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                       
                        
                        String cardCode = row.getCell(0).getStringCellValue();
                        if(org.springframework.util.StringUtils.isEmpty(cardCode)) {

                        	throw new BusinessException(ReturnCode.CODE_FAIL, "证件号为空");
                        }
                        bo.setCardCode(cardCode);
                    }
                    //姓名
                    if (row.getCell(1) != null) {
                        row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        String nickName = row.getCell(1).getStringCellValue();
                        
                        if(org.springframework.util.StringUtils.isEmpty(nickName)) {
                        	throw new BusinessException(ReturnCode.CODE_FAIL, "姓名为空");
                        }
                        bo.setNickName(nickName);
                    }
                    //性别
                    if (row.getCell(2) != null) {
                        row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                        
                        String sex = row.getCell(2).getStringCellValue();
                        bo.setSex(sex);
                    }
                    //院系
                    if (row.getCell(3) != null) {
                        row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        String denp = row.getCell(3).getStringCellValue();
                        
                        bo.setDenp(denp);
                    }
                  //读者类型
                    if (row.getCell(4) != null) {
                        row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                        String readerType = row.getCell(4).getStringCellValue();
                        
                        if(org.springframework.util.StringUtils.isEmpty(readerType)) {
                        	readerType = "学生";
//                        	throw new BusinessException(ReturnCode.CODE_FAIL, "读者类型为空");
                        }
                        
                        bo.setReaderType(readerType);
                    }
                    
                    list.add(bo);
                }
            }
        }

        userInfoServiceImpl.batchInsertUserInfo(list);
//        userInfoServiceImpl.batchInsertUserInfoByMySql(list);
        return list;
    }
}
