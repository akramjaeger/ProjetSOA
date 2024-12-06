package org.MDW31.ProjetSOA.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.MDW31.ProjetSOA.entities.Book;
import org.MDW31.ProjetSOA.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Path("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GET
    @Path("/books/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/books/available")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @POST
    @Path("/books/submit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        Book savedBook = bookService.addBook    (book);
        return Response.status(Response.Status.CREATED).entity(savedBook).build();
    }

    @DELETE
    @Path("/books/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return Response.ok("Book deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found with ID: " + id)
                    .build();
        }
    }

    @PUT
    @Path("/books/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") Long id, Book updatedBook) {
        Book book = bookService.updateBook(id, updatedBook);
        if (book != null) {
            return Response.ok(book).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Book not found with ID: " + id)
                    .build();
        }
    }
}
