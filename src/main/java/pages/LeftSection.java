package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LeftSection {
    //for test 11
    @FindBy(xpath = "//div[@name=\"navigation-sidebar\"]/div/div/div/div/ul/li/a")
    public List<WebElement> itemsElement;
    public static List<String> names = List.of("Home", "Contact form", "Service", "Metals & Colors",
            "Elements packs");

    public LeftSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> navigationMenuText() {
        List<String> actualMenu = new ArrayList<>();
        for (WebElement i : itemsElement) {
            actualMenu.add(i.getText());
        }
        return actualMenu;
    }

}

