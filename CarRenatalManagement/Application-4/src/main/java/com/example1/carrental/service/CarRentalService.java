package com.example1.carrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example1.carrental.model.CarRental;
import com.example1.carrental.repository.CarRentalRepository;



@Service
public class CarRentalService {
	
	@Autowired
	private CarRentalRepository cRepository;
	
	public CarRental getTaskById(String id) {
		return cRepository.findById(id).orElse(null);
	}
	
	public List<CarRental> getTask() {
		return cRepository.findAll();
	}
	
	public CarRental addTask(CarRental cRental) {
		try {
			return cRepository.save(cRental);
		} catch (Exception e) {
			return null;
		}	
	}
	
	public boolean updateTask(String id, CarRental cRental) {
		try {
			if(this.getTaskById(id) == null)
				return false;
			return cRepository.save(cRental) != null;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean deleteTask(String id) {
		try {
			if(this.getTaskById(id) != null)
			    cRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println("error: " + e);
			return false;
		}	
	}

}
