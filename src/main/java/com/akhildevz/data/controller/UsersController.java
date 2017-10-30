package com.akhildevz.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhildevz.data.model.Users;
import com.akhildevz.data.repository.UserJpaRepository;



@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@RequestMapping(value="/all", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Users> findAll(){
		return userJpaRepository.findAll();
	}
	
	@RequestMapping(value="/{name}", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users findByName(@PathVariable final String name){
		return userJpaRepository.findByName(name);
	}
	
	@RequestMapping(value="/load", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users load(@RequestBody final Users users){
		userJpaRepository.save(users);
		return userJpaRepository.findByName(users.getName());
	}
}
