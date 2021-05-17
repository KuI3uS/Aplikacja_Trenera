package pl.jakubmarcinkowski.projekt.client;

import pl.jakubmarcinkowski.projekt.client.Event;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tracking")
public interface ServiceInterface {

    @GET
    @Path("/logs")
    @Produces({ MediaType.APPLICATION_JSON })
    Response getLogs();


    @POST
    @Path("/event")
    @Consumes({ MediaType.APPLICATION_JSON})
    Response addEvent(Event event);
}