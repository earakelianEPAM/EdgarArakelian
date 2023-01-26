package com.epam.tc.hw5.pages;


import com.epam.tc.hw5.pages.sections.LogArea;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.DiffElementsPage;

public class DifferentElementsPage extends BasePage {

    public LogArea logArea;

    public String url = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    public WebElement waterCheckbox;
    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    public WebElement windCheckbox;
    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]/*[@type='radio']")
    public WebElement selenRadioButton;
    @FindBy(xpath = "//option[text()='Yellow']")
    public WebElement yellowSelectorOption;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        this.logArea = new LogArea(webDriver);
    }

    public void selectCheckBox(String checkBoxName) {
        if (checkBoxName.equalsIgnoreCase("WIND")) {
            windCheckbox.click();
        } else if (checkBoxName.equalsIgnoreCase("WATER")) {
            waterCheckbox.click();
        } else {
            System.out.println("Failed to find checkbox " + checkBoxName);
        }

    }

    public void selectRadioButton(String radioButtonName) {
        if (radioButtonName.equalsIgnoreCase("SELEN")) {
            selenRadioButton.click();
        } else {
            System.out.println("Failed to find radio button " + radioButtonName);
        }
    }

    public void setSelectorOption(String optionName) {
        if (optionName.equalsIgnoreCase("YELLOW")) {
            yellowSelectorOption.click();
        } else {
            System.out.println("Failed to find selector option " + yellowSelectorOption);
        }
    }

    @Override
    public void openPage() {
        header.service.click();
        header.differentElements.click();
    }
}
