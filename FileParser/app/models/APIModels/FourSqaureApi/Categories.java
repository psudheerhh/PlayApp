package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */

public class Categories
{
    private String id;

    private Icon icon;

    private boolean primary;

    private String name;

    private String shortName;

    private String pluralName;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Icon getIcon ()
    {
        return icon;
    }

    public void setIcon (Icon icon)
    {
        this.icon = icon;
    }

    public boolean getPrimary ()
    {
        return primary;
    }

    public void setPrimary (boolean primary)
    {
        this.primary = primary;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getShortName ()
    {
        return shortName;
    }

    public void setShortName (String shortName)
    {
        this.shortName = shortName;
    }

    public String getPluralName ()
    {
        return pluralName;
    }

    public void setPluralName (String pluralName)
    {
        this.pluralName = pluralName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", icon = "+icon+", primary = "+primary+", name = "+name+", shortName = "+shortName+", pluralName = "+pluralName+"]";
    }
}

