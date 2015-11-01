package uk.co.lydegreen
/**
 * Created by richard on 01/11/15.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.dwbook.phonebook.resources.ContactResource;
import org.skife.jdbi.v2.DBI;
import io.dropwizard.jdbi.DBIFactory;
import com.dwbook.phonebook.resources.ClientResource;
import com.sun.jersey.api.client.Client;
import io.dropwizard.client.JerseyClientBuilder;

public class App extends Application<MyHomeConfiguration>{

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyHomeConfiguration> b) {}


    @Override
    public void run(MyHomeConfiguration c, Environment e) throws Exception {
        LOGGER.info("Method App#run() called");
        for (int i = 0; i < c.getMessageRepetitions(); i++) {
            System.out.println(c.getMessage());
        }
        System.out.println(c.getAdditionalMessage());

        // Create a DBI factory and build a JDBI instance
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory
                .build(e, c.getDataSourceFactory(), "mysql");
        // Add the resource to the environment
        e.jersey().register(new ContactResource(jdbi, e.getValidator()));

        // build the client and add the resource to the environment
        final Client client = new JerseyClientBuilder(e).build("REST Client");
        e.jersey().register(new ClientResource(client));
    }
}
