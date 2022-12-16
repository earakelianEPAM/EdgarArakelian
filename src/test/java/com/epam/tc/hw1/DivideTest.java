package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivideTest extends Abstract {

    @DataProvider
    public static Object[][] divCorrectData() {
        return new Object[][]{
                {10.0, 2.0, 5.0},
                {0.0, 3.3, 0.0},
                {-5.0, -1.0, 5.0},
                {5.0, -1.0, -5.0}
        };
    }

    @Test(dataProvider = "divCorrectData")
    public void divDDtTest(double a, double b, double res) {
        var act = calculator.div(a, b);
        assertThat(res).as("Wrong calculation").isEqualTo(act);

    }
}