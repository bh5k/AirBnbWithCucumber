package com.airbnb.model;

public class Rental {

    private Room room;
    private SeasonType seasonType;
    private int days;

    private User user;

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public SeasonType getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(SeasonType seasonType) {
        this.seasonType = seasonType;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
