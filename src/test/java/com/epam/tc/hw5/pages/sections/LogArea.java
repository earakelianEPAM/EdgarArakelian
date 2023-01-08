package com.epam.tc.hw5.pages.sections;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogArea {

    private WebDriver webDriver;

    public LogArea(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "div.info-panel-section>ul.panel-body-list.logs>li")
    public List<WebElement> logEntries;

    @FindBy(css = "div.info-panel-section>ul.panel-body-list.logs>li:nth-child(1)")
    public WebElement topEntry;

    public WebElement getTopEntry() {
        return topEntry;
    }
}
