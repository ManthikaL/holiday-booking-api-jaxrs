/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.dao;

/**
 *
 * @author DELL
 */
import com.coursework.model.Booking;
import com.coursework.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private static final List<Customer> customers = new ArrayList<>();
    private static final BookingDAO bookingDAO = new BookingDAO();
    

    // Method to fetch all customers
    public List<Customer> getAllCustomers() {
        return customers;
    }

    // Method to fetch customer by ID
    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    // Method to add a new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to update an existing customer
    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getId() == updatedCustomer.getId()) {
                customers.set(i, updatedCustomer);
                System.out.println("Customer updated: " + updatedCustomer);
                return;
            }
        }
    }

    // Method to delete a customer by ID
    public void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
    }
}
