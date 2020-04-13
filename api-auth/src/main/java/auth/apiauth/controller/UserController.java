package auth.apiauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import auth.apiauth.model.User;
import auth.apiauth.services.UserServiceImpl;

@RestController
@RequestMapping(value = "/api_auth")
public class UserController {

	@Autowired
	UserServiceImpl service = new UserServiceImpl();

	public void setService(UserServiceImpl service) {
		this.service = service;
	}

	@RequestMapping(value = "/list_users", method = RequestMethod.GET, produces = "application/json")
	public List<User> list_users(String name) {
		try {
			return service.list();
		}  catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users list not found can not connect", e);
	   	}
	}

	@RequestMapping(value = "/find_by_name", method = RequestMethod.GET, produces = "application/json")
	public User find_by_name(String user_name) {
		try {
			return service.findOneByName(user_name);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found", e);
	   	}
	}

	@RequestMapping(value = "/find_by_code", method = RequestMethod.GET, produces = "application/json")
	public User find_by_code(Long code) {
		try {
			return service.findOneByCode(code);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
	   	}
	}

	@RequestMapping(value = "/add_user", method = RequestMethod.GET, produces = "application/json")
	public User add_user(Long code) {
		if (service.add(new User())) {
			try {
				return new User();
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User can not be created", e);
			}
		} else {
			return new User();
		}
	}

	@RequestMapping(value = "/remove_user", method = RequestMethod.GET, produces = "application/json")
	public User remove_user(Long code) {
		if (service.remove(new User())) {
			try {
				return new User();
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User can not be deleted", e);
			}
		} else {
			return new User();
		}
	}

	@RequestMapping(value = "/user_exists", method = RequestMethod.GET, produces = "application/json")
	public User user_exists(Long code) {
		if (service.exists(new User())) {
			try {
				return new User();
			} catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Connection refused", e);
			}
		} else {
			return new User();
		}
	}
}