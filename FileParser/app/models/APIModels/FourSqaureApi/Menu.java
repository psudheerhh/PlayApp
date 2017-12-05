package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */

public class Menu
{
    private String label;

    private String type;

    private String mobileUrl;

    private String url;

    private String anchor;

    private String externalUrl;

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getMobileUrl ()
    {
        return mobileUrl;
    }

    public void setMobileUrl (String mobileUrl)
    {
        this.mobileUrl = mobileUrl;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getAnchor ()
    {
        return anchor;
    }

    public void setAnchor (String anchor)
    {
        this.anchor = anchor;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [label = "+label+", type = "+type+", mobileUrl = "+mobileUrl+", url = "+url+", anchor = "+anchor+"]";
    }
}


