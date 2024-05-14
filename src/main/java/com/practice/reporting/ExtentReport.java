package com.practice.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.practice.contants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public final class ExtentReport {
    private static ExtentReports extentReports;
    private ExtentReport(){

    }

    public static void initReports() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilepath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setReportName("Selenium Report");
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("Practice Automation Report");
        }
    }
    public static void flush()  {
        if(Objects.nonNull(extentReports)) {
            extentReports.flush();
            ExtentManager.unload();
            try {
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilepath()).toURI());
            }
            catch (Exception e){

            }
        }
    }
    public static void createTest(String testCaseName){
        ExtentTest test =extentReports.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }
}
