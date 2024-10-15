package com.coursework.dao;

import com.coursework.model.Hotel;
import com.coursework.model.Room;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    // Static list to hold hotels
    private static final List<Hotel> hotels = new ArrayList<>();
    // DAO for related Room entities
    private static final RoomDAO roomDAO = new RoomDAO();

    // Method to get all hotels
    public List<Hotel> getAllHotels() {
        return hotels;
    }

    // Method to get a hotel by its ID
    public Hotel getHotelById(int hotelId) {
        // Iterate through the list of hotels
        for (Hotel hotel : hotels) {
            // Check if the current hotel has the specified ID
            if (hotel.getId() == hotelId) {
                // Return the hotel if found
                return hotel;
            }
        }
        // Return null if hotel with specified ID is not found
        return null;
    }

    // Method to add a new hotel
    public void addHotel(Hotel hotel) {
        // Add the new hotel to the list
        hotels.add(hotel);
    }

    // Method to update an existing hotel
    public void updateHotel(Hotel updatedHotel) {
        // Iterate through the list of hotels
        for (int i = 0; i < hotels.size(); i++) {
            Hotel hotel = hotels.get(i);
            // Check if the current hotel has the same ID as the updated hotel
            if (hotel.getId() == updatedHotel.getId()) {
                // Replace the old hotel with the updated hotel
                hotels.set(i, updatedHotel);
                return;
            }
        }
    }

    // Method to delete a hotel by its ID
    public void deleteHotel(int hotelId) {
        // Remove the hotel with the specified ID using a lambda expression
        hotels.removeIf(hotel -> hotel.getId() == hotelId);
    }
}
