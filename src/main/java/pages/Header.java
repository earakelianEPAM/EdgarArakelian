package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GetCredentials;


public class Header {
    //for tests1-4
    public static String homePageTitle = "Home Page";
    @FindBy(id = "user-icon")
    private WebElement loginElement;
    @FindBy(id = "name")
    private WebElement usernameId;
    public static String userNameLogged = "ROMAN IOVLEV";
    @FindBy(id = "user-name")
    private WebElement userNameElement;
    //for test5
    @FindBy(xpath = "//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]/li/a")
    public List<WebElement> headerLocators;
    public static List<String> headerNamesExpected = List.of("HOME", "CONTACT FORM", "SERVICE",
            "METALS & COLORS");
    //for ex.2 test5
    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceElement;
    public static String diffElementsMenuItem = "DIFFERENT ELEMENTS";
    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    public static WebElement differentElements;

    public static String diffElementsTitle = "Different Elements";


    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToPage() {
        GetCredentials getCredentials = new GetCredentials();
        loginElement.click();
        usernameId.click();
        usernameId.sendKeys(getCredentials.getLogin(), Keys.TAB, getCredentials.getPassword(), Keys.ENTER);
    }

    public String romanLogged() {
        return userNameElement.getText();
    }

    public List<String> itemsInHeader() {
        List<String> itemsHeaderNames = new ArrayList<>();
        for (WebElement i : headerLocators) {
            itemsHeaderNames.add(i.getText());
        }
        return itemsHeaderNames;
    }

    public void clickServiceMenu() {
        serviceElement.click();
    }

    public void clickDiffElements() {
        differentElements.click();
    }

}
