package com.epam.tc.hw6.utilshw6;

import static com.epam.tc.hw6.tests.BaseTest.driver;
import static org.assertj.core.api.Assertions.assertThat;
import static pages.DiffElementsPage.selectedElementsInLogPanel;
import static pages.Header.DIFF_ELEMENTS_TITLE;
import static pages.Header.HOME_PAGE_TITLE;
import static pages.Header.headerNamesExpected;
import static pages.Header.userNameLogged;
import static pages.Header.userNameLoggedExpected;
import static pages.IndexPage.expectedText;
import static pages.LeftSection.names;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.DiffElementsPage;
import pages.Header;
import pages.IndexPage;
import pages.LeftSection;

public class AssertStep extends PageObject {
    SoftAssert softAssert = new SoftAssert();
    private static final String I_FRAME_ELEMENT = "frame";

    public AssertStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert title of the page")
    public void assertTitle() {
        assertThat(driver.getTitle()).as("Wrong Page title").isEqualTo(HOME_PAGE_TITLE);
    }

    @Step("Assert login")
    public void assertLogin() {
        assertThat(userNameLogged).as("Wrong username is logged").isEqualTo(userNameLoggedExpected);
        softAssert.assertAll();
    }

    @Step("Assert 4 items in the header section with proper text")
    public void assertHeader() {
        header = new Header(driver);
        assertThat(header.getItemsTextInHeader()).as("Wrong headers are displayed").isEqualTo(headerNamesExpected);
    }

    @Step("Assert 4 images on the index page")
    public void assertImageIsDisplayed() {
        indexPage = new IndexPage(driver);
        for (WebElement i : indexPage.getImagesDisplayed()) {
            softAssert.assertTrue(i.isDisplayed());
        }
        softAssert.assertAll();
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
        driver.switchTo().frame(I_FRAME_ELEMENT);
        assertThat(indexPage.getFrameButton().isDisplayed());
    }

    @Step("5 items in the left section")
    public void assertLeftItemsText() {
        leftSection = new LeftSection(driver);
        assertThat(leftSection.getNavigationMenuText()).as("Incorrect items in the left section").isEqualTo(names);
    }

    @Step("Different elements page is opened with proper title")
    public void assertDiffElementsTitle() {
        assertThat(driver.getTitle()).as("Incorrect diff elements title is displayed").isEqualTo(DIFF_ELEMENTS_TITLE);
    }

    @Step("Clicking checkboxes and assert checkboxes are ticked")
    public void assertCheckboxes() {
        diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.waterCheckbox.isSelected());
        softAssert.assertTrue(diffElementsPage.windCheckbox.isSelected());
        softAssert.assertAll();
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
        for (String i : selectedElementsInLogPanel) {
            softAssert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + i + "')]")).isDisplayed());
        }
        softAssert.assertAll();
    }
}
