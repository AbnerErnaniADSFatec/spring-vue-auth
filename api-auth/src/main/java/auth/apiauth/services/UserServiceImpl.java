package auth.apiauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import auth.apiauth.model.User;
import auth.apiauth.model.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> list() {
        try {
            return (List<User>) this.repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<User>();
        }
    }

    @Override
    public User findOneByName(String name) {
        try {
            List<User> result = (List<User>) this.repository.findOneByName(name.toLowerCase());
            return result.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return new User();
        }
    }

    @Override
    public User findOneByCode(Long codigo) {
        try {
            List<User> result = (List<User>) this.repository.findOneByCode(codigo);
            return result.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return new User();
        }
    }

    @Override
    public boolean remove(User user) {
        try {
            this.repository.delete(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(User user) {
        try {
            this.repository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean exists(User user) {
        try {
            return this.repository.existsById(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}