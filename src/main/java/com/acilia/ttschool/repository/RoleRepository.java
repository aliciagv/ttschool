/*
 *  @author acilia
 */
package com.acilia.ttschool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acilia.ttschool.entity.Role;



@Repository("rolerepository")
public interface RoleRepository extends JpaRepository<Role,Long> {
	
	
}
