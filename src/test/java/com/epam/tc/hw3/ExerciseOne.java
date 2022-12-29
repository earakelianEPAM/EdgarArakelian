package com.epam.tc.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.Header.HOME_PAGE_TITLE;
import static pages.Header.headerNamesExpected;
import static pages.Header.userNameLogged;
import static pages.IndexPage.expectedText;
import static pages.LeftSection.names;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Header;
import pages.IndexPage;
import pages.LeftSection;

public class ExerciseOne extends BaseTest {
    Header header;
    IndexPage indexPage;
    SoftAssert softAssert = new SoftAssert();
    private static final String iFrameElement = "frame";

    @Test(description = "1-2. Opening test site and assert browser title", priority = 1)
    public void checkPageTitle() {
        assertThat(driver.getTitle()).as("Wrong Page title").isEqualTo(HOME_PAGE_TITLE);
    }

    @Test(description = "3-4. Login and assert username is loggined", priority = 2)
    public void verifyUserIsLogged() {
        header = new Header(driver);
        header.loginToPage();
        assertThat(header.getUsernameIsLogged()).as("Wrong username is logged").isEqualTo(userNameLogged);
    }

    @Test (description = "5. Assert 4 items in the header section with proper text", priority = 3)
    public void verifyIndexPageItemsText() {
        header = new Header(driver);
        assertThat(header.getItemsTextInHeader()).as("Wrong headers are displayed").isEqualTo(headerNamesExpected);
    }

    @Test (description = "6. Assert 4 images on the index page", priority = 4)
    public void verifyImagesAreDisplayed() {
        indexPage = new IndexPage(driver);
        for (WebElement i : indexPage.getImagesDisplayed()) {
            softAssert.assertTrue(i.isDisplayed());
        }
    }

    @Test (description = "7. Assert that there are 4 texts on the Index Page under icons", priority = 5)
    public void checkTextUnderImage() {
        indexPage = new IndexPage(driver);
        assertThat(indexPage.getTextUnderImages()).as("Wrong actual text under icons").isEqualTo(expectedText);

    }

    @Test (description = "8. Assert that there is the iframe with “Frame Button” exist", priority = 6)
    public void checkIframeIsDisplayed() {
        indexPage = new IndexPage(driver);
        softAssert.assertTrue(indexPage.getFrameElement().isDisplayed());
        softAssert.assertAll();
    }

    @Test (description = "9-10. “Frame Button” exist, Switch to the iframe and check that there is “Frame Button",
            priority = 7)
    public void checkButtonInFrame() {
        indexPage = new IndexPage(driver);
        driver.switchTo().frame(iFrameElement);
        assertThat(indexPage.getFrameButton().isDisplayed());
    }

    @Test (description = "11. 5 items in the left section", priority = 8)
    public void verifyLeftItemsText() {
        LeftSection leftSection = new LeftSection(driver);
        assertThat(leftSection.getNavigationMenuText()).as("Incorrect items in the left section").isEqualTo(names);

    }
}
