package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    //for test 6
    @FindBys({
        @FindBy(css = ".icon-practise"),
        @FindBy(css = ".icon-custom"),
        @FindBy(css = ".icon-multi"),
        @FindBy(css = ".icon-base")
    })
    public static List<WebElement> indexPageImages;
    // for test 7
    @FindBy(className = "benefit-txt")
    public List<WebElement> textElement;
    public static List<String> expectedText = List.of(
            //1
            "To include good practices\n"
                    + "and ideas from successful\n"
                    + "EPAM project",
            //2
            "To be flexible and\n"
                    + "customizable",
            //3
            "To be multiplatform",
            //4
            "Already have good base\n"
                    + "(about 20 internal and\n"
                    + "some external projects),\n"
                    + "wish to get more…");

    // for test 8-9
    @FindBy(id = "frame")
    private WebElement frameElement;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> imagesDisplayed() {
        return indexPageImages;
    }

    public List<String> textUnderImages() {
        List<String> actualText = new ArrayList<>();
        for (WebElement i : textElement) {
            actualText.add(i.getText());
        }
        return actualText;
    }

    public WebElement frameElement() {
        return frameElement;
    }

    public WebElement frameButton() {
        return frameButton;
    }
}

