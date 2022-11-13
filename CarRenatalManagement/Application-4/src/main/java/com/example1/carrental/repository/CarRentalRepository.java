package com.example1.carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example1.carrental.model.CarRental;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental, String> {

}
