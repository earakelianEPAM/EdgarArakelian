package com.epam.tc.hw6.utilsHw6;

import org.openqa.selenium.WebDriver;
import pages.DiffElementsPage;
import pages.Header;
import pages.IndexPage;
import pages.LeftSection;

public class PageObject {
    protected DiffElementsPage diffElementsPage;
    protected Header header;
    protected IndexPage indexPage;
    protected LeftSection leftSection;

    protected PageObject(WebDriver driver) {
        diffElementsPage = new DiffElementsPage(driver);
        header = new Header(driver);
        indexPage = new IndexPage(driver);
        leftSection = new LeftSection(driver);
    }
}
