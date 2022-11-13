package com.example1.ec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example1.ec.model.Ecommerce;

@Repository
public interface EcRepository extends JpaRepository<Ecommerce, String> {
	
	List<Ecommerce> findByType(String s);

}
