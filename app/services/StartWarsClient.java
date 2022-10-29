package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.Config;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

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
     *
     * @return JSON Node that can be converted to Planet class
     */
    public CompletableFuture<JsonNode> getFirstPlanet() {
        return getPlanetById(1);
    }

    public CompletableFuture<JsonNode> getPlanetById(Integer planetId) {
        return ws.url(apiUrl + "planets/" + planetId)
                .get()
                .thenApply(WSResponse::asJson)
                .toCompletableFuture();
    }

    public CompletableFuture<JsonNode> getResource(String resource) {
        return ws.url(resource)
                .get()
                .thenApply(WSResponse::asJson)
                .toCompletableFuture();

    }

}
