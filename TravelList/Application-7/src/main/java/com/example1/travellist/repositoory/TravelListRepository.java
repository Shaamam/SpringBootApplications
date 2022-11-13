package com.example1.travellist.repositoory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example1.travellist.model.TravelList;

@Repository
public interface TravelListRepository extends JpaRepository<TravelList, String> {

}
