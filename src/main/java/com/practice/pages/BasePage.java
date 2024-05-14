package com.practice.pages;

import com.practice.driver.DriverManager;
import com.practice.enums.WaitStrategy;
import com.practice.factory.ExplicitWaitFactory;
import com.practice.reporting.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {


    protected static void click(By by,WaitStrategy waitStrategy,String elementName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
        //DriverManager.getDriver().findElement(by).click();
        ExtentLogger.pass(elementName+" is clicked",true);
    }

    protected  static void sendKeys(By by,WaitStrategy waitStrategy,String elementName,String ...args){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(args);
        //DriverManager.getDriver().findElement(by).sendKeys(args);
        ExtentLogger.pass("entered text in "+elementName,true);
    }
    protected static String getPageTitle(String elementName){
        ExtentLogger.pass("Get Title of "+elementName,true);
            return DriverManager.getDriver().getTitle();
    }
}
