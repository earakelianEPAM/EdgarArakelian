package com.epam.tc.hw7.tests;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.Header;
import com.epam.tc.hw7.pages.JdiMainPage;
import com.epam.tc.hw7.pages.JdiMetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestingSite {
    @Url("index.html")
    public static JdiMainPage mainPage;

    @Url("/metals-colors.html")
    public static JdiMetalsAndColorsPage metalsAndColorsPage;

    public static Header header;

    @Css(".profile-photo [ui=label]")
    public static UIElement userName;

    @Css(".logout button")
    public static Button logout;

    public static void open() {
        mainPage.open();
    }

    public static void login(User user) {
        mainPage.login(user);
    }

    public static void openMetalsAndColorsPage() {
        header.menu.select("Metals & Colors");
    }

    public static void logout() {
        if (!logout.isDisplayed()) {
            userName.click();
        }
        logout.click();
    }
}
