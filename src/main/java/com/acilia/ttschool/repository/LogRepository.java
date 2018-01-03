package com.acilia.ttschool.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Log;

@Repository("logrepository")
public interface LogRepository  extends JpaRepository<Log,Serializable>{

}
