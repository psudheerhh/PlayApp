package models.APIModels.FourSqaureApi;

import java.util.List;

/**
 * Created by sudheer on 9/13/17.
 */

public class Groups
{
    private String count;

    private List<String> items;

    private String name;

    private String type;

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public List<String> getItems ()
    {
        return items;
    }

    public void setItems (List<String> items)
    {
        this.items = items;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [count = "+count+", items = "+items+", name = "+name+", type = "+type+"]";
    }
}

