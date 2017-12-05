package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/14/17.
 */

public class VenuePage
{
    private String id;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+"]";
    }
}
