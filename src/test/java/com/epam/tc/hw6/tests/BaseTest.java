package com.epam.tc.hw6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
    @Parameters({"isLocal", "hub", "browser"})
    public void setupAll(@Optional("false") final boolean isLocal, final String hub, @NonNull final String browser) {
        driver = DriverFabric.getWebDriver(isLocal, hub, browser);
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
