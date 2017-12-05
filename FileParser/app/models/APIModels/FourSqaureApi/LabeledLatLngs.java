package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */

public class LabeledLatLngs
{
    private double lng;

    private String label;

    private double lat;

    public double getLng ()
    {
        return lng;
    }

    public void setLng (double lng)
    {
        this.lng = lng;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public double getLat ()
    {
        return lat;
    }

    public void setLat (double lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lng = "+lng+", label = "+label+", lat = "+lat+"]";
    }
}

