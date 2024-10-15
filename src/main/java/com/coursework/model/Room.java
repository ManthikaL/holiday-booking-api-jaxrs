package com.coursework.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Room class representing a room entity.
 * This class includes details about the room such as its ID, room number, type,
 * the hotel it belongs to, and a list of bookings associated with the room.
 * The class uses Jackson annotations to include non-null fields during JSON serialization.
 * 
 * Author: DELL
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Room {
    private int id;
    private String roomNumber;
    private String type;
    private Hotel hotel;
    private List<Booking> bookings;

    // Default constructor
    public Room() {
    }

    // Parameterized constructor
    public Room(int id, String roomNumber, String type, Hotel hotel, List<Booking> bookings) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.hotel = hotel;
        this.bookings = bookings;
    }

    // Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for room number
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Getter and setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for hotel
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    // Getter and setter for bookings
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
