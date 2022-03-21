package com.sunshine.rest.webservices.restfulwebservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.rest.webservices.restfulwebservices.data.UserRepository;
import com.sunshine.rest.webservices.restfulwebservices.entity.User;

@Service
public class UserService {

//	@Autowired
//	private UserDao userDao;
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findOne(int id) {
		return userRepository.findById(id).get();
	}

	public Boolean deleteById(int id) {
		userRepository.deleteById(id);
		return userRepository.existsById(id);
	}

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

}
