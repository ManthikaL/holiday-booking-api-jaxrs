package com.coursework.dao;

import com.coursework.model.Booking;
import com.coursework.model.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    // Static list to hold rooms
    private static final List<Room> rooms = new ArrayList<>();
    // DAOs for related entities
    private static final HotelDAO hotelDAO = new HotelDAO();
    private static final BookingDAO bookingDAO = new BookingDAO();

    // Method to get all rooms
    public List<Room> getAllRooms() {
        return rooms;
    }

    // Method to get a room by its ID
    public Room getRoomById(int id) {
        // Iterate through the list of rooms
        for (Room room : rooms) {
            // Check if the current room has the specified ID
            if (room.getId() == id) {
                // Return the room if found
                return room;
            }
        }
        // Return null if room with specified ID is not found
        return null;
    }

    // Method to add a new room
    public void addRoom(Room room) {
        // Add the new room to the list
        rooms.add(room);
        // TODO: Add the room to its hotel's room list using HotelDAO
    }

    // Method to update an existing room
    public void updateRoom(Room updatedRoom) {
        // Iterate through the list of rooms
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            // Check if the current room has the same ID as the updated room
            if (room.getId() == updatedRoom.getId()) {
                // Replace the old room with the updated room
                rooms.set(i, updatedRoom);
                return;
            }
        }
    }

    // Method to delete a room by its ID
    public void deleteRoom(int id) {
        // Remove the room with the specified ID using a lambda expression
        rooms.removeIf(room -> room.getId() == id);
    }
    
}
