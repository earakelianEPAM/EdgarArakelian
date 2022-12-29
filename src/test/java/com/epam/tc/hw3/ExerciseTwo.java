package com.epam.tc.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.Header.DIFF_ELEMENTS_TITLE;
import static pages.Header.HOME_PAGE_TITLE;
import static pages.Header.diffElementsMenuItem;
import static pages.Header.userNameLogged;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DiffElementsPage;
import pages.Header;


public class ExerciseTwo extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    Header header;
    DiffElementsPage diffElementsPage;

    @Test(description = "1-2. Opening test site and assert browser title", priority = 1)
    public void checkPageTitle() {
        assertThat(driver.getTitle()).as("Incorrect page title").isEqualTo(HOME_PAGE_TITLE);
    }

    @Test(description = "3-4. Login and assert username is loggined", priority = 2)
    public void verifyUserIsLogged() {
        header = new Header(driver);
        header.loginToPage();
        assertThat(header.getUsernameIsLogged()).as("Wrong username is logged").isEqualTo(userNameLogged);
    }

    @Test (description = "5. Open through the header menu Service -> Different Elements Page", priority = 3)
    public void verifyDiffElementsTitle() {
        header = new Header(driver);
        header.clickServiceMenu();
        new WebDriverWait(driver, IMPLICIT_WAIT).until(ExpectedConditions
                .presenceOfElementLocated(By.partialLinkText(diffElementsMenuItem)));
        header.clickDiffElements();
        assertThat(driver.getTitle()).as("Incorrect diff elements title is displayed").isEqualTo(DIFF_ELEMENTS_TITLE);
    }

    @Test (description = "6. Checkboxes", priority = 4)
    public void verifyCheckboxesAreSelected() {
        diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectWaterCheckbox().isSelected());
        softAssert.assertTrue(diffElementsPage.selectWindCheckbox().isSelected());
        softAssert.assertAll();
    }

    @Test (description = "7. radiobutton selen", priority = 5)
    public void checkSelenRadioButtonIsSelected() {
        diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectSelenRadioButton().isSelected());
        softAssert.assertAll();
    }

    @Test (description = "8. select yellow in dropdown", priority = 6)
    public void checkYellowDropdownIsSelected() {
        diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectYellowDropdown().isSelected());
        softAssert.assertAll();
    }

    @Test (description = "9. assert logs", priority = 7)
    public void testLogger() {
        diffElementsPage = new DiffElementsPage(driver);
        assertThat(diffElementsPage.getWaterCheckboxLog().isDisplayed());
        assertThat(diffElementsPage.getWindCheckboxLog().isDisplayed());
        assertThat(diffElementsPage.getMetalRadiobuttonLog().isDisplayed());
        assertThat(diffElementsPage.getColorsDropdownLog().isDisplayed());
        softAssert.assertAll();
    }
}
