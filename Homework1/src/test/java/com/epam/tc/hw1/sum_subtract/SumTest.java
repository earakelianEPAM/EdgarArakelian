package com.epam.tc.hw1.sum_subtract;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumTest extends AbstractTest {

    @DataProvider
    public static Object[][] sumCorrectData() {
        return new Object[][]{
                {100.0, 100.0, 200.0},
                {7.3, 3.3, 10.6},
                {0.0, 2.5, 2.5},
                {5.0, 5.0, 10.0},
                {-100.0, -50.0, -150.0},
                {-100.0, 50.0, -50.0},
                {0.0, 0.0, 0.0}
        };
    }

    @Test(dataProvider = "sumCorrectData")
    public void subDDtTest(double a, double b, double res) {
        var act = calculator.sum(a, b);
        assertThat(res).as("Wrong calculation").isEqualTo(act);

    }
}
