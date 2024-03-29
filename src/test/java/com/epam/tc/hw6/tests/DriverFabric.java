package com.epam.tc.hw6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.URL;
import java.util.Locale;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@UtilityClass
public class DriverFabric {

    @SneakyThrows
    public WebDriver getWebDriver(final boolean isLocal, final String hub, @NonNull final String browser) {
        if (isLocal) {
            return WebDriverManager.getInstance(browser).create();
        } else {
            System.out.println("Creating remote driver");
            Capabilities caps;
            switch (browser.toUpperCase(Locale.ROOT)) {
                case "FIREFOX":
                    caps = new FirefoxOptions();
                    break;
                case "CHROME":
                default:
                    caps = new ChromeOptions();
                    break;
            }
            return new RemoteWebDriver(new URL(hub), caps);
        }
    }
}
