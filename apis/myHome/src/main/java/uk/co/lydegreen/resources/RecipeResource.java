package uk.co.lydegreen.resources;

import org.skife.jdbi.v2.DBI;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import uk.co.lydegreen.representations.Recipe;
import uk.co.lydegreen.dao.RecipeDAO;
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

    private final RecipeDAO recipeDAO;
    private final Validator validator;

    public RecipeResource(DBI jdbi, Validator validator) {
        recipeDAO = jdbi.onDemand(RecipeDAO.class);
        this.validator = validator;
    }

    @GET
    @Path("/{id}")
    public Response getRecipeById(@PathParam("id") int id) {
        // retrieve information about the a recipe with the provided id
        Recipe recipe = recipeDAO.getRecipeById(id);
        return Response
                .ok(recipe)
                .build();
    }
    @POST
    @Path("/add")
    public Response createRecipe(Recipe recipe, @PathParam("UID") String UID, @PathParam("name") String name, @PathParam("description") String description); {
    Recipe recipe = recipeDAO.createRecipe(UID, name, description);
        return Response
                .ok(id)
                .build();
    }
}
