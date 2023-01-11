package com.epam.tc.hw4.utils;

import com.epam.tc.hw4.utils.AttachImage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object webDriver = result.getTestContext().getAttribute("driver");
        if (webDriver != null) {
            byte [] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            AttachImage.makeImageAttachment("screenshot on failure", screenshot);
        }
    }
}
