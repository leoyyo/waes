package com.waes.web.scalable.controller;

import com.waes.web.scalable.service.DiffService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 * Endpoint for diff two JSON base64 encoded binary data
 */
@Path("/v1/diff")
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
    public Response diff(@PathParam("id") final Integer id) throws Exception {

        List<String> lines = Arrays.asList("The first line", "The second line");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("./diff_files/filename.txt"), "utf-8"))) {
            writer.write("something");
        } catch (Exception e) {
            throw new Exception(e);
        }

        return Response.status(200).build();
    }
}
