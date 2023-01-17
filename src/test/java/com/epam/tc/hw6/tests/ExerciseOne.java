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
    ActionStep actionStep = new ActionStep(driver);
    AssertStep assertStep = new AssertStep(driver);

    @Test
    @Description("Test Home Page")
    public void verifyMainPage() {
        assertStep.assertTitle();
    }

    @Test
    @Description("Test user is logged")
    public void verifyUserIsLogged() {
        actionStep.loginToIndexPage();
        assertStep.assertLogin();
    }

    @Test
    @Description("Check headers menu")
    public void checkHeadersMenu() {
        assertStep.assertHeader();
    }

    @Test
    @Description("Check images")
    public void checkImages() {
        assertStep.assertImageIsDisplayed();
    }

    @Test
    @Description("Check text under images")
    public void checkTextUnderImages() {
        assertStep.assertTextUnderImages();
    }

    @Test
    @Description("Check iframe with button")
    public void checkIframe() {
        assertStep.assertIframe();
    }

    @Test
    @Description("Check button in iframe")
    public void checkButtonInFrame() {
        assertStep.assertButtonInFrame();
    }

    @Test
    @Description("Check text in left section")
    public void checkItemsInLeftSection() {
        assertStep.assertLeftItemsText();
    }
}
