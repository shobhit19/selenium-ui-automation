package com.practice.listener;

import com.practice.enums.ConfigProperties;
import com.practice.utils.PropertyUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    private int count = 0;
    private int retries = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
            if (PropertyUtil.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
                value = count < retries;
                count++;
            }
        return value;
    }
}
