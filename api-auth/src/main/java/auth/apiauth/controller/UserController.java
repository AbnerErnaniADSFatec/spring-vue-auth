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
@RequestMapping(value = "/auth")
public class UserController {

	@Autowired
	UserServiceImpl service = new UserServiceImpl();

	public void setService(UserServiceImpl service) {
		this.service = service;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public List<User> users() {
		return service.findAll();
	}
}