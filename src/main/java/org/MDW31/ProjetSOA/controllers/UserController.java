package org.MDW31.ProjetSOA.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.MDW31.ProjetSOA.entities.User;
import org.MDW31.ProjetSOA.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Path("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GET
    @Path("/users/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @POST
    @Path("/users/submit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        User savedUser = userService.addUser(user);
        return Response.status(Response.Status.CREATED).entity(savedUser).build();
    }

    @DELETE
    @Path("/users/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return Response.ok("User deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found with ID: " + id)
                    .build();
        }
    }
    @PUT
    @Path("/users/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id, User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found with ID: " + id)
                    .build();
        }
    }
}
