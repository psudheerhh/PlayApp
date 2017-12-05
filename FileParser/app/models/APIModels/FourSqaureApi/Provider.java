package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/14/17.
 */

public class Provider
{
    private String name;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }
}
