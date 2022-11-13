package com.example1.travellist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example1.travellist.model.TravelList;
import com.example1.travellist.repositoory.TravelListRepository;

@Service
public class TravelListService {
	
		@Autowired
       TravelListRepository tRepository;
		
		public TravelList getTaskById(String id) {
			return tRepository.findById(id).orElse(null);
		}
		
		public List<TravelList> getTask() {
			return tRepository.findAll();
		}
		
		public TravelList addTask(TravelList tList) {
			try {
				return tRepository.save(tList);
			} catch (Exception e) {
				return null;
			}	
		}
		
		public boolean updateTask(String id,TravelList tList) {
			try {
				if(this.getTaskById(id) == null)
					return false;
				return tRepository.save(tList) != null;
			}
			catch (Exception e) {
				return false;
			}
		}
		
		public boolean deleteTask(String id) {
			try {
				if(this.getTaskById(id) != null)
				    tRepository.deleteById(id);
				return true;
			} catch (Exception e) {
				System.out.println("error: " + e);
				return false;
			}	
		}
       
       
	
	

}
