package com.testingacademy.tests;

import com.testingacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestNG {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

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
