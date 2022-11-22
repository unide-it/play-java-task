package controllers;

import models.Universe;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.UniverseService;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class PlanetController extends Controller {

    private final UniverseService universeService;

    @Inject
    public PlanetController(UniverseService universeService) {
        this.universeService = universeService;
    }

    public CompletionStage<Result> getPlanetById(long id) {
        return this.universeService.getUniverseById(id).thenApply(jsonUniverse -> {
            Universe universe = Json.fromJson(jsonUniverse, Universe.class);
            return ok(universe.toString());
        });
    }
}
