/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.coursework.resource;

import com.coursework.dao.CustomerDAO;
import com.coursework.model.Customer;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    private CustomerDAO dao = new CustomerDAO();

    // GET method to retrieve all customers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    // GET method to retrieve a customer by their ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") int id) {
        Customer customer = dao.getCustomerById(id);
        if (customer == null) {
            throw new NotFoundException("Customer not found");
        }
        return Response.ok(customer).build();
    }

    // POST method to add a new customer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) {
        dao.addCustomer(customer);
        return Response.status(Response.Status.CREATED).entity(customer).build();
    }

    // PUT method to update an existing customer
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(@PathParam("id") int id, Customer customer) {
        Customer existing = dao.getCustomerById(id);
        if (existing == null) {
            throw new NotFoundException("Customer not found");
        }
        dao.updateCustomer(customer);
        return Response.ok(customer).build();
    }

    // DELETE method to delete a customer by their ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id") int id) {
        Customer existing = dao.getCustomerById(id);
        if (existing == null) {
            throw new NotFoundException("Customer not found");
        }
        dao.deleteCustomer(id);
        return Response.noContent().build();
    }
}
