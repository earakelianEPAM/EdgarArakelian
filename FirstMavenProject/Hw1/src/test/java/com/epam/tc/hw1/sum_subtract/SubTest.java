package com.epam.tc.hw1.sum_subtract;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.Abstract;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class SubTest extends Abstract {

    @DataProvider
    public static Object[][] subCorrectData() {
        return new Object[][]{
                {10.0, 2.0, 8.0},
                {7.3, 3.3, 4.0},
                {0.0, 2.5, -2.5},
                {5.0, 5.0, 0.0},
                {1000.0, 1000.0, 0.0}
        };
    }

    @Test(dataProvider = "subCorrectData")
    public void subDDtTest(double a, double b, double res) {
        var act = calculator.sub(a, b);
        assertThat(res).as("Wrong calculation").isEqualTo(act);

    }
}



