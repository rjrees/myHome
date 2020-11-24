package uk.co.lydegreen.auth;

import io.dropwizard.auth.Authorizer;


public class MyHomeAuthorizer implements Authorizer<User>  {

    @Override
    public boolean authorize(User user, String role) {
        return user.getName().equals("good-guy") && role.equals("ADMIN");
        }
}

