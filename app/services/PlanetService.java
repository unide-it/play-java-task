package services;

import lombok.experimental.FieldDefaults;
import models.Person;
import models.Planet;
import models.Universe;
import utils.CompletableFutureUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PlanetService {
    private final static String PLANET_RESOURCE = "/planets/";
    StartWarsClient startWarsClient;

    @Inject
    public PlanetService(StartWarsClient startWarsClient) {
        this.startWarsClient = startWarsClient;
    }

    public CompletionStage<Planet> getFirstPlanet() {
        return startWarsClient.getResource(PLANET_RESOURCE + 1, Planet.class);
    }

    public CompletionStage<Universe> getPlanetById(Long planetId) {
        return startWarsClient.getResource(PLANET_RESOURCE + planetId, Planet.class)
                .thenApply(planet -> {
                    List<CompletableFuture<Person>> residentsToBeFetched = planet.getResidents().stream()
                            .map(resident -> startWarsClient.getResource(resident, Person.class))
                            .map(CompletionStage::toCompletableFuture)
                            .collect(toList());
                    Collection<Person> people = CompletableFutureUtils.allOf(residentsToBeFetched).join();
                    return new Universe(planet, new ArrayList<>(people));
                });
    }
}
