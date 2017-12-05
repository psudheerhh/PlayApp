package utils;

import models.APIModels.CustomAPI.CustomResponse;
import com.google.inject.Inject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by sudheer on 9/14/17.
 */
public class ParseNodeDirectly implements TrasformToCustomResp {

    private HttpExecutionContext ec;

    @Inject
    public ParseNodeDirectly(HttpExecutionContext ec) {
        this.ec = ec;
    }

    @Override
    public CompletionStage<CustomResponse> transformToMax2Resp(String json) {
        Logger.info("Inside transformToMax2Resp Method in ParseNodeDirectly class");

        return CompletableFuture.supplyAsync((() -> {
            ObjectMapper mapper = new ObjectMapper();
            CustomResponse customResponse = null;

            try {
                JsonNode root = mapper.readTree(json);
                if (root != null) {
                    JsonNode response = root.path("response");
                    if (response != null) {
                        JsonNode venues = response.path("venues");
                        if (venues != null && venues.isArray()) {
                            customResponse = new CustomResponse();
                            List<String> places = new ArrayList<>();
                            for (JsonNode venue : venues) {
                                places.add(venue.path("name").getValueAsText());
                            }
                            customResponse.setPlaces(places);
                        }
                    }
                }
            } catch (JsonGenerationException e) {
                Logger.error(e.getMessage());
            } catch (JsonMappingException e) {
                Logger.error(e.getMessage());
            } catch (IOException e) {
                Logger.error(e.getMessage());
            }

            return customResponse;
        }),ec.current());
    }
}
