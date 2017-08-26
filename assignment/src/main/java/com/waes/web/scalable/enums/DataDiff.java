package com.waes.web.scalable.enums;

public enum DataDiff {

    NOT_FOUND("id not found"),
    EQUAL("left and right are equal"),
    SIZE_DIFF("left and right have different sizes"),
    OFFSET("left and right have same size, but are different at position:");

    private final String text;

    DataDiff(String option) {
        text = option;
    }

    public String getText() {
        return text;
    }

}
