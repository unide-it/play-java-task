package controllers;

import lombok.experimental.FieldDefaults;
import play.mvc.Controller;
import play.mvc.Result;
import services.PlanetService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PlanetController extends Controller {
    PlanetService planetService;

    @Inject
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    public CompletionStage<Result> firstPlanet() {
        return planetService.getFirstPlanet().thenApply(planet -> ok(planet.toString()));
    }

    public CompletionStage<Result> getPlanetById(Long planetId) {
        return planetService.getPlanetById(planetId).thenApply(universe -> ok(universe.toString()));
    }
}
