package utils;

import models.APIModels.FourSqaureApi.FourSquareResponse;
import models.APIModels.FourSqaureApi.Venue;
import models.APIModels.CustomAPI.CustomResponse;
import com.google.inject.Inject;
import org.codehaus.jackson.type.TypeReference;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * Created by sudheer on 9/14/17.
 */
public class ConvertToCustomResp implements TrasformToCustomResp {


    private HttpExecutionContext ec;
    private CommonUtil commonUtil;

    @Inject
    public ConvertToCustomResp(HttpExecutionContext ec, CommonUtil commonUtil) {
        this.ec = ec;
        this.commonUtil = commonUtil;
    }

    @Override
    public CompletionStage<CustomResponse> transformToMax2Resp(String fourSquareResponseString) {
        Logger.info("Inside transformToMax2Resp Method in ConvertToCustomResp class");
        return commonUtil.jsonToClass(fourSquareResponseString, new TypeReference<FourSquareResponse>() {
        })
                .thenApplyAsync((res -> {
                    CustomResponse customResponse = null;
                    if (res != null) {
                        List<String> places = new ArrayList<>();
                        models.APIModels.FourSqaureApi.Response response = ((FourSquareResponse) res).getResponse();
                        if (response != null) {
                            List<Venue> venues = response.getVenues();
                            customResponse = new CustomResponse();
                            for (Venue v : venues) {
                                if (v != null && v.getName() != null) {
                                    places.add(v.getName());
                                }
                            }
                            customResponse.setPlaces(places);
                        }
                    }
                    return customResponse;
                }),ec.current());
    }
}
