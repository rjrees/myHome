package uk.co.lydegreen.resources;

/**
 * Created by richard on 02/11/15.
 */
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.*;
import uk.co.lydegreen.representations.Recipe;
import com.sun.jersey.api.client.*;

@Produces(MediaType.TEXT_PLAIN)
@Path("/client/")
public class ClientResource {

    private Client client;
    public ClientResource(Client client) {
        this.client = client;
    }

}