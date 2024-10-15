package com.coursework.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Payment class representing a payment entity.
 * This class includes details about the payment such as its ID, amount, payment date,
 * payment method, and associated customer and booking information.
 * The class uses Jackson annotations to include non-null fields during JSON serialization.
 * 
 * Author: DELL
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
    private int id;
    private double amount;
    private String paymentDate;
    private String paymentMethod;
    private Customer customer;
    private Booking booking;

    // Default constructor
    public Payment() {
    }

    // Parameterized constructor
    public Payment(int id, double amount, String paymentDate, String paymentMethod, Customer customer, Booking booking) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.customer = customer;
        this.booking = booking;
    }

    // Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter and setter for payment date
    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Getter and setter for payment method
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Getter and setter for customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Getter and setter for booking
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
