package com.hospital.controller;

import com.hospital.models.Room;
import com.hospital.repos.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/room")
    public Iterable<Room> getRoom() {
        return roomRepository.findAll();
    }

    @PostMapping("/room")
    public @ResponseBody Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @GetMapping("/room/{id_card}")
    public @ResponseBody Optional<Room> getRoom(@PathVariable int id_card) {
        return roomRepository.findById(id_card);
    }

    @DeleteMapping("/room/{id_card}")
    public @ResponseBody void deleteRoom(@PathVariable int id_card) {
        roomRepository.deleteById(id_card);
    }

    @PutMapping("/room/{id}")
    public @ResponseBody Room updateRoom(@RequestBody Room newRoom, @PathVariable Integer id) {
        return roomRepository.findById(id)
                .map(room -> {
                    room.setId_room(newRoom.getId_room());
                    room.setId_hospital(newRoom.getId_hospital());
                    return roomRepository.save(room);
                })
                .orElseGet(() -> {
                    return roomRepository.save(newRoom);
                });
    }
}