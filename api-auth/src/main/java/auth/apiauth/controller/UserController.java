package auth.apiauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import auth.apiauth.model.User;
import auth.apiauth.services.UserServiceImpl;

@RestController
@RequestMapping(value = "api-auth/users")
public class UserController {

	@Autowired
	UserServiceImpl service = new UserServiceImpl();

	public void setService(UserServiceImpl service) {
		this.service = service;
	}

	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<User> list_users(String name) {
		try {
			return this.service.list();
		}  catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users list not found can not connect", e);
	   	}
	}

	@CrossOrigin
	@RequestMapping(value = "/find_by_name", method = RequestMethod.GET, produces = "application/json")
	public User find_by_name(String user_name) {
		try {
			return this.service.findOneByName(user_name);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found", e);
	   	}
	}

	@CrossOrigin
	@RequestMapping(value = "/find_by_code", method = RequestMethod.GET, produces = "application/json")
	public User find_by_code(Long code) {
		try {
			return this.service.findOneByCode(code);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
	   	}
	}

	@CrossOrigin
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = "application/json")
	public User remove_user(Long code) {
		try {
			User usr = (User) this.service.findOneByCode(code);
			if (this.service.remove(usr)) {
				return usr;
			} else {
				return new User();
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User can not be deleted", e);
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public User add_user(@RequestBody User user) {
		try {
			User usr = (User) user;
			if (this.service.add(usr)) {
				return usr;
			} else {
				return new User();
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User can not be created", e);
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/exists", method = RequestMethod.GET, produces = "application/json")
	public User user_exists(String name) {
		try {
			User usr = (User) this.service.findOneByName(name);
			if (this.service.exists(usr)) {
				return usr;
			} else {
				return new User();
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Connection refused", e);
		}
	}
}