package com.practice.tests;

import com.practice.contants.FrameworkConstants;
import com.practice.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class RegisterPageTests extends BaseTest {


    private RegisterPageTests() {}


    @Test
    public void validateNavigationToRegisterPage() {
        HomePage homePage = new HomePage();
        homePage.clickOnMenuBar();
        homePage.moveToRegistrationPage();
        Assert.assertEquals(homePage.getTitle(),FrameworkConstants.getTitleRegisterpage());
    }
}
