package com.ncvjeticanin.kpdemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.kupujemprodajem.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    public WebElement findAndCLickElementWhenAvailable(By by) {
        WebElement element = null;
        try {
             element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            System.out.println("Element not found with selector " + by.toString());
            return null;
        }
            System.out.println("Element found with selector " + by.toString());
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
        return element;
    }
}
