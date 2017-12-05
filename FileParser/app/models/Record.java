package models;

import com.avaje.ebean.Model;
import play.data.FormFactory;
import play.data.validation.Constraints;
import play.data.validation.ValidationError;
import utils.ParsingUtil;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sudheer on 9/13/17.
 */

@Entity
public class Record extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    public String firstName;

    public String lastName;

    public String address;

    public String zipCode;

    public String phoneNumber;

    public String color;

    public static final Finder<Long, Record> find = new Finder<>(Record.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", color='" + color + '\'' +
                '}';
    }


    public List<ValidationError> validate() {
        final List<ValidationError> errors = new ArrayList<>();
        ParsingUtil parsingUtil = new ParsingUtil();
        if (!parsingUtil.validateAddress(this.address))
            errors.add(new ValidationError("address", "Invalid Format, Please enter in this format: \"1 Hiddem ridge\""));
        if (!parsingUtil.validateColor(this.color))
            errors.add(new ValidationError("color", "Invalid Format, Please enter in this format: \"Golden\""));
        if (!parsingUtil.validateFNameOrLName(this.firstName))
            errors.add(new ValidationError("firstName", "Invalid Format, Please enter in this format: \"Duck\""));
        if (!parsingUtil.validateFNameOrLName(this.lastName))
            errors.add(new ValidationError("lastName", "Invalid Format, Please enter in this format: \"Donald\""));
        if (!parsingUtil.validatePhoneNumber(this.phoneNumber))
            errors.add(new ValidationError("phoneNumber", "Invalid Format, Please enter in this format: (703)-742-0996 or 703 955 0373 or 876-543-2104"));
        if (!parsingUtil.validateZipCode(this.zipCode))
            errors.add(new ValidationError("zipCode", "Invalid Format, Please enter in this format: 94087 or 94087-4444"));

        return errors;
    }
}
