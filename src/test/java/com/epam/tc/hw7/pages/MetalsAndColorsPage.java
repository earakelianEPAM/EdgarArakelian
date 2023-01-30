package com.epam.tc.hw7.pages;

import static com.epam.tc.hw7.JdiSite.metalsAndColorsPage;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.data.MetalsAndColorsData;
import com.epam.tc.hw7.forms.MetalAndColorsForm;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI(".logs li")
    public JList<Label> logsList;

    @UI(".results li")
    public JList<Label> resultsList;

    @UI(".form")
    public MetalAndColorsForm form;

    public void checkResults(MetalsAndColorsData metalsAndColorsData) {
        List<String> results =
                metalsAndColorsPage.resultsList.stream().map(Label::getText).collect(Collectors.toList());
        Assert.assertEquals(results, metalsAndColorsData.expectedResultList());
    }
}
