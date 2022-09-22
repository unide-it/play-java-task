package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import models.Person;
import models.Planet;
import models.Universe;
import play.libs.Json;
import play.mvc.*;
import services.StartWarsClient;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final StartWarsClient client;

    @Inject
    public HomeController(StartWarsClient client) {
        this.client = client;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok("Hello!");
    }

    public CompletionStage<Result> firstPlanet() {
        return this.client.getFirstPlanet().thenApply(jsonPlanet -> {
            Planet planet = Json.fromJson(jsonPlanet, Planet.class);
            return ok(planet.toString());
        });
    }

    public CompletionStage<Result> universeByPlanetId(String id) {
        return this.client.getPlanetById(id).thenApply(jsonPlanet -> {
            Universe universe = new Universe();
            Planet planet = Json.fromJson(jsonPlanet, Planet.class);
            if (!planet.getResidents().isEmpty()) {
                List<CompletableFuture<JsonNode>> completablePersonFutures = planet.getResidents().stream()
                        .map(resident -> this.client.getPerson(resident).toCompletableFuture())
                        .collect(Collectors.toList());
                CompletableFuture.allOf(completablePersonFutures.toArray(new CompletableFuture[0]));

                List<Person> people = completablePersonFutures.stream()
                        .map(jsonPerson -> Json.fromJson(jsonPerson.toCompletableFuture().join(), Person.class))
                        .collect(Collectors.toList());
                universe.setPeople(people);
            }
            universe.setPlanet(planet);
            return ok(universe.toString());
        }).exceptionally(ex -> notFound(Json.toJson("Universe with planet id " + id + " not found")));
    }
}

