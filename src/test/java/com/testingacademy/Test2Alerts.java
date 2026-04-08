package com.testingacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2Alerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        JsAlertAccept(driver);
        JsConfirmAccept(driver);
        JsConfirmDismiss(driver);
        JsPromptAccept(driver);
        JsPromptDismiss(driver);
        driver.quit();
    }
    public static void printResult(WebDriver driver) {
        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());
    }
    public static void JsAlertAccept(WebDriver driver) {
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]"));
        jsAlert.click();
        Alert alert =  driver.switchTo().alert();
        alert.accept();
        printResult(driver);
    }

    public static void JsConfirmAccept(WebDriver driver) {
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
        jsAlert.click();
        Alert alert =  driver.switchTo().alert();
        alert.accept();
        printResult(driver);
    }

    public static void JsConfirmDismiss(WebDriver driver) {
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
        jsAlert.click();
        Alert alert =  driver.switchTo().alert();
        alert.dismiss();
        printResult(driver);
    }

    public static void JsPromptAccept(WebDriver driver) {
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
        jsAlert.click();
        Alert alert =  driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.accept();
        printResult(driver);
    }

    public static void JsPromptDismiss(WebDriver driver) {
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
        jsAlert.click();
        Alert alert =  driver.switchTo().alert();
        alert.sendKeys("Test");
        alert.dismiss();
        printResult(driver);
    }
}
