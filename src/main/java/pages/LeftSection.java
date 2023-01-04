package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSection {
    //for test 11
    @FindBy(xpath = "//div[@id=\"mCSB_1_container\"]/ul/li/a")
    private List<WebElement> itemsElement;
    public static List<String> names = List.of("Home", "Contact form", "Service", "Metals & Colors",
            "Elements packs");

    public LeftSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<String> getNavigationMenuText() {
        List<String> actualMenu = new ArrayList<>();
        for (WebElement i : itemsElement) {
            actualMenu.add(i.getText());
        }
        return actualMenu;
    }

}

