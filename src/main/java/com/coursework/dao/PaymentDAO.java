package com.coursework.dao;

import com.coursework.model.Payment;
import com.coursework.model.Customer;
import com.coursework.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // Static list to hold payments
    private static final List<Payment> payments = new ArrayList<>();
    // DAOs for related entities
    private static final CustomerDAO customerDAO = new CustomerDAO();
    private static final BookingDAO bookingDAO = new BookingDAO();

    // Method to get all payments
    public List<Payment> getAllPayments() {
        return payments;
    }

    // Method to get a payment by its ID
    public Payment getPaymentById(int paymentId) {
        // Iterate through the list of payments
        for (Payment payment : payments) {
            // Check if the current payment has the specified ID
            if (payment.getId() == paymentId) {
                // Return the payment if found
                return payment;
            }
        }
        // Return null if payment with specified ID is not found
        return null;
    }

    // Method to add a new payment
    public void addPayment(Payment payment) {
        // Add the new payment to the list
        payments.add(payment);
    }

    // Method to update an existing payment
    public void updatePayment(Payment updatedPayment) {
        // Iterate through the list of payments
        for (int i = 0; i < payments.size(); i++) {
            Payment payment = payments.get(i);
            // Check if the current payment has the same ID as the updated payment
            if (payment.getId() == updatedPayment.getId()) {
                // Replace the old payment with the updated payment
                payments.set(i, updatedPayment);
                return;
            }
        }
    }

    // Method to delete a payment by its ID
    public void deletePayment(int paymentId) {
        // Remove the payment with the specified ID using a lambda expression
        payments.removeIf(payment -> payment.getId() == paymentId);
    }
}
