/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.coursework.resource;

import com.coursework.dao.BookingDAO;
import com.coursework.model.Booking;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bookings")
public class BookingResource {

    private BookingDAO dao = new BookingDAO();

    // GET method to retrieve all bookings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> getAllBookings() {
        return dao.getAllBookings();
    }

    // GET method to retrieve a booking by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookingById(@PathParam("id") int id) {
        Booking booking = dao.getBookingById(id);
        if (booking == null) {
            throw new NotFoundException("Booking not found");
        }
        return Response.ok(booking).build();
    }

    // POST method to add a new booking
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBooking(Booking booking) {
        dao.addBooking(booking);
        return Response.status(Response.Status.CREATED).entity(booking).build();
    }

    // PUT method to update an existing booking
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBooking(@PathParam("id") int id, Booking booking) {
        Booking existing = dao.getBookingById(id);
        if (existing == null) {
            throw new NotFoundException("Booking not found");
        }
        dao.updateBooking(booking);
        return Response.ok(booking).build();
    }

    // DELETE method to delete a booking by its ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBooking(@PathParam("id") int id) {
        Booking existing = dao.getBookingById(id);
        if (existing == null) {
            throw new NotFoundException("Booking not found");
        }
        dao.deleteBooking(id);
        return Response.noContent().build();
    }
}
