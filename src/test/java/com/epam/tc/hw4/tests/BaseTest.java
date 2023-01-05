package com.epam.tc.hw4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static WebDriver driver;
    public static final int IMPLICIT_WAIT = 5;
    private static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public static String getURL() {
        return URL;
    }

    @BeforeSuite
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    static void setupAll() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();

    }

    @AfterClass
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

