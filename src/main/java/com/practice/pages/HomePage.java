package com.practice.pages;

import com.practice.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class HomePage extends BasePage{

    private final By drpDownMyAcc = By.xpath("(//ul[@class='list-inline']/li)[2]");
    private final By drpDownOptRegister = By.xpath("((//ul[@class='list-inline']/li)[2]/ul/li/a[text()='Register'])[1]");
    private final By drpDownOptLogin= By.xpath("(//ul[@class='list-inline']/li)[2]/ul/li/a[text()='Login']");


    public void clickOnMenuBar() {
        BasePage.click(drpDownMyAcc, WaitStrategy.CLICKABLE,"MyAccount dropdown");
        }

    public RegisterPage moveToRegistrationPage(){
        BasePage.click(drpDownOptRegister,WaitStrategy.CLICKABLE,"Register menu option");
        return new RegisterPage();
    }
    public LoginPage moveToLoginPage(){
        BasePage.click(drpDownOptLogin,WaitStrategy.CLICKABLE,"Login menu option");
        return new LoginPage();
    }
    public String getTitle(){
       return getPageTitle("HomePage");
    }

}
