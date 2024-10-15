/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coursework.resource;

/**
 *
 * author DELL
 */

import com.coursework.dao.PaymentDAO;
import com.coursework.model.Payment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payments")
public class PaymentResource {

    private PaymentDAO dao = new PaymentDAO();

    // GET method to retrieve all payments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> getAllPayments() {
        return dao.getAllPayments();
    }

    // GET method to retrieve a payment by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentById(@PathParam("id") int id) {
        Payment payment = dao.getPaymentById(id);
        if (payment == null) {
            throw new NotFoundException("Payment not found");
        }
        return Response.ok(payment).build();
    }

    // POST method to add a new payment
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPayment(Payment payment) {
        dao.addPayment(payment);
        return Response.status(Response.Status.CREATED).entity(payment).build();
    }

    // PUT method to update an existing payment
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(@PathParam("id") int id, Payment payment) {
        Payment existing = dao.getPaymentById(id);
        if (existing == null) {
            throw new NotFoundException("Payment not found");
        }
        dao.updatePayment(payment);
        return Response.ok(payment).build();
    }

    // DELETE method to delete a payment by its ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePayment(@PathParam("id") int id) {
        Payment existing = dao.getPaymentById(id);
        if (existing == null) {
            throw new NotFoundException("Payment not found");
        }
        dao.deletePayment(id);
        return Response.noContent().build();
    }
}
