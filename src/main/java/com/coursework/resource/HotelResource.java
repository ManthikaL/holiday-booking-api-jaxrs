/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.coursework.resource;

import com.coursework.dao.HotelDAO;
import com.coursework.model.Hotel;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hotels")
public class HotelResource {

    private HotelDAO dao = new HotelDAO();

    // GET method to retrieve all hotels
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> getAllHotels() {
        return dao.getAllHotels();
    }

    // GET method to retrieve a hotel by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHotelById(@PathParam("id") int id) {
        Hotel hotel = dao.getHotelById(id);
        if (hotel == null) {
            throw new NotFoundException("Hotel not found");
        }
        return Response.ok(hotel).build();
    }

    // POST method to add a new hotel
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHotel(Hotel hotel) {
        dao.addHotel(hotel);
        return Response.status(Response.Status.CREATED).entity(hotel).build();
    }

    // PUT method to update an existing hotel
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateHotel(@PathParam("id") int id, Hotel hotel) {
        Hotel existing = dao.getHotelById(id);
        if (existing == null) {
            throw new NotFoundException("Hotel not found");
        }
        dao.updateHotel(hotel);
        return Response.ok(hotel).build();
    }

    // DELETE method to delete a hotel by its ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteHotel(@PathParam("id") int id) {
        Hotel existing = dao.getHotelById(id);
        if (existing == null) {
            throw new NotFoundException("Hotel not found");
        }
        dao.deleteHotel(id);
        return Response.noContent().build();
    }
}
