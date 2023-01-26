package com.epam.tc.hw7.data;

import java.util.Arrays;
import java.util.List;

public class MetalsAndColorsData {
    int[] summary;
    String[] elements;
    String color;
    String metals;
    String[] vegetables;

    public List<String> expectedResultList() {
        return Arrays.asList(
                "Summary: " + Arrays.stream(summary).sum(),
                "Elements: " + getElementsToString(),
                "Color: " + getColor(),
                "Metal: " + getMetals(),
                "Vegetables: " + getVegetablesToString());
    }

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public String[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public String getElementsToString() {
        return String.join(", ", elements);
    }

    public String getVegetablesToString() {
        return String.join(", ", vegetables);
    }
}

