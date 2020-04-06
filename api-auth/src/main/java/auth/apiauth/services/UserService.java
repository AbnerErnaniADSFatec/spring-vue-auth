package auth.apiauth.services;

import java.util.List;
import auth.apiauth.model.User;

public interface UserService {
    List<User> list();
    User findOneByName(String name);
    User findOneByCode(Long codigo);
    boolean remove(User user);
    boolean add(User user);
    boolean exists(User user);
}