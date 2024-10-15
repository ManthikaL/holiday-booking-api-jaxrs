/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * author DELL
 */
package com.coursework.resource;

import com.coursework.dao.RoomDAO;
import com.coursework.model.Room;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rooms")
public class RoomResource {
    private RoomDAO dao = new RoomDAO();

    // GET method to retrieve all rooms
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms() {
        return dao.getAllRooms();
    }

    // GET method to retrieve a room by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoomById(@PathParam("id") int id) {
        Room room = dao.getRoomById(id);
        if (room == null) {
            throw new NotFoundException("Room not found");
        }
        return Response.ok(room).build();
    }

    // POST method to add a new room
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRoom(Room room) {
        dao.addRoom(room);
        return Response.status(Response.Status.CREATED).entity(room).build();
    }

    // PUT method to update an existing room
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRoom(@PathParam("id") int id, Room room) {
        Room existing = dao.getRoomById(id);
        if (existing == null) {
            throw new NotFoundException("Room not found");
        }
        dao.updateRoom(room);
        return Response.ok(room).build();
    }

    // DELETE method to delete a room by its ID
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRoom(@PathParam("id") int id) {
        Room existing = dao.getRoomById(id);
        if (existing == null) {
            throw new NotFoundException("Room not found");
        }
        dao.deleteRoom(id);
        return Response.noContent().build();
    }
}
