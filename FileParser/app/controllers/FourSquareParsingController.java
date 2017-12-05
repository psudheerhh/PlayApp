package controllers;

import models.APIModels.FourSqaureApi.*;
import utils.CommonUtil;
import utils.TrasformToCustomResp;
import com.google.inject.Inject;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;

import java.util.*;
import java.util.concurrent.CompletionStage;

import static constants.Constants.*;

/**
 * Created by sudheer on 9/13/17.
 */
public class FourSquareParsingController extends Controller {

    private HttpExecutionContext ec;
    private CommonUtil commonUtil;
    private TrasformToCustomResp trasformToCustomResp;
    private Counter counter;


    @Inject
    public FourSquareParsingController(HttpExecutionContext ec, CommonUtil commonUtil, TrasformToCustomResp trasformToCustomResp, Counter counter) {
        this.ec = ec;
        this.commonUtil = commonUtil;
        this.trasformToCustomResp = trasformToCustomResp;
        this.counter = counter;
    }

    public CompletionStage<Result> getPlaces() {

        Logger.info("Inside getPlaces Method");
        Logger.info("Using the "+ trasformToCustomResp.getClass().getName() +" for converting the response into MaxTwo format");

        Logger.info("Request number " + Integer.toString(counter.nextCount()));

        FourSquareRequest request = new FourSquareRequest();

        HashMap<String, String> requestMap = new HashMap<>();
        requestMap.put(LATITUDE_AND_LONGITUDE, "40.7,-74");
        requestMap.put(VERSION, "20130815");
        requestMap.put(QUERY, "sushi");
        requestMap.put(CLIENT_ID_KEY, CLIENT_ID);
        requestMap.put(CLIENT_ID_SECRET_KEY, CLIENT_ID_SECRET);

        request.setURL("https://api.foursquare.com/v2/venues/search");
        request.setQueryParams(requestMap);

        Logger.info("URL:" + request.getURL());
        Logger.info("Request Params:" + request.getQueryParams());

        CompletionStage<Result> resp = commonUtil.makeApiCallToFourSquareAPI(request)
                .thenComposeAsync(trasformToCustomResp::transformToMax2Resp, ec.current())
                .thenComposeAsync(commonUtil::classToJson,ec.current())
                .thenApplyAsync(res -> res != null ? ok(res) : ok("Oops Something went wrong. We are working on it.Will notify you"), ec.current());

        return resp;

    }

}

