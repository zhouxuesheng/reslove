package com.alemand.resolve.service;

import com.alemand.resolve.entity.MarcBo;
import com.alemand.resolve.entity.UserInfoBO;
import com.alemand.resolve.response.BusinessException;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * <p>
 * 类说明
 * </p>
 *
 * @author Alemand
 * @since 2018/3/19
 */
public interface ResolveExcelService {


    /**
     * 解析Excel
     *
     * @param file 文件
     * @return 得到的结果
     * @throws BusinessException 业务异常统一处理
     */
	List<UserInfoBO> resolveExcel(String  fileName) throws BusinessException;


}
