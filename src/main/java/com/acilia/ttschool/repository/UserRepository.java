/*
 *  @author acilia
 */
package com.acilia.ttschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.User;


@Repository("userrepository")
public interface UserRepository extends JpaRepository<User,Long> {
	
	public abstract User findByUsername(String username);

}
