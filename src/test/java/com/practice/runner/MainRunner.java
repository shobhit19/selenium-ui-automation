package com.practice.runner;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class MainRunner {

    static TestNG testng;

    public static void main(String []args){
        testng = new TestNG();
        String path = System.getProperty("user.dir")+"/testng.xml";
        List<String> xmlList = new ArrayList<>();
        xmlList.add(path);

        testng.setTestSuites(xmlList);
        testng.run();
    }
}
