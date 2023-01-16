package com.epam.tc.hw7.tests;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.MetalsAndColorsDataItem;
import com.epam.tc.hw7.entities.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.entities.User;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class JdiSiteTest {
    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        WebDriverUtils.killAllSeleniumDrivers();
        PageFactory.initSite(JdiTestingSite.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        softAssert = null;
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(dataProviderClass = MetalsAndColorsDataProvider.class,
            dataProvider = "JDI_ex8_metalsColorsDataSet.json")
    public void test(MetalsAndColorsDataItem metalsAndColors) {
        JdiTestingSite.open();

        JdiTestingSite.login((User.Roman));

        JdiTestingSite.mainPage
                .userNameLabel.is().text(User.Roman.getFullName());

        JdiTestingSite.openMetalsAndColorsPage();

        JdiTestingSite.metalsAndColorsPage
                .fillMetalsAndColorsForm(metalsAndColors);

        JdiTestingSite.metalsAndColorsPage
                .submitMetalAndColorForm();

        assertResults(
                softAssert,
                JdiTestingSite.metalsAndColorsPage.getResultLines(),
                metalsAndColors.getExpectedResultLines()
        );

        JdiTestingSite.logout();
    }

    private void assertResults(Assertion assertion, List<String> actual, List<String> expected) {
        assertion.assertEquals(actual.size(), expected.size(), "Result has wrong lines number");
        for (int i = 0; i < Math.min(actual.size(), expected.size()); i++) {
            assertion.assertEquals(actual.get(i), expected.get(i));
        }
    }
}
