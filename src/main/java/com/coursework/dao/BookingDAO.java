package com.coursework.dao;

import com.coursework.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    // Static list to hold bookings
    private static final List<Booking> bookings = new ArrayList<>();
    // DAOs for related entities
    private static final CustomerDAO customerDAO = new CustomerDAO();
    private static final RoomDAO roomDAO = new RoomDAO();
    private static final PaymentDAO paymentDAO = new PaymentDAO();

    // Method to get all bookings
    public List<Booking> getAllBookings() {
        return bookings;
    }

    // Method to get a booking by its ID
    public Booking getBookingById(int id) {
        // Iterate through the list of bookings
        for (Booking booking : bookings) {
            // Check if the current booking has the specified ID
            if (booking.getId() == id) {
                // Return the booking if found
                return booking;
            }
        }
        // Return null if booking with specified ID is not found
        return null;
    }

    // Method to add a new booking
    public void addBooking(Booking booking) {
        // Add the new booking to the list
        bookings.add(booking);
        // TODO: Add the room to its hotel's room list using HotelDAO
    }

    // Method to update an existing booking
    public void updateBooking(Booking updatedBooking) {
        // Iterate through the list of bookings
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            // Check if the current booking has the same ID as the updated booking
            if (booking.getId() == updatedBooking.getId()) {
                // Replace the old booking with the updated booking
                bookings.set(i, updatedBooking);
                return;
            }
        }
    }

    // Method to delete a booking by its ID
    public void deleteBooking(int id) {
        // Remove the booking with the specified ID using a lambda expression
        bookings.removeIf(booking -> booking.getId() == id);
    }
}
