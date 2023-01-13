package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.utilsHw6.ActionStep;
import com.epam.tc.hw6.utilsHw6.AssertStep;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Check Main Page")
@Story("Check Title, login feature, header menu, iframe and left section")
public class ExerciseOne extends BaseTest {
    ActionStep actionStep;
    AssertStep assertStep;

    @Test
    @Description("Test Home Page")
    public void verifyMainPage() {
        assertStep = new AssertStep(driver);
        assertStep.assertTitle();
    }

    @Test
    @Description("Test user is logged")
    public void verifyUserIsLogged() {
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        actionStep.loginToIndexPage();
        assertStep.assertLogin();
    }

    @Test
    @Description("Check headers menu")
    public void checkHeadersMenu() {
        assertStep = new AssertStep(driver);
        assertStep.assertHeader();
    }

    @Test
    @Description("Check images")
    public void checkImages() {
        assertStep = new AssertStep(driver);
        assertStep.assertImages();
    }

    @Test
    @Description("Check text under images")
    public void checkTextUnderImages() {
        assertStep = new AssertStep(driver);
        assertStep.assertTextUnderImages();
    }

    @Test
    @Description("Check iframe with button")
    public void checkIframe() {
        assertStep = new AssertStep(driver);
        assertStep.assertIframe();
    }

    @Test
    @Description("Check button in iframe")
    public void checkButtonInFrame() {
        assertStep = new AssertStep(driver);
        assertStep.assertButtonInFrame();
    }

    @Test
    @Description("Check text in left section")
    public void checkItemsInLeftSection() {
        assertStep = new AssertStep(driver);
        assertStep.assertLeftItemsText();
    }
}
