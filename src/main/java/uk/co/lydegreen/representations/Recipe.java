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
    @Length(min = 2, max = 10)
    private final String UID;

    @NotBlank
    @Length(min = 2, max = 500)
    private final String name;

    @NotBlank
    @Length(min = 2, max = 500)
    private final String description;


    public int getId() {
        return id;
    }


    public Recipe(int id, String UID, String name, String description) {
        this.id = id;
        this.UID = UID;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUID() {
        return UID;
    }



}
