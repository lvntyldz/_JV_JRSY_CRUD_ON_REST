package com.company.controller;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by root on 3/31/15.
 */

@Path("/")
public class RestController {


    @GET
    @Path("lists")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHelloJson() {
        StringBuilder str = new StringBuilder();
        str.append("[");

        str.append("{");
        str.append("\"name\":\"Levent\",");
        str.append("\"lastName\":\"YILDIZ\",");
        str.append("\"phone\":\"05321234567\",");
        str.append("\"email\":\"aa@bb.cc\"");
        str.append("},");

        str.append("{");
        str.append("\"name\":\"Ali\",");
        str.append("\"lastName\":\"ALİOĞLU\",");
        str.append("\"phone\":\"05321234568\",");
        str.append("\"email\":\"ali@bb.cc\"");
        str.append("},");

        str.append("{");
        str.append("\"name\":\"Veli\",");
        str.append("\"lastName\":\"VELİOĞLU\",");
        str.append("\"phone\":\"05321234569\",");
        str.append("\"email\":\"veli@bb.cc\"");
        str.append("}");

        str.append("]");

        return str.toString();
    }


    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crunchifyREST(InputStream stream) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(stream));
            String line = null;
            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }
        System.out.println("Data Received: " + stringBuilder.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(stringBuilder.toString()).build();
    }

}
