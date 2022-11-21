package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.Config;
import models.Person;
import models.Planet;
import models.Universe;
import play.libs.Json;
import play.libs.ws.WSClient;
import services.util.ConcurrencyUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class UniverseService {
    private final WSClient ws;
    private final String apiUrl;
    private PersonService personService;

    @Inject
    public UniverseService(WSClient ws,
                           Config config,
                           PersonService personService) {
        this.ws = ws;
        this.apiUrl = config.getString("api-url");
        this.personService = personService;
    }

    public CompletionStage<JsonNode> getUniverseById(long id) {
        try {
            Universe universe = createUniverseWithPlanet(id).get();

            List<CompletableFuture<Person>> futurePersons = personService.fetchUniverseResidents(universe);

            CompletableFuture<List<Person>> peopleFutures = ConcurrencyUtils.sequence(futurePersons);

            return peopleFutures
                    .thenApply(people -> {
                        people.forEach(universe::addPerson);
                        return universe;
                    }).thenApply(Json::toJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Universe> createUniverseWithPlanet(long id) {
        return ws.url(apiUrl + "planets/" + id)
                .get()
                .thenApply(wsResponse -> {
                    Planet planet = Json.fromJson(wsResponse.asJson(), Planet.class);
                    return Universe
                            .builder()
                            .planet(planet)
                            .build();
                }).toCompletableFuture();
    }
}
