package com.waes.web.scalable.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Endpoint for diff two JSON base64 encoded binary data
 */
@Path("/v1/diff")
public class DiffController {

    /**
     * @param id
     * @param input
     *            JSON base64 encoded binary data
     * @return http response 200
     */
    @POST
    @Path("/{id}/left")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response left(@PathParam("id") final Integer id, String input) {

        return Response.status(200).build();
    }

    /**
     * @param id
     * @return http response 200
     */
    @POST
    @Path("/{id}/right")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response right(@PathParam("id") final Integer id, String input) {

        return Response.status(200).build();
    }

    /**
     * @param id
     * @return http response 200
     */
    @GET
    @Path("/{id}")
    public Response diff(@PathParam("id") final Integer id) {

        return Response.status(200).build();
    }
}
