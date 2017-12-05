package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */
public class FourSquareResponse {
    private Meta meta;
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }


    @Override
    public String toString() {
        return "FourSquareResponse{" +
                "meta=" + meta +
                ", response=" + response +
                '}';
    }
}
