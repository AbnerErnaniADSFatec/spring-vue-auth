package auth.apiauth.handler;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String param) {
        super("User not found for " + param);
    }
}