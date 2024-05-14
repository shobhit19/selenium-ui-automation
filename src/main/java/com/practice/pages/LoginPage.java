package com.practice.pages;

import com.practice.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class LoginPage extends BasePage {

    private final By txtEmail = By.id("input-email");
    private final By txtPassword = By.id("input-password");
    private final By btnLogin = By.xpath("//input[@value='Login']");


    public AccountPage login(String username,String password){
        BasePage.sendKeys(txtEmail, WaitStrategy.VISIBLE,"username",username);
        BasePage.sendKeys(txtPassword,WaitStrategy.VISIBLE,"password",password);
        BasePage.click(btnLogin,WaitStrategy.CLICKABLE,"submit button");
        return new AccountPage();

    }

}