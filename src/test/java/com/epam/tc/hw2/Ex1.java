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


public class Ex1 extends Abstract {

    @Test
    //1-2.  Opening test site and assert browser title
    public void homePage() {
        assertThat(driver.getTitle()).isEqualTo("Home Page");
    }

    @Test
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

    @Test
    //5. Assert 4 items in the header section with proper text
    public void indexPageItems() {
        List<String> headerNames = new ArrayList<>();
        headerNames.add("HOME");
        headerNames.add("CONTACT FORM");
        headerNames.add("SERVICE");
        headerNames.add("METALS & COLORS");

        List<WebElement> header = driver.findElements(
                By.xpath("//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]/li/a"));
        List<String> itemsHeaderNames = new ArrayList<>();
        for (WebElement i : header) {
            itemsHeaderNames.add(i.getText());
        }
        assertThat(itemsHeaderNames).isEqualTo(headerNames);
    }

    @Test
    //6. Assert 4 images on the index page
    public void images() {
        By imageIconPractise = By.cssSelector("[class='icons-benefit icon-practise']");
        By imageIconCustom = By.cssSelector("[class='icons-benefit icon-custom']");
        By imageIconBenefit = By.cssSelector("[class='icons-benefit icon-multi']");
        assertThat(driver.findElement(imageIconPractise).isDisplayed());
        assertThat(driver.findElement(imageIconCustom).isDisplayed());
        assertThat(driver.findElement(imageIconBenefit).isDisplayed());
        By imageIconBase = By.cssSelector("[class='icons-benefit icon-base']");
        assertThat(driver.findElement(imageIconBase).isDisplayed());
    }

    @Test
    //7. Assert that there are 4 texts on the Index Page under icons
    public void textUnderImage() {
        By text1 = By.xpath(".//*[@class='icons-benefit icon-practise']/..//../span[@class = 'benefit-txt']");
        assertThat(driver.findElement(text1).getText()).isEqualTo("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        By text2 = By.xpath(".//*[@class='icons-benefit icon-custom']/..//../span[@class = 'benefit-txt']");
        assertThat(driver.findElement(text2).getText()).isEqualTo("To be flexible and\n"
                + "customizable");
        By text3 = By.xpath(".//*[@class='icons-benefit icon-multi']/..//../span[@class = 'benefit-txt']");
        assertThat(driver.findElement(text3).getText()).isEqualTo("To be multiplatform");
        By text4 = By.xpath(".//*[@class='icons-benefit icon-base']/..//../span[@class = 'benefit-txt']");
        assertThat(driver.findElement(text4).getText()).isEqualTo("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");
    }

    @Test
    //8. Assert that there is the iframe with “Frame Button” exist
    public void iframe() {
        WebElement iframe = driver.findElement(By.id("frame"));
        assertThat(iframe.isDisplayed());
    }

    @Test
    //8-10. “Frame Button” exist, Switch to the iframe and check that there is “Frame Button”, Switch to original
    // window back
    public void frame() {
        driver.switchTo().frame("frame");
        assertThat(driver.findElement(By.id("frame-button")).isDisplayed());
        driver.switchTo().parentFrame();
    }

    @Test
    //11. 5 items in the left section
    public void leftItemsText() {
        //exp result
        List<String> names = new ArrayList<>();
        names.add("Home");
        names.add("Contact form");
        names.add("Service");
        names.add("Metals & Colors");
        names.add("Elements packs");
        //act result
        List<WebElement> items = driver.findElements(
                By.xpath("//div[@name=\"navigation-sidebar\"]/div/div/div/div/ul/li/a"));
        List<String> itemsNames = new ArrayList<>();
        for (WebElement i : items) {
            itemsNames.add(i.getText());
        }
        assertThat(itemsNames).isEqualTo(names);
    }
}
