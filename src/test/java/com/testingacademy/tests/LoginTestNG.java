package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestNG extends BaseTest {
    @Test
    public void validLogin() {
        LoginPage loginPage = new LoginPage(driver);
        //Valid login
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area!"));
        driver.quit();
    }

    @Test
    public void inValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        //Invalid login
        loginPage.login("tomsmith", "SuperS!");
        Assert.assertTrue(loginPage.getFailureMessage().contains("Your password is invalid!"));
        driver.quit();
    }
}
