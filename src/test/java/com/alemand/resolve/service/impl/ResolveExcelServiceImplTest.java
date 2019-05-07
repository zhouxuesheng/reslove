package com.alemand.resolve.service.impl;

import com.alemand.resolve.response.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResolveExcelServiceImplTest {


    @Autowired
    private ResolveExcelServiceImpl resolveExcelService;

    @Test
    public void resolveExcel() {



//	private static Integer orgGid =1418;
//	private static String orgGids ="1418";
//	private static String orgName="兰州大学";


        String orgGids ="1837";
	    String orgName="辽宁中医药大学图书馆";

        //File file =  new File("D:\\excel\\1418\\01.xls");
        //String fileName=  "D:\\excel\\1418\\01.xls";
        //String fileName=  "D:\\excel\\1418\\06.xls";
        String fileName = "D:\\excel\\1837\\02.xls";
        try {
            resolveExcelService.resolveExcel(fileName,orgName,orgGids);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }
}