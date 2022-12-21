package com.epam.tc.hw2;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExerciseTwo extends CommonAction {
    //for description 5
    private static final String serviceElement = "SERVICE";
    private static final String differentElements = "DIFFERENT ELEMENTS";
    //for description 6
    private static final String checkboxWaterElement = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']";
    private static final String checkboxWindElement = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']";
    //for description 7
    private static final String selenRadioButtonElement = "//label[text()[contains(., ' Selen')]]/*[@type='radio']";
    //for description 8
    private static final String dropdownElement = "colors";
    private static final String yellowElement = "//option[text()='Yellow']";
    //for description 9
    private static final String logPanelElement = "//*[@id=\"mCSB_2_container\"]";


    @Test(description = "1-2. Opening test site and assert browser title", priority = 1)
    public void checkPageTitle() {
        assertThat(driver.getTitle()).isEqualTo(homePageTitle);
    }

    @Test (description = "3-4. Login and assert username is loggined", priority = 2)
    public void verifyUserIsLogged() {
        WebElement login = driver.findElement(By.id(loginElement));
        login.click();
        new WebDriverWait(driver, IMPLICIT_WAIT).until(ExpectedConditions.presenceOfElementLocated(By.id(loginForm)));
        WebElement username = driver.findElement(By.id(usernameId));
        username.sendKeys("Roman", Keys.TAB, "Jdi1234", Keys.ENTER);
        //By name = By.id(userNameElement);
        assertThat(driver.findElement(By.id(userNameElement)).getText()).isEqualTo(userNameLogged);
    }

    @Test (description = "5. Open through the header menu Service -> Different Elements Page", priority = 3)
    //5. Open through the header menu Service -> Different Elements Page
    public void verifyDiffElementsTitle() {
        WebElement service = driver.findElement(By.partialLinkText(serviceElement));
        service.click();
        new WebDriverWait(driver, IMPLICIT_WAIT).until(ExpectedConditions
                .presenceOfElementLocated(By.partialLinkText(differentElements)));
        WebElement diffElements = driver.findElement(By.partialLinkText(differentElements));
        diffElements.click();
        assertThat(driver.getTitle()).isEqualTo("Different Elements");
    }

    @Test (description = "6. Checkboxes", priority = 4)
    public void verifyCheckboxesAreSelected() {
        WebElement checkboxWater = driver.findElement(
                By.xpath(checkboxWaterElement));
        WebElement checkboxWind = driver.findElement(
                By.xpath(checkboxWindElement));
        checkboxWater.click();
        checkboxWind.click();

        assertThat(checkboxWater.isSelected());
        assertThat(checkboxWind.isSelected());

    }

    @Test (description = "7. radiobutton selen", priority = 5)
    public void checkSelenRadioButtonIsSelected() {
        WebElement selenRadioButton = driver.findElement(
                By.xpath(selenRadioButtonElement));
        selenRadioButton.click();
        assertThat(selenRadioButton.isSelected());

    }

    @Test (description = "8. select yellow in dropdown", priority = 6)
    public void checkYellowDropdownIsSelected() {
        WebElement dropdown = driver.findElement(By.className(dropdownElement));
        dropdown.click();
        WebElement yellow = driver.findElement(By.xpath(yellowElement));
        yellow.click();
        assertThat(yellow.isSelected());
    }

    @Test (description = "9. assert logs", priority = 7)
    public void checkLogsContainProperText() {
        WebElement logPanel = driver.findElement((By.xpath(logPanelElement)));
        assertThat(logPanel.getText().contains("Wind: condition changed to true"));
        assertThat(logPanel.getText().contains("Water: condition changed to true"));
        assertThat(logPanel.getText().contains("metal: value changed to  Selen"));
        assertThat(logPanel.getText().contains("Colors: value changed to Yellow"));

    }
}
