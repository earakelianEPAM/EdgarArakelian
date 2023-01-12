package com.epam.tc.hw4.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.utils.ActionStep;
import com.epam.tc.hw4.utils.AssertStep;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;


@Feature("Check Main Page for failed tests")
@Story("Title, login name of the user should be failed")

public class FailedTest extends BaseTest {
    ActionStep actionStep;
    AssertStep assertStep;
    public static final String HOME_PAGE_TITLE_WRONG = "Home Pagee";

    @Test
    @Description("Check title of the home page")
    public void verifyTitle() {
        assertThat(driver.getTitle()).as("Wrong Page title").isEqualTo(HOME_PAGE_TITLE_WRONG);
    }

    @Test
    @Description("Login and assert username is loggined")
    public void verifyUserIsLogged() {
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        actionStep.loginToIndexPage();
        assertStep.assertLoginFailed();
    }
}

