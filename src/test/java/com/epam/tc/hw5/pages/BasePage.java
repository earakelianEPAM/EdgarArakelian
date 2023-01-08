package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.pages.sections.Header;
import com.epam.tc.hw5.pages.sections.SideBar;
import com.epam.tc.hw5.pages.sections.UserAccountMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public Header header;
    public UserAccountMenu userAccountMenu;
    public SideBar sideBar;
    protected WebDriver webDriver;
    public String url;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.header = new Header(webDriver);
        this.sideBar = new SideBar(webDriver);
        this.userAccountMenu = new UserAccountMenu(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public abstract void openPage();

    public void openPageUrl() {
        webDriver.get(url);
    }

    public String getTabTitle() {
        return webDriver.getTitle();
    }

    public String getOpenedUrl() {
        return webDriver.getCurrentUrl();
    }

}
