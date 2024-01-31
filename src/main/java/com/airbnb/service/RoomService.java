package com.airbnb.service;

import com.airbnb.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room findByName(String name);
}
