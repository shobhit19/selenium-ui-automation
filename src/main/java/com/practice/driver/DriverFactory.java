package com.practice.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private DriverFactory(){

    }

    // without java 8
    public static WebDriver getWebDriver(String browser){
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
           driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    // with java 8
    private static final Supplier<WebDriver> CHROME = ()-> new ChromeDriver();
    private static final Supplier<WebDriver> EDGE = ()-> new EdgeDriver();
    private static final Supplier<WebDriver> FIREFOX = ()-> new FirefoxDriver();

    private static final Map<String,Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome",CHROME);
        MAP.put("edge",EDGE);
        MAP.put("firefox",FIREFOX);
    }

    public static WebDriver WebDriverWithJava8(String browser){
        return MAP.get(browser).get();
    }
}
