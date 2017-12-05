package models.APIModels.FourSqaureApi;

import java.util.List;

/**
 * Created by sudheer on 9/13/17.
 */

public class Specials
{
    private int count;

    private List<String> items;

    public int getCount ()
    {
        return count;
    }

    public void setCount (int count)
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

    @Override
    public String toString()
    {
        return "ClassPojo [count = "+count+", items = "+items+"]";
    }
}
