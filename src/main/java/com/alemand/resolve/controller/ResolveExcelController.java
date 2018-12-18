package com.alemand.resolve.controller;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alemand.resolve.response.ApiResponse;
import com.alemand.resolve.response.BusinessException;
import com.alemand.resolve.service.ResolveExcelService;

/**
 * <p>
 * 类说明
 * </p>
 *
 * @author Alemand
 * @since 2018/3/19
 */
@RestController
@RequestMapping("/resolve")
public class ResolveExcelController {


    @Resource(name = "resolveExcelServiceImpl")
    private ResolveExcelService resolveExcelService;



    /**
     * 文件上传
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse uploadExcel(String orgName,String orgGid) {
        Object result;
        try {
        	//File file =  new File("D:\\excel\\1418\\01.xls");
        	
            result = resolveExcelService.resolveExcel("D:\\excel\\1418\\01.xls", orgName, orgGid);
            //如果需要将文件放到服务其中加以下代码
           /* try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        } catch (BusinessException e) {
            e.printStackTrace();
            return ApiResponse.failOf(-1, e.getErrMsg());
        }
        return ApiResponse.successOf(result);
    }


}
