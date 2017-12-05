package models.APIModels.FourSqaureApi;

import java.util.List;

/**
 * Created by sudheer on 9/13/17.
 */

public class HereNow
{
    private String summary;

    private int count;

    private List<Groups> groups;

    public String getSummary ()
    {
        return summary;
    }

    public void setSummary (String summary)
    {
        this.summary = summary;
    }

    public int getCount ()
    {
        return count;
    }

    public void setCount (int count)
    {
        this.count = count;
    }

    public List<Groups>getGroups ()
    {
        return groups;
    }

    public void setGroups (List<Groups> groups)
    {
        this.groups = groups;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [summary = "+summary+", count = "+count+", groups = "+groups+"]";
    }
}

