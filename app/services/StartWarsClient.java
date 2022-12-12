package services;

import com.typesafe.config.Config;
import lombok.experimental.FieldDefaults;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
public class StartWarsClient {
    WSClient ws;
    String apiUrl;

    @Inject
    public StartWarsClient(WSClient ws, Config config) {
        this.ws = ws;
        this.apiUrl = config.getString("api-url");
    }

    public <T> CompletionStage<T> getResource(String resourceUrl, Class<T> valueType) {
        String fullUrl;
        if (resourceUrl.startsWith("http")) {
            fullUrl = resourceUrl;
        } else {
            fullUrl = apiUrl + resourceUrl;
        }
        return ws.url(fullUrl)
                .get()
                .thenApply(WSResponse::asJson)
                .thenApply(json -> Json.fromJson(json, valueType));
    }
}
