package com.airbnb.controller;

import com.airbnb.model.Room;
import com.airbnb.service.RoomService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        System.out.println("In Get All Rooms");
        return roomService.findAll();
    }

    @GetMapping("/room")
    public Room findByName(@RequestParam String name) {
        return roomService.findByName(name);
    }
}
