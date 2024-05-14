package com.practice.dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataProviderExcel {

    @Test(dataProvider = "getTestData2")
    public void test(Map<String,String> map){
        System.out.println(map.get("username")+"  "+map.get("password")+" "+map.get("fname")+"  "+map.get("lname"));
    }


    // This approach is only good when there are less data (rows/columns) in the excel

    // Approach 1
    @DataProvider
    public Object[][] getTestData() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\work\\document-profile-ui-automation\\src\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("testing");

        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        int colNum = sheet.getRow(0).getLastCellNum();
        Object [][] data = new Object[3][4];
        for(int i=1;i<=rowNum;i++){
            for(int j=0;j<colNum;j++){
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();

            }
        }
        return data;
    }

    // Approach 2
    @DataProvider
    public Object[][] getTestData2() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\work\\document-profile-ui-automation\\src\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("testing");

        int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        int colNum = sheet.getRow(0).getLastCellNum();
        System.out.println(colNum);

        Object [] []data = new Object[rowNum][1];
        Map<String,String> map;

        for(int i=1;i<=rowNum;i++){
            map = new LinkedHashMap<>();
            for(int j=0;j<colNum;j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key,value);
                data[i-1][0]=map;

            }
        }
        return data;
    }
}
