package com.testingacademy.tests;

import com.testingacademy.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage(driver);
        //Valid login
        loginPage.login("tomsmith", "SuperSecretPassword!");
        System.out.println(loginPage.getSuccessMessage());

        //Invalid login
        loginPage.login("tomsmith", "SuperS!");
        System.out.println(loginPage.getFailureMessage());
    }
}
