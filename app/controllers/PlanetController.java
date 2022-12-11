package controllers;

import models.Person;
import models.Planet;
import models.Universe;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.StartWarsClient;
import utils.CompletableFutureUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static java.util.stream.Collectors.toList;

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

    public CompletionStage<Result> getPlanetById(Long planetId) {
        return this.startWarsClient.getPlanetById(planetId)
                .thenApply(jsonPlanet -> Json.fromJson(jsonPlanet, Planet.class))
                .thenApply(planet -> {
                    List<CompletableFuture<Person>> residentsToBeFetched = this.startWarsClient.getPlanetResidents(planet)
                            .stream()
                            .map(it -> it.thenApply(jsonPerson -> Json.fromJson(jsonPerson, Person.class)))
                            .map(CompletionStage::toCompletableFuture)
                            .collect(toList());
                    Collection<Person> peoples = CompletableFutureUtils.allOf(residentsToBeFetched).join();
                    Universe universe = new Universe(planet, new ArrayList<>(peoples));
                    return ok(universe.toString());
                });
    }
}
