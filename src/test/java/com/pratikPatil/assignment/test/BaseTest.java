package com.pratikPatil.assignment.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static void setupDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return null;
    }
}
