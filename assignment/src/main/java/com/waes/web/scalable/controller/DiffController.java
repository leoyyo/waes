package com.waes.web.scalable.controller;

import com.waes.web.scalable.service.DiffService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Endpoint for diff two JSON base64 encoded binary data
 */
@Path("/v1/diff")
@Produces(MediaType.APPLICATION_JSON)
public class DiffController {

    @Autowired
    private DiffService diffService;

    /**
     * @param id
     * @param input JSON base64 encoded binary data
     * @return http response 200
     */
    @POST
    @Path("/{id}/left")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response left(@PathParam("id") final Integer id, String input) {
        JSONObject jsonObject = new JSONObject(input);
        int a = jsonObject.length();
        System.out.println("Json object lenght is: " + a);
        return Response.status(200).entity(diffService.inputLeftData(id,input)).build();
    }

    /**
     * @param id
     * @return http response 200
     */
    @POST
    @Path("/{id}/right")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response right(@PathParam("id") final Integer id, String input) {
        JSONObject jsonObject = new JSONObject(input);
        return Response.status(200).entity(diffService.inputRightData(id,input)).build();
    }

    /**
     * @param id
     * @return http response 200
     */
    @GET
    @Path("/{id}")
    public Response diff(@PathParam("id") final Integer id) throws Exception {
        return Response.status(200).entity(diffService.findById(id)).build();
    }

}
