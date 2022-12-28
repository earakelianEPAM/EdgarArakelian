package com.epam.tc.hw2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ExerciseOne extends CommonAction {
    //for description 5
    private static final String headerLocator = "//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]/li/a";
    private static final List<String> headerNamesExpected = List.of("HOME", "CONTACT FORM", "SERVICE",
            "METALS & COLORS");
    //for description 6
    private static final String iconPractise = ".icon-practise";
    private static final String iconCustom = ".icon-custom";
    private static final String iconBenefit = ".icon-multi";
    private static final String iconBase = ".icon-base";
    //for description 7
    private static final String textElement = "benefit-txt";
    //for description 8-10
    private static final String iFrameElement = "frame";
    private static final String frameButton = "frame-button";
    //for description 11
    private static final List<String> names = List.of("Home", "Contact form", "Service", "Metals & Colors",
            "Elements packs");
    private static final String itemsElement = "//div[@name=\"navigation-sidebar\"]/div/div/div/div/ul/li/a";


    @Test (description = "1-2. Opening test site and assert browser title")
    public void checkPageTitle() {
        assertThat(driver.getTitle()).isEqualTo(homePageTitle);
    }

    @Test (description = "3-4. Login and assert username is loggined")
    public void verifyUserIsLogged() {
        WebElement login = driver.findElement(By.id(loginElement));
        login.click();
        new WebDriverWait(driver, IMPLICIT_WAIT).until(ExpectedConditions.presenceOfElementLocated(By.id(loginForm)));
        WebElement username = driver.findElement(By.id(usernameId));
        username.sendKeys("Roman", Keys.TAB, "Jdi1234", Keys.ENTER);
        By name = By.id(userNameElement);
        assertThat(driver.findElement(name).getText()).isEqualTo(userNameLogged);
    }

    @Test (description = "5. Assert 4 items in the header section with proper text")
    public void verifyIndexPageItemsText() {
        List<WebElement> header = driver.findElements(By.xpath(headerLocator));
        List<String> itemsHeaderNames = new ArrayList<>();
        for (WebElement i : header) {
            itemsHeaderNames.add(i.getText());
        }
        assertThat(itemsHeaderNames).isEqualTo(headerNamesExpected);
    }

    @Test (description = "6. Assert 4 images on the index page")
    public void verifyImagesAreDisplayed() {
        By imageIconPractise = By.cssSelector(iconPractise);
        By imageIconCustom = By.cssSelector(iconCustom);
        By imageIconBenefit = By.cssSelector(iconBenefit);
        By imageIconBase = By.cssSelector(iconBase);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(imageIconPractise).isDisplayed());
        softAssert.assertTrue(driver.findElement(imageIconCustom).isDisplayed());
        softAssert.assertTrue(driver.findElement(imageIconBenefit).isDisplayed());
        softAssert.assertTrue(driver.findElement(imageIconBase).isDisplayed());
    }

    @Test (description = "7. Assert that there are 4 texts on the Index Page under icons")
    public void checkTextUnderImage() {
        List<WebElement> text = driver.findElements(By.className(textElement));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text.get(0).getText(), "\"To include good practices\\n\"\n"
                +                "\"and ideas from successful\\n\"\n"
                +                "EPAM project\");");
        softAssert.assertEquals(text.get(1).getText(), "To be flexible and\n"
                + "customizable");
        softAssert.assertEquals(text.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(text.get(3).getText(), "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");
    }

    @Test (description = "8. Assert that there is the iframe with “Frame Button” exist")
    //8. Assert that there is the iframe with “Frame Button” exist
    public void checkIframeIsDisplayed() {
        WebElement iframe = driver.findElement(By.id(iFrameElement));
        assertThat(iframe.isDisplayed());
    }

    @Test (description = "9-10. “Frame Button” exist, Switch to the iframe and check that there is “Frame Button")
    public void checkButtonInFrame() {
        driver.switchTo().frame(iFrameElement);
        assertThat(driver.findElement(By.id(frameButton)).isDisplayed());
    }

    @Test (description = "11. 5 items in the left section")
    public void verifyLeftItemsText() {
        List<WebElement> items = driver.findElements(
                By.xpath(itemsElement));
        List<String> itemsNames = new ArrayList<>();
        for (WebElement i : items) {
            itemsNames.add(i.getText());
        }
        assertThat(itemsNames).isEqualTo(names);
    }
}
