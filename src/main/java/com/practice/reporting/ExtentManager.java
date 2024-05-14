package com.practice.reporting;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){

    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return extTest.get();
    }

    public static void setExtentTest(ExtentTest test){
        extTest.set(test);
    }
    public static void unload(){
        extTest.remove();
    }
}
