package com.practice.driver;

import com.practice.enums.ConfigProperties;
import com.practice.exceptions.BrowserInvocationFailedException;
import com.practice.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class Driver {

    private Driver(){

    }
    private static WebDriver driver;


    public static void initDriver(){
        String runmode = PropertyUtil.getValue(ConfigProperties.RUNMODE);
        if(Objects.isNull(DriverManager.getDriver())) {
//                WebDriverManager.chromedriver().setup();
                if(runmode.equalsIgnoreCase("remote")){
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    try {
                        DriverManager.setDriver(new RemoteWebDriver(new URL(PropertyUtil.getValue(ConfigProperties.GRIDURL)),options));
                    } catch (MalformedURLException e) {
                        throw new BrowserInvocationFailedException("Please check the capabilities of browser");
                    }
                }
                else {
                    DriverManager.setDriver(DriverFactory.WebDriverWithJava8(PropertyUtil.getValue(ConfigProperties.BROWSER)));
                }
            }
            DriverManager.getDriver().get(PropertyUtil.getValue(ConfigProperties.URL));
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
