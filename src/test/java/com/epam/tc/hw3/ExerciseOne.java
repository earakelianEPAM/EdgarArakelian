package com.epam.tc.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.Header.headerNamesExpected;
import static pages.Header.homePageTitle;
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
    SoftAssert softAssert = new SoftAssert();
    private static final String iFrameElement = "frame";

    @Test(description = "1-2. Opening test site and assert browser title", priority = 1)
    public void checkPageTitle() {
        assertThat(driver.getTitle()).isEqualTo(homePageTitle);
    }

    @Test(description = "3-4. Login and assert username is loggined", priority = 2)
    public void verifyUserIsLogged() {
        Header header = new Header(driver);
        header.loginToPage();
        assertThat(header.romanLogged()).isEqualTo(userNameLogged);
    }

    @Test (description = "5. Assert 4 items in the header section with proper text", priority = 3)
    public void verifyIndexPageItemsText() {
        Header header = new Header(driver);
        assertThat(header.itemsInHeader()).isEqualTo(headerNamesExpected);
    }

    @Test (description = "6. Assert 4 images on the index page", priority = 4)
    public void verifyImagesAreDisplayed() {
        IndexPage indexPage = new IndexPage(driver);
        for (WebElement i : indexPage.imagesDisplayed()) {
            softAssert.assertTrue(i.isDisplayed());
        }
    }

    @Test (description = "7. Assert that there are 4 texts on the Index Page under icons", priority = 5)
    public void checkTextUnderImage() {
        IndexPage indexPage = new IndexPage(driver);
        assertThat(indexPage.textUnderImages()).isEqualTo(expectedText);

    }

    @Test (description = "8. Assert that there is the iframe with “Frame Button” exist", priority = 6)
    public void checkIframeIsDisplayed() {
        IndexPage indexPage = new IndexPage(driver);
        softAssert.assertTrue(indexPage.frameElement().isDisplayed());
    }

    @Test (description = "9-10. “Frame Button” exist, Switch to the iframe and check that there is “Frame Button",
            priority = 7)
    public void checkButtonInFrame() {
        IndexPage indexPage = new IndexPage(driver);
        driver.switchTo().frame(iFrameElement);
        softAssert.assertTrue(indexPage.frameButton().isDisplayed());
    }

    @Test (description = "11. 5 items in the left section", priority = 8)
    public void verifyLeftItemsText() {
        LeftSection leftSection = new LeftSection(driver);
        assertThat(leftSection.navigationMenuText()).isEqualTo(names);

    }
}
