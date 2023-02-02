package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.data.MetalsAndColorsData;
import java.util.Arrays;

public class MetalAndColorsForm extends Form<MetalsAndColorsData> {
    @UI(".radio")
    public static JList<Label> summary;

    @UI("p.checkbox")
    public static JList<Label> elements;

    @JDropdown(
            root = "#colors",
            value = "filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;

    @JDropdown(
            root = "#metals",
            value = "filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @JDropdown(
            root = "#vegetables",
            value = "#salad-dropdown",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetables;

    @UI("#submit-button")
    public static Button submit;

    @Override
    public void fill(MetalsAndColorsData entity) {

        summary.stream().filter(radio -> radio.getText().equals(String.valueOf(entity.getSummary()[0]))
                || radio.getText().equals(String.valueOf(entity.getSummary()[1]))).forEach(HasClick::click);

        elements.stream().filter(element -> Arrays.asList(entity.getElements()).contains(element.getText()))
                .forEach(HasClick::click);

        colors.select(entity.getColor());
        metals.select(entity.getMetals());
        vegetables.select(vegetables.selected());
        Arrays.stream(entity.getVegetables()).forEach(vegetable -> vegetables.select(vegetable));
    }

    public void submit() {
        submit.click();
    }
}
