package com.epam.tc.hw5.pages.steps;

import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.pages.HomePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    private WebDriver webDriver = TestContext.getInstance().getObject(TestContext.WEB_DRIVER);


    @Given("I open JDI GitHub site")
    public void openUrl() {
        new HomePage(webDriver).openPageUrl();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void signIn() {
        new HomePage(webDriver).userAccountMenu.authorizeUser();
    }

    @Given("I click on {string} button in Header")
    public void clickMenubarItem(String button) {
        new HomePage(webDriver).header.clickHeaderItem(button);
    }

    @Given("I click on {string} button in Service dropdown")
    public void clickInServiceDropdown(String button) {
        new HomePage(webDriver).header.clickServiceItem(button);
    }
}
