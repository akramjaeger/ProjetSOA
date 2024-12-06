package org.MDW31.ProjetSOA.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.MDW31.ProjetSOA.entities.Author;
import org.MDW31.ProjetSOA.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Path("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @POST
    @Path("/authors/submit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuthor(Author author) {
        Author savedAuthor = authorService.addAuthor(author);
        return Response.status(Response.Status.CREATED).entity(savedAuthor).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAuthor(@PathParam("id") Long id) {
        boolean deleted = authorService.deleteAuthor(id);
        if (deleted) {
            return Response.ok("Author deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Author not found with ID: " + id)
                    .build();
        }
    }
}
