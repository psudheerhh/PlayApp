package models.APIModels.FourSqaureApi;

import java.util.HashMap;

/**
 * Created by sudheer on 9/13/17.
 */
public class FourSquareRequest {
    private String URL;
    private HashMap<String,String> queryParams;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public HashMap<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(HashMap<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    @Override
    public String toString() {
        return "FourSquareRequest{" +
                "URL='" + URL + '\'' +
                ", queryParams=" + queryParams +
                '}';
    }
}


