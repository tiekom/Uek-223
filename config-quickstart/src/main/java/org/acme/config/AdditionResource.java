package org.acme.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class AdditionResource {
    @GET
    @Path("/{first}/{second}")
    @Produces(MediaType.TEXT_HTML)
    public String add(@PathParam("first") int first, @PathParam("second") int second) {
        return String.valueOf(first + second);
    }
}
