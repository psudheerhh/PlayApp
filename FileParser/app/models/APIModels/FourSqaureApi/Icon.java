package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */

public class Icon
{
    private String prefix;

    private String suffix;

    public String getPrefix ()
    {
        return prefix;
    }

    public void setPrefix (String prefix)
    {
        this.prefix = prefix;
    }

    public String getSuffix ()
    {
        return suffix;
    }

    public void setSuffix (String suffix)
    {
        this.suffix = suffix;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [prefix = "+prefix+", suffix = "+suffix+"]";
    }
}

