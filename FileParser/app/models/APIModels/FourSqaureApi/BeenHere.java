package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */

public class BeenHere
{
    private int lastCheckinExpiredAt;

    public int getLastCheckinExpiredAt ()
    {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt (int lastCheckinExpiredAt)
    {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastCheckinExpiredAt = "+lastCheckinExpiredAt+"]";
    }
}

