package uk.co.lydegreen.resources;

import org.skife.jdbi.v2.DBI;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import uk.co.lydegreen.dao.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;
import uk.co.lydegreen.representations.Statement;
/**
 * Created by richard on 02/11/15.
 */

@Path("/statements")
@Produces(MediaType.APPLICATION_JSON)
public class StatementResource {

    private final statementDAO StatementDAO;
    private final Validator validator;

    public StatementResource(DBI jdbi, Validator validator) {
        StatementDAO = jdbi.onDemand(statementDAO.class);
        this.validator = validator;
    }

    @GET
    @Path("/{date}")
    public Response getStatementByDateRange(@PathParam("date") int id) {
        // retrieve information about the a recipe with the provided id
        Statement statement = StatementDAO.getStatementByDateRange(id);
        return Response
                .ok(statement)
                .build();
    }

}