package uk.co.lydegreen;

/**
 * Created by richard on 01/11/15.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import javax.validation.constraints.Max;
import org.hibernate.validator.constraints.NotEmpty;
import io.dropwizard.db.DataSourceFactory;

public class MyHomeConfiguration extends Configuration {
    @JsonProperty()
    private DataSourceFactory database = new DataSourceFactory();
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}