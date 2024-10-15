package com.coursework.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Hotel class representing a hotel entity.
 * This class includes details about the hotel such as its ID, name, address,
 * and a list of rooms associated with the hotel.
 * The class uses Jackson annotations to include non-null fields during JSON serialization.
 * 
 * Author: DELL
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hotel {
    private int id;
    private String name;
    private String address;
    private List<Room> rooms;

    // Default constructor
    public Hotel() {
    }

    // Parameterized constructor
    public Hotel(int id, String name, String address, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

    // Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter for rooms
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
