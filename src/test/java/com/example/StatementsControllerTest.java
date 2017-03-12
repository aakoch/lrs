package com.example;

import javax.json.*;
import javax.json.JsonReader;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.adamkoch.lrs.*;
import gov.adlnet.xapi.model.adapters.StatementObjectAdapter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class StatementsControllerTest extends JerseyTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    @Override
    protected Application configure() {
        return new ResourceConfig(StatementsController.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {

        InputStream is = getClass().getClassLoader().getResourceAsStream("examples/simple_statement.json");
        assert is != null;
//        com.google.gson.stream.JsonReader jsonReader2 = new com.google.gson.stream.JsonReader(new InputStreamReader(is));
//        jsonReader2.

        JsonReader jsonReader = Json.createReader(is);
        JsonObject jsonObject = jsonReader.readObject();

        String id = jsonObject.getString("id");
        System.out.println("id = " + id);

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(jsonObject.getString("timestamp"));//2015-11-18T12:17:00+00:00

        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        // "timestamp": "2013-09-09 21:36:40.185841+00:00"

        JsonObject actorJsonObject = jsonObject.getJsonObject("actor");

        Actor actor = new ActorBuilder()

                .build();

        JsonObject verbJsonObject = jsonObject.getJsonObject("verb");
        JsonObject objectJsonObject = jsonObject.getJsonObject("object");


        Statement statement = new StatementBuilder()
                .id(StatementId.of(id))
                .timestamp(localDateTime)
                .actor(actor)
                .build();



//        JsonStructure jsonStructure = jsonReader.read();
        System.out.println("jsonObject = " + jsonObject);

        target().path("statements").request().put(Entity.json(jsonObject));


        final String responseMsg = target().path("statements").request().get(String.class);

        assertEquals("Hello, Heroku!", responseMsg);
    }
}
