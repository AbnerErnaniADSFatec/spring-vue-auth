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
    public List<User> list() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User findOneByName(String name) {
        List<User> result = (List<User>) repository.findOneByName(name);
        return result.get(0);
    }

    @Override
    public User findOneByCode(Long codigo) {
        List<User> result = (List<User>) repository.findOneByCode(codigo);
        return result.get(0);
    }

    @Override
    public boolean remove(User user) {
        return true;
    }

    @Override
    public boolean add(User user) {
        return true;
    }

    @Override
    public boolean exists(User user) {
        return true;
    }
}