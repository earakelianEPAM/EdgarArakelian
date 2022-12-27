package com.epam.tc.hw3;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.DiffElementsPage.expectedTextInLogPanel;
import static pages.Header.diffElementsMenuItem;
import static pages.Header.diffElementsTitle;
import static pages.Header.homePageTitle;
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

    @Test (description = "5. Open through the header menu Service -> Different Elements Page", priority = 3)
    public void verifyDiffElementsTitle() {
        Header header = new Header(driver);
        header.clickServiceMenu();
        new WebDriverWait(driver, IMPLICIT_WAIT).until(ExpectedConditions
                .presenceOfElementLocated(By.partialLinkText(diffElementsMenuItem)));
        header.clickDiffElements();
        assertThat(driver.getTitle()).isEqualTo(diffElementsTitle);
    }

    @Test (description = "6. Checkboxes", priority = 4)
    public void verifyCheckboxesAreSelected() {
        DiffElementsPage diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectWaterCheckbox().isSelected());
        softAssert.assertTrue(diffElementsPage.selectWindCheckbox().isSelected());
    }

    @Test (description = "7. radiobutton selen", priority = 5)
    public void checkSelenRadioButtonIsSelected() {
        DiffElementsPage diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectSelenRadioButton().isSelected());
    }

    @Test (description = "8. select yellow in dropdown", priority = 6)
    public void checkYellowDropdownIsSelected() {
        DiffElementsPage diffElementsPage = new DiffElementsPage(driver);
        softAssert.assertTrue(diffElementsPage.selectYellowDropdown().isSelected());
    }

    @Test (description = "9. assert logs", priority = 7)
    public void checkLogsContainProperText() {
        DiffElementsPage diffElementsPage = new DiffElementsPage(driver);
        String logString = diffElementsPage.logPanelText();
        for (String i : expectedTextInLogPanel) {
            assertThat(logString.contains(i)).isTrue();
        }
    }
}
