package uk.co.lydegreen.representations;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dropwizard.validation.ValidationMethod;
import org.hibernate.validator.constraints.*;
/**
 * Created by richard on 01/11/15.
 */
public class Recipe {

    private final int id;

    @NotBlank
    @Length(min = 2, max = 255)
    private final String firstName;

    @NotBlank
    @Length(min = 2, max = 255)
    private final String lastName;

    @NotBlank
    @Length(min = 2, max = 30)
    private final String phone;


    public Recipe(int id, String firstName, String lastName, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

/**
    @JsonIgnore
    @ValidationMethod(message="John Doe is not a valid person!")
    public boolean isValidPerson() {
        if (firstName.equals("John") && lastName.equals("Doe")) {
            return false;
        } else {
            return true;
        }
    }
**/

}
