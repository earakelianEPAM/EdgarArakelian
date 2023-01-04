package com.epam.tc.hw4.utils;

import static com.epam.tc.hw4.tests.BaseTest.driver;
import static org.assertj.core.api.Assertions.assertThat;
import static pages.Header.DIFF_ELEMENTS_TITLE;
import static pages.Header.HOME_PAGE_TITLE;
import static pages.Header.headerNamesExpected;
import static pages.Header.userNameLogged;
import static pages.IndexPage.expectedText;
import static pages.LeftSection.names;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.DiffElementsPage;
import pages.Header;
import pages.IndexPage;
import pages.LeftSection;

public class AssertStep extends PageObject {
    SoftAssert softAssert = new SoftAssert();
    private static final String iFrameElement = "frame";

    public AssertStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert title of the page")
    public void assertTitle() {
        assertThat(driver.getTitle()).as("Wrong Page title").isEqualTo(HOME_PAGE_TITLE);
    }

    @Step("Assert login")
    public void assertLogin() {
        assertThat(userNameLogged).as("Wrong username is logged").isEqualTo("ROMAN IOVLEV");
        softAssert.assertAll();
    }

    @Step("Assert login (failed)")
    public void assertLoginFailed() {
        assertThat(userNameLogged).as("Wrong username is logged").isEqualTo("ROMAN IOVLEVV");
        softAssert.assertAll();
    }

    @Step("Assert 4 items in the header section with proper text")
    public void assertHeader() {
        header = new Header(driver);
        assertThat(header.getItemsTextInHeader()).as("Wrong headers are displayed").isEqualTo(headerNamesExpected);
    }

    @Step("Assert 4 images on the index page")
    public void assertImages() {
        indexPage = new IndexPage(driver);
        for (WebElement i : indexPage.getImagesDisplayed()) {
            softAssert.assertTrue(i.isDisplayed());
        }
    }

    @Step("Assert 4 texts on the Index Page under icons")
    public void assertTextUnderImages() {
        indexPage = new IndexPage(driver);
        assertThat(indexPage.getTextUnderImages()).as("Wrong actual text under icons").isEqualTo(expectedText);
    }

    @Step("Assert iframe with “Frame Button” exist")
    public void assertIframe() {
        indexPage = new IndexPage(driver);
        softAssert.assertTrue(indexPage.getFrameElement().isDisplayed());
        softAssert.assertAll();
    }

    @Step("Frame Button exists, Switch to the iframe and check that there is “Frame Button")
    public void assertButtonInFrame() {
        indexPage = new IndexPage(driver);
        driver.switchTo().frame(iFrameElement);
        assertThat(indexPage.getFrameButton().isDisplayed());
    }

    @Step("5 items in the left section")
    public void assertLeftItemsText() {
        leftSection = new LeftSection(driver);
        assertThat(leftSection.getNavigationMenuText()).as("Incorrect items in the left section").isEqualTo(names);
    }

    @Step("Different elements page is opened with proper title")
    public void assertDiffElementsTitle() {
        //header = new Header(driver);
        assertThat(driver.getTitle()).as("Incorrect diff elements title is displayed").isEqualTo(DIFF_ELEMENTS_TITLE);
    }

    @Step("Clicking checkboxes and assert checkboxes are ticked")
    public void assertCheckboxes() {
        diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectWaterCheckbox().isSelected());
        softAssert.assertTrue(diffElementsPage.selectWindCheckbox().isSelected());
    }

    @Step("Selecting selen radiobutton")
    public void assertRadioButton() {
        diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectSelenRadioButton().isSelected());
        softAssert.assertAll();
    }

    @Step("Select yellow dropdown")
    public void assertDropdown() {
        diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectYellowDropdown().isSelected());
        softAssert.assertAll();
    }

    @Step("Check logpanel text")
    public void assertLogpanel() {
        diffElementsPage = new DiffElementsPage(driver);
        assertThat(diffElementsPage.getWaterCheckboxLog().isDisplayed());
        assertThat(diffElementsPage.getWindCheckboxLog().isDisplayed());
        assertThat(diffElementsPage.getMetalRadiobuttonLog().isDisplayed());
        assertThat(diffElementsPage.getColorsDropdownLog().isDisplayed());
        softAssert.assertAll();
    }
}
