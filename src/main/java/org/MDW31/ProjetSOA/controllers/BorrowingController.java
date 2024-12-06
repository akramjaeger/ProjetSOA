package org.MDW31.ProjetSOA.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.MDW31.ProjetSOA.entities.Borrowing;
import org.MDW31.ProjetSOA.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Path("/borrowings")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @GET
    @Path("/borrowings/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @POST
    @Path("/borrowings/submit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBorrowing(Borrowing borrowing) {
        Borrowing savedBorrowing = borrowingService.addBorrowing(borrowing);
        return Response.status(Response.Status.CREATED).entity(savedBorrowing).build();
    }
}

