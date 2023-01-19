package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DiffElementsPage {
    //protected WebDriver driver;

    //for ex.2 test 6
    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    public WebElement waterCheckbox;
    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    public WebElement windCheckbox;
    //for ex.2 test 7
    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]/*[@type='radio']")
    private WebElement selenRadioButton;
    //for ex.2 test 8
    @FindBy(className = "colors")
    private WebElement dropdownElement;
    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowDropdownElement;
    //for ex. 2 test 9
    public static List<String> selectedElementsInLogPanel = List.of("Water", "Wind", "Selen", "Yellow");

    @FindBy(xpath = "//*[contains(text(),'Water:')] condition changed to true')]")
    private WebElement waterCheckboxLog;
    @FindBy(xpath = "//*[contains(text(),'Wind: condition changed to true')]")
    private WebElement windCheckboxLog;
    @FindBy(xpath = "//*[contains(text(),'metal: value changed to  Selen')]")
    private WebElement metalRadiobuttonLog;
    @FindBy(xpath = "//*[contains(text(),'Colors: value changed to Yellow')]")
    private WebElement colorsDropdownLog;

    public DiffElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement selectWaterCheckbox() {
        waterCheckbox.click();
        return waterCheckbox;
    }

    public WebElement selectWindCheckbox() {
        windCheckbox.click();
        return windCheckbox;
    }

    public WebElement selectSelenRadioButton() {
        selenRadioButton.click();
        return selenRadioButton;
    }

    public WebElement selectYellowDropdown() {
        dropdownElement.click();
        yellowDropdownElement.click();
        return yellowDropdownElement;
    }

    public WebElement getWaterCheckboxLog() {
        return waterCheckboxLog;
    }

    public WebElement getWindCheckboxLog() {
        return windCheckboxLog;
    }

    public WebElement getMetalRadiobuttonLog() {
        return metalRadiobuttonLog;
    }

    public WebElement getColorsDropdownLog() {
        return colorsDropdownLog;
    }
}
