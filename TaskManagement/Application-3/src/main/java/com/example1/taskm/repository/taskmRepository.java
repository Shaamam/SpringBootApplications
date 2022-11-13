package com.example1.taskm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.example1.taskm.model.Taskm;

@Repository
public interface taskmRepository extends JpaRepository<Taskm, String>{
	
	List<Taskm> findBytaskHolderName(String name);

	
	

}

