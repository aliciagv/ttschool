package com.acilia.ttschool.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acilia.ttschool.entity.Curso;
import com.acilia.ttschool.entity.Profesor;

@Repository("cursorepository")
public interface CursoRepository extends JpaRepository<Curso,Serializable>{

	 @Query("select c from Curso c where c.id not in (select curso.id from Profesor where curso.id is not null)")
	 public abstract List<Curso> findNotAssigned();
	 
	 public abstract Curso findById(Long id);
}
