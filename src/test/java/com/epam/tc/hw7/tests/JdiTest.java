package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.JdiSite.homePage;
import static com.epam.tc.hw7.JdiSite.metalsAndColorsPage;
import static com.epam.tc.hw7.pages.HomePage.metalsAndColorsHeader;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.JdiSite;
import com.epam.tc.hw7.data.DataProviderForTest;
import com.epam.tc.hw7.data.MetalsAndColorsData;
import com.epam.tc.hw7.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JdiTest {

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProvider = "MetalsAndColors", dataProviderClass = DataProviderForTest.class)
    public void loginTest(MetalsAndColorsData metalsAndColorsData) {
        JdiSite.open();
        homePage.login(User.ROMAN);
        String actualFullName = homePage.getUserName();
        Assert.assertEquals(actualFullName, User.ROMAN.getFullName());
        metalsAndColorsHeader.click();
        metalsAndColorsPage.checkOpened();

        metalsAndColorsPage.form.fill(metalsAndColorsData);
        metalsAndColorsPage.form.check(metalsAndColorsData);
        metalsAndColorsPage.form.submit();

        metalsAndColorsPage.checkResults(metalsAndColorsData);

        homePage.logout();
    }
}
