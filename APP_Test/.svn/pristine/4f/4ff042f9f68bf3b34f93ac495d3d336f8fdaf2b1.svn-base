package com.cmcc.p.poc.automation.test;

import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.*;

public class DataTest{
    
    public static Object[][] readFromExcel_o(String dataFile,String sheetName,int rowNum) throws IOException {

     ArrayList<Object> list = new ArrayList<Object>();

     Object[][] data = null;

     //创建workbook
     File file = new File(dataFile);
     HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));

     // 读取excel数据
     // 获得指定的excel表   
     HSSFSheet sheet = workbook.getSheet(sheetName);
     // 获取表格的总行数
     int rowCount = sheet.getLastRowNum() + 1;
     // 获取表头的列数
     int columnCount = sheet.getRow(0).getLastCellNum();


//     将表格中的 值传到一个list中
     if(sheet!=null){
         for(int i=1;i<=rowCount-1;i++){
             for(int j=0;j<columnCount;j++){
                 HSSFRow row = sheet.getRow(i);
                 String concent = row.getCell(j).toString();
                 list.add(concent);
             }
         }
     }

     if (rowNum<=0||rowNum>=rowCount){
         data = new Object[rowCount-1][columnCount] ;
         int k=-1;
         for (int i=0;i<rowCount-1;i++){
             for (int j=0;j<columnCount;j++){
                 if (k<list.size()){
                     k++;
                 }
                 String concent = list.get(k).toString();
                 data[i][j]=list.get(k);
             }
         }
     }else {
         int k=-1;
         data = new Object[rowNum][columnCount];
         for (int i=0;i<rowNum-1;i++){
             for (int j=0;j<columnCount-1;j++){
                 if (k<list.size()){
                     data[i][j]=list.get(k);
                 }
             }
         }
     }
     workbook.close();
     return data;
 }

}
