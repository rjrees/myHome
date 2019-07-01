package uk.co.lydegreen;

/**
 * Created by richard on 06/03/17.
 */
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;

public class MyHomeAuthenticator implements Authenticator<BasicCredentials, User> {

    @Override
        public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
            if ("secret".equals(credentials.getPassword())) {
                return Optional.of(new User(credentials.getUsername()));
            }
            return Optional.absent();
        }
    }
