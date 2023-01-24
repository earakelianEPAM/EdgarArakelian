package com.epam.tc.hw7.entities;

import java.util.LinkedList;
import java.util.List;

public class MetalsAndColorsDataItem {
    private Integer[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public Integer[] getSummary() {
        return summary;
    }

    public String[] getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public String[] getSummaryOdd() {
        List<String> result = new LinkedList<>();
        for (Integer x : summary) {
            if (x % 2 != 0) {
                result.add(x.toString());
            }
        }
        return result.toArray(new String[0]);
    }

    public String[] getSummaryEven() {
        List<String> result = new LinkedList<>();
        for (Integer x : summary) {
            if (x % 2 == 0) {
                result.add(x.toString());
            }
        }
        return result.toArray(new String[0]);
    }

    private Integer calcSummarySum() {
        Integer result = 0;
        for (Integer x : summary) {
            result += x;
        }
        return result;
    }

    public List<String> getExpectedResultLines() {
        List<String> lines = new LinkedList<>();
        lines.add(String.format("Summary: %d", calcSummarySum()));
        lines.add(String.format("Elements: %s", String.join(", ", elements)));
        lines.add(String.format("Color: %s", color));
        lines.add(String.format("Metal: %s", metals));
        lines.add(String.format("Vegetables:  %s", String.join(", ", elements)));
        return lines;
    }

    public void setSummary(Integer[] summary) {
        this.summary = summary;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public String[] getVegetables() {
        return vegetables;
    }
}
