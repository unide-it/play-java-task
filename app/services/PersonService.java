package services;

import com.typesafe.config.Config;
import models.Person;
import models.Universe;
import play.libs.Json;
import play.libs.ws.WSClient;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PersonService {
    private final WSClient ws;
    private final String apiUrl;

    @Inject
    public PersonService(WSClient ws, Config config) {
        this.ws = ws;
        this.apiUrl = config.getString("api-url");
    }

    public List<CompletableFuture<Person>> fetchUniverseResidents(Universe universe) {
        return universe
                .getPlanet()
                .getResidents()
                .stream()
                .map(this::fetchPerson)
                .collect(Collectors.<CompletableFuture<Person>>toList());
    }

    public CompletableFuture<Person> fetchPerson(String url) {
        return ws.url(url)
                .get()
                .toCompletableFuture()
                .thenApply(wsResponse -> Json.fromJson(wsResponse.asJson(), Person.class));
    }
}
