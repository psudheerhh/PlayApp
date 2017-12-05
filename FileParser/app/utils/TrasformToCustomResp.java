package utils;

import models.APIModels.CustomAPI.CustomResponse;

import java.util.concurrent.CompletionStage;

/**
 * Created by sudheer on 9/14/17.
 */
public interface TrasformToCustomResp {

    public CompletionStage<CustomResponse> transformToMax2Resp(String fourSquareResponseString) ;
}