package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.Config;
import models.Planet;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

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

    public CompletionStage<JsonNode> getPlanetById(Long planetId) {
        return ws.url(apiUrl + "planets/" + planetId)
                .get()
                .thenApply(WSResponse::asJson);
    }

    public List<CompletionStage<JsonNode>> getPlanetResidents(Planet planet) {
        return planet.getResidents().stream()
                .map(ws::url)
                .map(WSRequest::get)
                .map(response -> response.thenApply(WSResponse::asJson))
                .collect(Collectors.toList());
    }
}
