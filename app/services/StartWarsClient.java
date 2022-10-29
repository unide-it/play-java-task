package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.Config;
import models.Person;
import models.Planet;
import models.Universe;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class StartWarsClient {

    private final WSClient ws;
    private final String apiUrl;

    @Inject
    public StartWarsClient(WSClient ws, Config config) {
        this.ws = ws;
        this.apiUrl = config.getString("api-url");
    }
    /**
     * get planet example
     * @return JSON Node that can be converted to Planet class
     */
    public CompletionStage<JsonNode> getFirstPlanet() {
        return ws.url(apiUrl + "planets/1")
                .get()
                .thenApply(WSResponse::asJson);
    }
    private CompletionStage<JsonNode> getPlanet(String id) {
        return ws.url(apiUrl + "planets/"+ id)
                .get()
                .thenApply(WSResponse::asJson);
    }
    private CompletionStage<JsonNode> getResident(String id) {
        return ws.url(apiUrl + "people/"+ id)
                .get()
                .thenApply(WSResponse::asJson);
    }
    public String getUniverse(String id) {
        Planet planet = getPlanetById(id);
        List<Person> people = new ArrayList<>();
        planet.getResidents().forEach(url -> {
            people.add(getPersonByUrl(url));
        });
        return new Universe(planet, people).toString();
    }

    private String getResidentId(String url) {
        final String path = url.substring(0, url.length() -1);
        return path.substring(path.lastIndexOf('/') + 1);
    }

    private Planet getPlanetById(String id) {
        return getPlanet(id)
                .thenApply(jsonPlanet -> Json.fromJson(jsonPlanet, Planet.class)).toCompletableFuture().join();
    }

    private Person getPersonByUrl(String url) {
        return getResident(getResidentId(url))
                .thenApply(jsonPerson -> Json.fromJson(jsonPerson, Person.class)).toCompletableFuture().join();
    }

}
