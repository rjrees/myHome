package uk.co.lydegreen.resources;

/**
 * Created by richard on 06/03/17.
 */
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.auth.Authenticator;
import org.eclipse.jetty.server.Authentication;

public class MyHomeAuthenticator implements Authenticator<BasicCredentials, User>{

    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
            if ("secret".equals(credentials.getPassword())) {
                return Optional.of(new User(credentials.getUsername()));
            }
            return Optional.absent();
        }
    }

/*(
    #authenticate() method.
            package com.dwbook.phonebook;
            import com.google.common.base.Optional;
            import io.dropwizard.auth.AuthenticationException;
            import io.dropwizard.auth.Authenticator;
            import io.dropwizard.auth.basic.BasicCredentials;
public class PhonebookAuthenticator implements
        Authenticator<BasicCredentials, Boolean> {
    public Optional<Boolean> authenticate(BasicCredentials
                                                  c) throws AuthenticationException {
        if (c.getUsername().equals("john_doe") &&
                c.getPassword().equals("secret")) {
            return Optional.of(true);
        }
        return Optional.absent();
    }
}
*/