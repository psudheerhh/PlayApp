package models.APIModels.FourSqaureApi;

import java.util.List;

/**
 * Created by sudheer on 9/13/17.
 */

public class Location
{
    private double distance;

    private String postalCode;

    private List<LabeledLatLngs> labeledLatLngs;

    private String address;

    private String state;

    private List<String> formattedAddress;

    private double lng;

    private String cc;

    private double lat;

    private String country;

    private String city;

    private String crossStreet;

    public double getDistance ()
    {
        return distance;
    }

    public void setDistance (double distance)
    {
        this.distance = distance;
    }

    public String getPostalCode ()
    {
        return postalCode;
    }

    public void setPostalCode (String postalCode)
    {
        this.postalCode = postalCode;
    }

    public List<LabeledLatLngs> getLabeledLatLngs ()
    {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs (List<LabeledLatLngs> labeledLatLngs)
    {
        this.labeledLatLngs = labeledLatLngs;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public List<String> getFormattedAddress ()
    {
        return formattedAddress;
    }

    public void setFormattedAddress (List<String> formattedAddress)
    {
        this.formattedAddress = formattedAddress;
    }

    public double getLng ()
    {
        return lng;
    }

    public void setLng (double lng)
    {
        this.lng = lng;
    }

    public String getCc ()
    {
        return cc;
    }

    public void setCc (String cc)
    {
        this.cc = cc;
    }

    public double getLat ()
    {
        return lat;
    }

    public void setLat (double lat)
    {
        this.lat = lat;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCrossStreet ()
    {
        return crossStreet;
    }

    public void setCrossStreet (String crossStreet)
    {
        this.crossStreet = crossStreet;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [distance = "+distance+", postalCode = "+postalCode+", labeledLatLngs = "+labeledLatLngs+", address = "+address+", state = "+state+", formattedAddress = "+formattedAddress+", lng = "+lng+", cc = "+cc+", lat = "+lat+", country = "+country+", city = "+city+", crossStreet = "+crossStreet+"]";
    }
}


