package com.coursework.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 * Customer class representing a customer entity.
 * This class includes details about the customer such as their ID, name, email,
 * and a list of bookings associated with the customer.
 * The class uses Jackson annotations to include non-null fields during JSON serialization.
 * 
 * Author: DELL
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    private int id;
    private String name;
    private String email;
    private List<Booking> bookings;

    // Default constructor
    public Customer() {
    }

    // Parameterized constructor
    public Customer(int id, String name, String email, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookings = bookings;
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

    // Getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter for bookings
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
