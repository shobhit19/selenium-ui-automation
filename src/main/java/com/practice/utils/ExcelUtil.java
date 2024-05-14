package com.practice.utils;

import com.practice.contants.FrameworkConstants;
import com.practice.exceptions.FrameworkException;
import com.practice.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtil {

    private ExcelUtil() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        List<Map<String,String>> list=null;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        Map<String, String> map = null;
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath())) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            list = new ArrayList<>();
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i <=rowNum; i++) {
                map = new LinkedHashMap<>();
                for (int j = 0; j < colNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            // this will take stack trace which is an array and store it in StackTraceElement[] array
            // and with array element we can set the stack trace

            /*StackTraceElement[] a=e.getStackTrace();
            a[0] = new StackTraceElement("com.practice.utils.ExcelUtil","getTestDetails","ExcelUtil.java",22);
            e.setStackTrace(a);
             */
            throw new InvalidPathForExcelException("Excel file you are trying to read is not found");


        } catch (IOException e) {
            throw new FrameworkException("Some io exception happend while reading excel file");
        }
        return list;
    }
}
