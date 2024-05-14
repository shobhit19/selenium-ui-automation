package com.practice.tests;

import com.practice.driver.Driver;
import com.practice.reporting.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected BaseTest(){

    }

    /**
     *  private -> protected -> default -> public
     */
    @BeforeSuite
    public void initReports(){
        ExtentReport.initReports();
    }
    @AfterSuite
    public void tearDownReports() {
        ExtentReport.flush();
    }
    @BeforeMethod
    protected void setUp(){
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}
