package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.User;


@Repository("userrepository")
public interface UserRepository extends JpaRepository<User,Serializable> {
	
	public abstract User findByUsername(String username);

}
