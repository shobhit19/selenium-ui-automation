package com.practice.contants;

import com.practice.enums.ConfigProperties;
import com.practice.utils.PropertyUtil;

public final class  FrameworkConstants {

    private FrameworkConstants() {

    }

    private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
    private static final String TITLE_REGISTERPAGE = "Register Account";
    private static final int EXPLICIT_WAIT = 10;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output";
    private static String extentReportFilePath = "";

    private static final String EXCELPATH = System.getProperty("user.dir") + "/src/testdata.xlsx";

    public static String getExtentReportFilepath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    public static String getCONFIGFILEPATH() {
        return CONFIGFILEPATH;
    }

    public static String getTitleRegisterpage() {
        return TITLE_REGISTERPAGE;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

    private static String createReportPath() {
        if (PropertyUtil.getValue(ConfigProperties.DYNAMICREPORTS).equalsIgnoreCase("yes")) {

            return EXTENTREPORTFOLDERPATH + "/" + System.currentTimeMillis() + "index.html";
        }
        else{
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }
    }
    public static String getExcelpath() {
        return EXCELPATH;
    }
}

