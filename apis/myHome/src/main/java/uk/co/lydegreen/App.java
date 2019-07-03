package uk.co.lydegreen;
/**
 * Created by richard on 01/11/15.
 */

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.skife.jdbi.v2.DBI;

import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

import uk.co.lydegreen.resources.*;

public class App extends Application<MyHomeConfiguration>{

    //private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    /**
     * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
     */
    @Override
    public void initialize(Bootstrap<MyHomeConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<MyHomeConfiguration>() {

            @Override
            public DataSourceFactory getDataSourceFactory(MyHomeConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new ViewBundle<MyHomeConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(MyHomeConfiguration configuration) {
                return super.getViewConfiguration(configuration);
            }
        });
    }


    /**
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
     */
    @Override
    public void run(MyHomeConfiguration c, Environment e) throws Exception {
        // Common modules
            e.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
                // Configuration
                bind(c).to(MyHomeConfiguration.class);

                // Dao
                final DBIFactory jdbiFactory = new DBIFactory();
                final DBI jdbi = jdbiFactory.build(e, c.getDataSourceFactory(), "mysql");
                registerModules("uk.co.lydegreen.dao", "Dao", (classInfo) -> {
                    @SuppressWarnings("unchecked")
                    Class<Object> daoClass = (Class<Object>) classInfo.load();
                    bind(jdbi.onDemand(daoClass)).to(daoClass);
                });
            }
        });


        // Resources
        registerModules("uk.co.lydegreen.resources", "Resource", (classInfo) -> {
            e.jersey().register(classInfo.load());
            // Register the authenticator with the environment

        });
    }





    // Resources
    private void registerModules(String packageName, String classNameSuffix, Consumer<? super ClassInfo> action) {
        try {
            ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClassesRecursive(packageName)
                    .stream().filter((classInfo) -> classInfo.getName().endsWith(classNameSuffix)).forEach(action);
        } catch (IOException ex) {
            throw new IllegalStateException(ex.getMessage(), ex);
        }
    }
}
