package com.akhildevz.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.akhildevz.data.model.Users;

@Component
public interface UserJpaRepository extends JpaRepository<Users, Long>{

	Users findByName(String name);

}
