package com.testingacademy.tests;

import com.testingacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestNG {
    @Test
    public void validLogin() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        //Valid login
        loginPage.login("tomsmith", "SuperSecretPassword!");
        System.out.println(loginPage.getSuccessMessage());
        driver.quit();
    }

    @Test
    public void inValidLogin() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        //Invalid login
        loginPage.login("tomsmith", "SuperS!");
        System.out.println(loginPage.getFailureMessage());
        driver.quit();
    }
}
