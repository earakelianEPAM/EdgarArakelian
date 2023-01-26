package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.LoginForm;

@Url("index.html")
@Title("Home page")
public class HomePage extends WebPage {

    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(id = "user-name")
    public Label userName;

    @XPath("//a[text()='Metals & Colors']")
    public static Link metalsAndColorsHeader;

    @UI("div.logout")
    public static Button logOutButton;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void logout() {
        userIcon.click();
        logOutButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }
}
