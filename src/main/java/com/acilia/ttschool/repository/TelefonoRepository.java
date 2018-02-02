package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acilia.ttschool.entity.Telefono;

@Repository("telefonorepository")
public interface TelefonoRepository extends JpaRepository<Telefono,Serializable>{

}
