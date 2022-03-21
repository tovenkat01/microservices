package com.sunshine.rest.webservices.restfulwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sunshine.rest.webservices.restfulwebservices.entity.Post;
import com.sunshine.rest.webservices.restfulwebservices.entity.User;
import com.sunshine.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.sunshine.rest.webservices.restfulwebservices.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {

		var savedUser = userService.save(user);

		var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> findOne(@PathVariable int id) {
		var user = Optional.ofNullable(userService.findOne(id))
				.orElseThrow(() -> new UserNotFoundException("id-" + id));
		var model = EntityModel.of(user);
		var linkToUsers = linkTo(methodOn(this.getClass()).findAll());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}

	@DeleteMapping("/users/{id}")
	public Boolean deleteById(@PathVariable int id) {
		return Optional.ofNullable(userService.deleteById(id)).filter(t -> equals(t))
				.orElseThrow(() -> new UserNotFoundException("id-" + id));
	}

	@GetMapping("/users/{id}/posts")
	public List<Post> findAllPostsByUser(@PathVariable int id) {
		var user = Optional.ofNullable(userService.findById(id).get())
				.orElseThrow(() -> new UserNotFoundException("id-" + id));
		return user.getPosts();
	}
}
