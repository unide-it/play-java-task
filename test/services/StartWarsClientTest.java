package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.routing.RoutingDsl;
import play.server.Server;
import services.StartWarsClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.mvc.Results.ok;

public class StartWarsClientTest {

    private StartWarsClient client;
    private WSClient ws;
    private Server server;

    @Before
    public void setup() {
        server = Server.forRouter((components) ->
                RoutingDsl.fromComponents(components).GET("/planets/1").routingTo(request -> {
                            ObjectNode planet = Json.newObject();
                            planet.put("test_key_1", "test_value_1");
                            return ok(planet);
                        })
                        .GET("/planets/2").routingTo(request -> {
                            ObjectNode planet = Json.newObject();
                            planet.put("test_key_2", "test_value_2");
                            return ok(planet);
                        })
                        .GET("/resource").routingTo(request -> {
                            ObjectNode planet = Json.newObject();
                            planet.put("test_key_resource", "test_value_resource");
                            return ok(planet);
                        }).build());
        ws = play.test.WSTestClient.newClient(server.httpPort());
        Config config1 = ConfigFactory.load().withValue("api-url", ConfigValueFactory.fromAnyRef("/"));
        client = new StartWarsClient(ws, config1);
    }

    @After
    public void tearDown() throws IOException {
        try {
            ws.close();
        } finally {
            server.stop();
        }
    }

    @Test
    public void shouldGetFirstPlanet() throws Exception {
        JsonNode jsonNode = client.getFirstPlanet().get(1, TimeUnit.SECONDS);

        assertNotNull(jsonNode);
        assertEquals("{\"test_key_1\":\"test_value_1\"}", jsonNode.toString());
    }

    @Test
    public void shouldGetPlanetById() throws Exception {
        JsonNode jsonNode = client.getPlanetById(2).get(1, TimeUnit.SECONDS);

        assertNotNull(jsonNode);
        assertEquals("{\"test_key_2\":\"test_value_2\"}", jsonNode.toString());
    }

    @Test
    public void shouldGetResource() throws Exception {
        JsonNode jsonNode = client.getResource("/resource").get(1, TimeUnit.SECONDS);

        assertNotNull(jsonNode);
        assertEquals("{\"test_key_resource\":\"test_value_resource\"}", jsonNode.toString());
    }

}