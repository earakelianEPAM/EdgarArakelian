package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiffElementsPage {
    //for ex.2 test 6
    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    public static WebElement checkboxWaterElement;
    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    public static WebElement checkboxWindElement;
    //for ex.2 test 7
    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]/*[@type='radio']")
    public static WebElement selenRadioButtonElement;
    //for ex.2 test 8
    @FindBy(className = "colors")
    public static WebElement dropdownElement;
    @FindBy(xpath = "//option[text()='Yellow']")
    public static WebElement yellowElement;
    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]/section/div/div/ul")
    public WebElement logPanelElement;
    //public List<WebElement> logPanelElement;
    public static List<String> expectedTextInLogPanel = List.of(
            //1
            "Wind: condition changed to true",
            //2
            "Water: condition changed to true",
            //3
            "metal: value changed to Selen",
            //4
            "Colors: value changed to Yellow"
    );

    public DiffElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement selectWaterCheckbox() {
        checkboxWaterElement.click();
        return checkboxWaterElement;
    }

    public WebElement selectWindCheckbox() {
        checkboxWindElement.click();
        return checkboxWindElement;
    }

    public WebElement selectSelenRadioButton() {
        selenRadioButtonElement.click();
        return selenRadioButtonElement;
    }

    public WebElement selectYellowDropdown() {
        dropdownElement.click();
        yellowElement.click();
        return yellowElement;
    }

    public String logPanelText() {
        return logPanelElement.getText();
    }
}
