package models.APIModels.FourSqaureApi;

import java.util.List;

/**
 * Created by sudheer on 9/13/17.
 */

public class Venue
{
    private List<Object> venueChains;

    private Location location;

    private Stats stats;

    private boolean hasMenu;

    private Menu menu;

    private boolean allowMenuUrlEdit;

    private HereNow hereNow;

    private Contact contact;

    private String url;

    private Specials specials;

    private String referralId;

    private String id;

    private boolean verified;

    private String name;

    private List<Categories> categories;

    private BeenHere beenHere;

    private boolean hasPerk;

    private Delivery delivery;

    private VenuePage venuePage;

    private String storeId;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public VenuePage getVenuePage() {
        return venuePage;
    }

    public void setVenuePage(VenuePage venuePage) {
        this.venuePage = venuePage;
    }

    public boolean isHasMenu() {
        return hasMenu;
    }

    public boolean isAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public boolean isVerified() {
        return verified;
    }

    public boolean isHasPerk() {
        return hasPerk;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<Object> getVenueChains ()
    {
        return venueChains;
    }

    public void setVenueChains (List<Object> venueChains)
    {
        this.venueChains = venueChains;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public Stats getStats ()
    {
        return stats;
    }

    public void setStats (Stats stats)
    {
        this.stats = stats;
    }

    public boolean getHasMenu ()
    {
        return hasMenu;
    }

    public void setHasMenu (boolean hasMenu)
    {
        this.hasMenu = hasMenu;
    }

    public Menu getMenu ()
    {
        return menu;
    }

    public void setMenu (Menu menu)
    {
        this.menu = menu;
    }

    public boolean getAllowMenuUrlEdit ()
    {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit (boolean allowMenuUrlEdit)
    {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public HereNow getHereNow ()
    {
        return hereNow;
    }

    public void setHereNow (HereNow hereNow)
    {
        this.hereNow = hereNow;
    }

    public Contact getContact ()
    {
        return contact;
    }

    public void setContact (Contact contact)
    {
        this.contact = contact;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public Specials getSpecials ()
    {
        return specials;
    }

    public void setSpecials (Specials specials)
    {
        this.specials = specials;
    }

    public String getReferralId ()
    {
        return referralId;
    }

    public void setReferralId (String referralId)
    {
        this.referralId = referralId;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public boolean getVerified ()
    {
        return verified;
    }

    public void setVerified (boolean verified)
    {
        this.verified = verified;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public List<Categories>  getCategories ()
    {
        return categories;
    }

    public void setCategories (List<Categories>  categories)
    {
        this.categories = categories;
    }

    public BeenHere getBeenHere ()
    {
        return beenHere;
    }

    public void setBeenHere (BeenHere beenHere)
    {
        this.beenHere = beenHere;
    }

    public boolean getHasPerk ()
    {
        return hasPerk;
    }

    public void setHasPerk (boolean hasPerk)
    {
        this.hasPerk = hasPerk;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [venueChains = "+venueChains+", location = "+location+", stats = "+stats+", hasMenu = "+hasMenu+", menu = "+menu+", allowMenuUrlEdit = "+allowMenuUrlEdit+", hereNow = "+hereNow+", contact = "+contact+", url = "+url+", specials = "+specials+", referralId = "+referralId+", id = "+id+", verified = "+verified+", name = "+name+", categories = "+categories+", beenHere = "+beenHere+", hasPerk = "+hasPerk+"]";
    }
}