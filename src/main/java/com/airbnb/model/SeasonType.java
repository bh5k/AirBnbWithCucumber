package com.airbnb.model;

public enum SeasonType {

    WINTER(.75), SPRING(2.0), SUMMER(1.0), FALL(1.25);

    private final double rate;

    SeasonType(double rate) {
        this.rate = rate;
    }

    public double getValue() {
        return rate;
    }

    public static SeasonType getByValue(double value) {
        for(SeasonType season: values()) {
            if(season.getValue() == value) {
                return season;
            }
        }
        throw new IllegalArgumentException("No season found.");
    }
}
