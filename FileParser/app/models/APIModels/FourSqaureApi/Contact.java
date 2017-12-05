package models.APIModels.FourSqaureApi;

/**
 * Created by sudheer on 9/13/17.
 */

public class Contact {
    private String twitter;
    private String phone;
    private String formattedPhone;
    private String instagram;
    private String facebook;
    private String facebookUsername;
    private String facebookName;

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    @Override
    public String toString() {
        return "ClassPojo [twitter = " + twitter + ", phone = " + phone + ", formattedPhone = " + formattedPhone + "]";
    }
}

