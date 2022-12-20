package com.epam.tc.hw2;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ex2 extends Abstract {

    @Test(priority = 1)
    //1-2.  Opening test site and assert browser title
    public void homePage() {
        assertThat(driver.getTitle()).isEqualTo("Home Page");
    }

    @Test (priority = 2)
    //3-4. Login and assert username is loggined
    public void userLogged() {
        WebElement login = driver.findElement(By.id("user-icon"));
        login.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("user-icon")));
        WebElement username = driver.findElement(By.id("name"));
        username.sendKeys("Roman", Keys.TAB, "Jdi1234", Keys.ENTER);
        By name = By.id("user-name");
        assertThat(driver.findElement(name).getText()).isEqualTo("ROMAN IOVLEV");
    }

    @Test (priority = 3)
    //5. Open through the header menu Service -> Different Elements Page
    public void diffElementsPage() {
        WebElement service = driver.findElement(By.partialLinkText("SERVICE"));
        service.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.partialLinkText("DIFFERENT ELEMENTS")));
        WebElement diffElements = driver.findElement(By.partialLinkText("DIFFERENT ELEMENTS"));
        diffElements.click();
        assertThat(driver.getTitle()).isEqualTo("Different Elements");
    }

    @Test (priority = 4)
    //6. Checkboxes
    public void selectCheckboxes() {
        WebElement checkboxWater = driver.findElement(
                By.xpath("//label[text()[contains(., ' Water')]]/*[@type='checkbox']"));
        WebElement checkboxWind = driver.findElement(
                By.xpath("//label[text()[contains(., ' Wind')]]/*[@type='checkbox']"));
        checkboxWater.click();
        checkboxWind.click();

        assertThat(checkboxWater.isSelected());
        assertThat(checkboxWind.isSelected());

    }

    @Test (priority = 5)
    //7. radiobutton selen
    public void selectRadioButton() {
        WebElement selenRadioButton = driver.findElement(
                By.xpath("//label[text()[contains(., ' Selen')]]/*[@type='radio']"));
        selenRadioButton.click();
        assertThat(selenRadioButton.isSelected());

    }

    @Test (priority = 6)
    //8. select yellow in dropdown
    public void yellowDropDown() {
        WebElement dropdown = driver.findElement(By.className("colors"));
        dropdown.click();
        WebElement yellow = driver.findElement(By.xpath("//option[text()='Yellow']"));
        yellow.click();
        assertThat(yellow.isSelected());
    }

    @Test (priority = 7)
    //9. assert logs
    public void logs() {
        WebElement logPanel = driver.findElement((By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]/div[2]/div/ul")));
        assertThat(logPanel.getText().contains("Wind: condition changed to true"));
        assertThat(logPanel.getText().contains("Water: condition changed to true"));
        assertThat(logPanel.getText().contains("metal: value changed to  Selen"));
        assertThat(logPanel.getText().contains("Colors: value changed to Yellow"));

    }
}
