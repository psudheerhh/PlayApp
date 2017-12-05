package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/14/17.
 */

public class Delivery
{
    private String id;

    private Provider provider;

    private String url;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Provider getProvider ()
    {
        return provider;
    }

    public void setProvider (Provider provider)
    {
        this.provider = provider;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", provider = "+provider+", url = "+url+"]";
    }
}

