package auth.apiauth.services;

import java.util.List;
import auth.apiauth.model.User;

public interface UserService {
    List<User> findAll();
}