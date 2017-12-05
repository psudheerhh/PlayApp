package utils;

import models.APIModels.FourSqaureApi.FourSquareRequest;
import com.google.inject.Inject;
import org.asynchttpclient.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static constants.Constants.GET;

/**
 * Created by sudheer on 9/14/17.
 */
public class CommonUtil {

    private HttpExecutionContext ec;

    @Inject
    public CommonUtil(HttpExecutionContext ec) {
        this.ec = ec;
    }

    public CompletionStage<String> makeApiCallToFourSquareAPI(Object obj) {
        Logger.info("Inside the makeApiCallToFourSquareAPI method");
        CompletionStage<String> resp = null;
        if(obj instanceof FourSquareRequest) {
            Logger.info("Request type is FourSquareRequest");
            FourSquareRequest fourSquareRequest = (FourSquareRequest)obj;
            if (fourSquareRequest != null) {
                List<Param> queryParams = null;
                if (fourSquareRequest.getQueryParams() != null) {
                    queryParams = new ArrayList<>();
                    for (Map.Entry<String, String> entry : fourSquareRequest.getQueryParams().entrySet()) {
                        queryParams.add(new Param(entry.getKey(), entry.getValue()));
                    }
                }
                AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
                RequestBuilder reqBuilder = new RequestBuilder(GET)
                        .setUrl(fourSquareRequest.getURL())
                        .addQueryParams(queryParams);
                Request req = reqBuilder.build();

                resp = asyncHttpClient
                        .prepareRequest(req)
                        .execute()
                        .toCompletableFuture()
                        .thenApplyAsync(res -> res.getResponseBody(java.nio.charset.Charset.forName("UTF-8")), ec.current());

            }
        }
        return resp;
    }



    public CompletionStage<Object> jsonToClass(String json, TypeReference<?> reference) {

        Logger.info("Inside the jsonToClass method");
        return CompletableFuture.supplyAsync((() -> {
            Object readValue = null;
            ObjectMapper objmapper = new ObjectMapper();
            if (null != json && !json.trim().equalsIgnoreCase("")) {
                try {
                    readValue = objmapper.readValue(json.trim(), reference);
                } catch (IOException e) {
                    Logger.error(e.getMessage());
                }
            }
            return readValue;
        }),ec.current());
    }

    public CompletionStage<String> classToJson(Object obj) {

        Logger.info("Inside the classToJson method");
        return CompletableFuture.supplyAsync((() -> {
            String readValue = null;
            ObjectMapper objmapper = new ObjectMapper();
            if (null != obj) {
                try {
                    readValue = objmapper.writeValueAsString(obj);
                } catch (IOException e) {
                    Logger.error(e.getMessage());
                }
            }
            return readValue;
        }),ec.current());
    }

}
