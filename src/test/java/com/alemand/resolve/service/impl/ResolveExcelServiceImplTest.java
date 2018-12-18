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

        //File file =  new File("D:\\excel\\1418\\01.xls");
        //String fileName=  "D:\\excel\\1418\\01.xls";
        String fileName=  "D:\\excel\\1418\\06.xls";
        try {
            resolveExcelService.resolveExcel(fileName);
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }
}