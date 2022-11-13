package com.example1.webseries.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.example1.webseries.model.webseries;

@Repository
public interface webseriesRepository extends JpaRepository<webseries, Long>{
	
	List<webseries> findByName(String name);

}
