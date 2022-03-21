package com.sunshine.rest.webservices.restfulwebservices.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunshine.rest.webservices.restfulwebservices.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
