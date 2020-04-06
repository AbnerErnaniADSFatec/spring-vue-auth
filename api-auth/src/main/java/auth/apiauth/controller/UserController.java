package auth.apiauth.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import auth.apiauth.model.User;
import auth.apiauth.model.UserRepository;
import auth.apiauth.services.UserServiceImpl;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/api_auth")
public class UserController {

	@Autowired
	UserServiceImpl service = new UserServiceImpl();

	public void setService(UserServiceImpl service) {
		this.service = service;
	}

	@RequestMapping(value = "/list_users", method = RequestMethod.GET, produces = "application/json")
	public List<User> list_users() {
		return service.list();
	}

	@RequestMapping(value = "/find_by_name", method = RequestMethod.GET, produces = "application/json")
	public User find_by_name(String user_name) {
		return service.findOneByName(user_name);
	}

	@RequestMapping(value = "/find_by_code", method = RequestMethod.GET, produces = "application/json")
	public User find_by_code(Long code) {
		return service.findOneByCode(code);
	}

	@RequestMapping(value = "/add_user", method = RequestMethod.GET, produces = "application/json")
	public User add_user(Long code) {
		if (service.add(new User())) {
			return new User();
		} else {
			return new User();
		}
	}

	@RequestMapping(value = "/remove_user", method = RequestMethod.GET, produces = "application/json")
	public User remove_user(Long code) {
		if (service.remove(new User())) {
			return new User();
		} else {
			return new User();
		}
	}

	@RequestMapping(value = "/user_exists", method = RequestMethod.GET, produces = "application/json")
	public User user_exists(Long code) {
		if (service.exists(new User())) {
			return new User();
		} else {
			return new User();
		}
	}
}