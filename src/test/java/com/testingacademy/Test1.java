package com.testingacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        login(driver, "tomsmith","SuperSecretPassword!");
        driver.quit();
    }
    public static void login(WebDriver driver, String user, String password) {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}