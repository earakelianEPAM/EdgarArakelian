package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class CommonAction {
    protected WebDriver driver;
    protected static final int IMPLICIT_WAIT = 10;
    protected String url = "https://jdi-testing.github.io/jdi-light/index.html";
    //for exercises 1-2, description 1-2, 3-4
    protected String homePageTitle = "Home Page";
    protected String loginElement = "user-icon";
    protected String loginForm = "login-form";
    protected String usernameId = "name";
    protected String userNameElement = "user-name";
    protected String userNameLogged = "ROMAN IOVLEV";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();

    }
}
