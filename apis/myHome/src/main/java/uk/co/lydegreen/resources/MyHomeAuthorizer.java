package uk.co.lydegreen.resources;

public class MyHomeAuthorizer implements Authorizer<User> {

    @Override
    public boolean authorize(User user, String role) {
        return user.getName().equals("good-guy") && role.equals("ADMIN");
        }
}

