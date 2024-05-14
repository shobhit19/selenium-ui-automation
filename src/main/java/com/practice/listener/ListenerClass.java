package com.practice.listener;

import com.practice.reporting.ExtentLogger;
import com.practice.reporting.ExtentReport;
import com.practice.utils.ElkUtils;
import org.testng.*;

import java.util.Arrays;

public class ListenerClass implements ISuiteListener, ITestListener {

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {

    }
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
        ElkUtils.sendResultsToElk(result.getMethod().getDescription(),"pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+"is failed, attaching screenshot",true);
        // attaching logs for failed cases
        // it will give first line of the error message
        ExtentLogger.fail(result.getThrowable().toString());
        //
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        ElkUtils.sendResultsToElk(result.getMethod().getDescription(),"fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
        ElkUtils.sendResultsToElk(result.getMethod().getDescription(),"skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
