package models.APIModels.CustomAPI;

import java.util.List;

/**
 * Created by sudheer on 9/13/17.
 */

public class CustomResponse {
    private List<String> places;

    public List<String> getPlaces() {
        return places;
    }

    public void setPlaces(List<String> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "{ places = " + places + " }";
    }
}

