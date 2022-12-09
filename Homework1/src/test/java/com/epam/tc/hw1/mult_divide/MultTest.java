package com.epam.tc.hw1.mult_divide;

import com.epam.tc.hw1.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultTest extends AbstractTest {

    @DataProvider
    public static Object[][] multCorrectData() {
        return new Object[][]{
                {10.0, 2.0, 20.0},
                {0.0, 3.3, 0.0},
                {-5.0, -1.0, 5.0},
                {5.0, -1.0, -5.0},
                {10.0, 10.0, 100.0},
                {4.0, 0.0, 0.0}
        };
    }

    @Test(dataProvider = "multCorrectData")
    public void multDDtTest(double a, double b, double res) {
        var act = calculator.mult(a, b);
        assertThat(res).as("Wrong calculation").isEqualTo(act);
    }
}
