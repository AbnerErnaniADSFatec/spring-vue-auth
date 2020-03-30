package auth.apiauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import auth.apiauth.model.User;
import auth.apiauth.model.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }
}