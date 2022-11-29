package controllers;

import models.Planet;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StartWarsClient;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class PlanetController extends Controller {
    private final StartWarsClient startWarsClient;

    @Inject
    public PlanetController(StartWarsClient client) {
        this.startWarsClient = client;
    }

    public CompletionStage<Result> firstPlanet() {
        return this.startWarsClient.getFirstPlanet().thenApply(jsonPlanet -> {
            Planet planet = Json.fromJson(jsonPlanet, Planet.class);
            return ok(planet.toString());
        });
    }
}
