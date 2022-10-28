package controllers;

import models.Person;
import models.Planet;
import models.Universe;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StartWarsClient;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

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

    public CompletionStage<Result> planetById(Integer planetId) {
        return this.client.getPlanetById(planetId).thenApply(jsonPlanet -> {
            Planet planet = Json.fromJson(jsonPlanet, Planet.class);
            List<Person> residents = planet.getResidents().parallelStream()
                    .map(client::getResource)
                    .map(CompletableFuture::join)
                    .map(jsonPerson -> Json.fromJson(jsonPerson, Person.class))
                    .collect(Collectors.toList());
            return ok(new Universe(planet, residents).toString());
        });
    }
}
