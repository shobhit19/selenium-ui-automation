package com.practice.tests;

import com.practice.pages.AccountPage;
import com.practice.pages.HomePage;
import com.practice.pages.LoginPage;
import com.practice.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public final class LoginPageTests extends BaseTest {

    private LoginPageTests() {}

    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void validateLogin(Map<String,String> map){
        HomePage homePage = new HomePage();
        homePage.clickOnMenuBar();
        LoginPage loginPage = homePage.moveToLoginPage();
        AccountPage accountPage=loginPage.login(map.get("username"),map.get("password"));
        Assert.assertEquals(new AccountPage().getTitle(),"My Account");
    }

//    @DataProvider
//    public Object[][] getData(){
//        return new Object[][]{
//                {"test1091@gmail.com","^^^^"},
//                {"iuegf@gmail.com","password"},
//                {"dwd6@gmail.com","wd7712"},
//                {"test1091@gmail.com","password"}
//        };
//    }


}
