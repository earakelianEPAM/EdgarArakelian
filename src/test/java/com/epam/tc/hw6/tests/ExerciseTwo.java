package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.utilsHw6.ActionStep;
import com.epam.tc.hw6.utilsHw6.AssertStep;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Different elements page")
@Story("Check opening diff elements page, choosing options, logpanel")
public class ExerciseTwo extends BaseTest{
    ActionStep actionStep;
    AssertStep assertStep;

    @Test(priority = 1)
    @Description("Test Home Page")
    public void verifyMainPage() {
        assertStep = new AssertStep(driver);
        assertStep.assertTitle();
    }

    @Test(priority = 2)
    @Description("Test user is logged")
    public void verifyUserIsLogged() {
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        actionStep.loginToIndexPage();
        assertStep.assertLogin();
    }

    @Test(priority = 3)
    @Description("Different elements page is opened with proper title")
    public void verifyDiffElementsTitle() {
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        actionStep.clickToDifferentElements();
        assertStep.assertDiffElementsTitle();
    }

    @Test(priority = 4)
    @Description("Verify checkboxes are selected")
    public void verifyCheckboxes() {
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        actionStep.selectCheckboxes();
        assertStep.assertCheckboxes();
    }

    @Test(priority = 5)
    @Description("Verify selen radiobutton is selected")
    public void verifySelenRadioButton() {
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        actionStep.clickOnRadioButton();
        assertStep.assertRadioButton();
    }

    @Test(priority = 6)
    @Description("Verify yellow dropdown is selected")
    public void verifyYellowDropdown() {
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        actionStep.selectDropdown();
        assertStep.assertDropdown();
    }

    @Test(priority = 7)
    @Description("Verify logpanel")
    public void verifyLogpanel() {
        assertStep = new AssertStep(driver);
        assertStep.assertLogpanel();
    }
}
