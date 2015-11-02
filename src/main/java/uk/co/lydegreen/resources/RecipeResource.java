package uk.co.lydegreen.resources;

import org.skife.jdbi.v2.DBI;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import uk.co.lydegreen.dao.recipeDAO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by richard on 02/11/15.
*/


@Path("/recipe")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {

    private final recipeDAO recipeDAO;
    private final Validator validator;

    public ContactResource(DBI jdbi, Validator validator) {
        recipeDAO = jdbi.onDemand(recipeDAO.class);
        this.validator = validator;
    }

    @GET
    @Path("/{id}")
    public Response getRecipe(@PathParam("id") int id) {
        // retrieve information about the a recipe with the provided id
        recipeDAO recipe = recipeDAO.getRecipeById(id);
        return Response
                .ok(recipe)
                .build();
    }

}
