package com.epam.tc.hw6.utilsHw6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Header;

import static com.epam.tc.hw6.tests.BaseTest.IMPLICIT_WAIT;
import static com.epam.tc.hw6.tests.BaseTest.driver;
import static pages.Header.diffElementsMenuItem;

public class ActionStep extends PageObject {
    public ActionStep(WebDriver driver) {
        super(driver);
    }
    @Step("Login to the Index Page")
    public void loginToIndexPage() {
        header.loginToPage();
    }

    @Step("Click To Different Elements page")
    public void clickToDifferentElements() {
        header = new Header(driver);
        header.clickServiceMenu();
        new WebDriverWait(driver, IMPLICIT_WAIT).until(ExpectedConditions
                .presenceOfElementLocated(By.partialLinkText(diffElementsMenuItem)));
        header.clickDiffElements();
    }

    @Step("Select Water and Wind Checkboxes")
    public void selectCheckboxes() {
        diffElementsPage.selectWaterCheckbox();
        diffElementsPage.selectWindCheckbox();
    }

    @Step("Click on selen radio button")
    public void clickOnRadioButton() {
        diffElementsPage.selectSelenRadioButton();
    }

    @Step("Select yellow Dropdown Item")
    public void selectDropdown() {
        diffElementsPage.selectYellowDropdown();
    }
}
