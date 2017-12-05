package models.APIModels.FourSqaureApi;

import java.util.List;

/**
 * Created by sudheer on 9/14/17.
 */
public class Response {
    private List<Venue> venues;
    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
