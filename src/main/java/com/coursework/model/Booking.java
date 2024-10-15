package com.coursework.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Booking class representing a booking entity.
 * This class includes details about the booking such as start and end dates,
 * associated customer, room, and payment information.
 * The class uses Jackson annotations to include non-null fields during JSON serialization.
 * 
 * Author: DELL
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking {
    private int id;
    private String startDate;
    private String endDate;
    private Customer customer;
    private Room room;
    private Payment payment;

    // Default constructor
    public Booking() {
    }

    // Parameterized constructor
    public Booking(int id, String startDate, String endDate, Customer customer, Room room, Payment payment) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.room = room;
        this.payment = payment;
    }

    // Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for start date
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    // Getter and setter for end date
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // Getter and setter for customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Getter and setter for room
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // Getter and setter for payment
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }   
}
