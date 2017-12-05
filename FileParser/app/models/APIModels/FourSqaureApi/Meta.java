package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */

public class Meta
{
    private String requestId;

    private String code;

    public String getRequestId ()
    {
        return requestId;
    }

    public void setRequestId (String requestId)
    {
        this.requestId = requestId;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [requestId = "+requestId+", code = "+code+"]";
    }
}
