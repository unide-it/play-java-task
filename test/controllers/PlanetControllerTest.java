package controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.mvc.Result;
import play.routing.RoutingDsl;
import play.server.Server;
import play.test.Helpers;
import play.test.WSTestClient;
import services.StartWarsClient;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static org.junit.Assert.assertTrue;
import static play.mvc.Results.ok;

public class PlanetControllerTest {
    private PlanetController planetController;
    private WSClient ws;
    private Server server;

    @Before
    public void setup() {
        Config config = ConfigFactory.load().withValue("api-url", ConfigValueFactory.fromAnyRef("/"));
        server = Server.forRouter(
                (components) ->
                        RoutingDsl.fromComponents(components)
                                .GET("/planets/1")
                                .routingTo(request -> {
                                    ObjectNode root = Json.newObject();
                                    root.put("name", "Tatooine");
                                    return ok(root);
                                })
                                .GET("/planets/2")
                                .routingTo(request -> {
                                    ObjectNode root = Json.newObject();
                                    root.put("name", "Alderaan");
                                    ArrayNode residents = root.putArray("residents");
                                    residents.add("/people/2");
                                    return ok(root);
                                })
                                .GET("/people/2")
                                .routingTo(request -> {
                                    ObjectNode root = Json.newObject();
                                    root.put("name", "C-3PO");
                                    return ok(root);
                                })
                                .build()
        );
        ws = WSTestClient.newClient(server.httpPort());
        planetController = new PlanetController(new StartWarsClient(ws, config));
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
    public void getsFirstPlanet() {
        /* when */
        String response = getTextResponse(planetController.firstPlanet());
        /* then */
        assertTrue(response.contains("name=Tatooine"));
    }

    @Test
    public void getsPlanetById() {
        /* when */
        String response = getTextResponse(planetController.getPlanetById(2L));
        /* then */
        assertTrue(response.contains("name=Alderaan"));
        assertTrue(response.contains("residents=[/people/2]"));
        assertTrue(response.contains("name=C-3PO"));
    }

    private static String getTextResponse(CompletionStage<Result> completionStage) {
        return Helpers.contentAsBytes(completionStage.toCompletableFuture().join()).utf8String();
    }
}
