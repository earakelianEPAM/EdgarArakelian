package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.entities.MetalsAndColorsDataItem;
import com.epam.tc.hw7.forms.MetalsAndColorsForm;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebElement;

@Url("/metals-colors.html")
public class JdiMetalsAndColorsPage extends WebPage {
    @UI(".main-content form")
    public MetalsAndColorsForm metalsAndColorsForm;

    @UI(".info-panel-body-result .results li")
    public static List<WebElement> results;

    public void fillMetalsAndColorsForm(MetalsAndColorsDataItem data) {
        metalsAndColorsForm.summaryOdd.select(data.getSummaryOdd());
        metalsAndColorsForm.summaryEven.select(data.getSummaryEven());
        metalsAndColorsForm.elements.select(data.getElements());
        metalsAndColorsForm.colors.select(data.getColor());
        metalsAndColorsForm.metals.select(data.getMetals());

        metalsAndColorsForm.vegetables.expand();
        metalsAndColorsForm.vegetables.select(data.getVegetables());
    }

    public void submitMetalAndColorForm() {
        metalsAndColorsForm.submit();
    }

    public List<String> getResultLines() {
        List<String> lines = new LinkedList<>();
        for (WebElement element : results) {
            lines.add(element.getText());
        }
        return lines;
    }
}
