package main.java.pl.jakubmarcinkowski.projekt.client;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

public class TrackingClient {

    static Client client = ClientBuilder.newClient ();
    private static final String PATH = "http://tracking:8080/tracking";


    public static List<Event> getLogs() {
        return client
                .target ( PATH+"/logs" )
                .request ( MediaType.APPLICATION_JSON )
                .get(Response.class)
                .readEntity(new GenericType<List<Event>>() {});
    }

    public static Response addEvent(Event event) {

        return client
                .target ( PATH + "/event" )
                .request ( MediaType.APPLICATION_JSON )
                .post ( Entity.entity ( event, MediaType.APPLICATION_JSON ) );
    }
}
