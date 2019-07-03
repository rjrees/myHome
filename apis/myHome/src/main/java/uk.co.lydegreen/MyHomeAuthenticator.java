package uk.co.lydegreen;

/**
 * Created by richard on 06/03/17.
 */
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

public class MyHomeAuthenticator {
    @Override
    public void run(ExampleConfiguration configuration,
                    Environment environment) {
        environment.jersey().register(new OAuthProvider<User>(new ExampleAuthenticator(),
                "SUPER SECRET STUFF"));
    }
}
