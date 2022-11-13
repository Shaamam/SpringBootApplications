package com.example1.taskm.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example1.taskm.model.Taskm;
import com.example1.taskm.repository.taskmRepository;

@Service
public class taskmService {
	@Autowired
	private taskmRepository tRepository;
	
	public Taskm getTaskById(String id) {
		return tRepository.findById(id).orElse(null);
	}
	
	public List<Taskm> getTaskBytaskHolderName(String name) {
		
		return (List<Taskm>)tRepository.findBytaskHolderName(name);
	}
	
	public List<Taskm> getTask() {
		return tRepository.findAll();
	}
	
	public Taskm addTask(Taskm tsTaskm) {
		try {
			return tRepository.save(tsTaskm);
		} catch (Exception e) {
			return null;
		}	
	}
	
	public boolean updateTask(String id, Taskm tsTaskm) {
		try {
			if(this.getTaskById(id) == null)
				return false;
			return tRepository.save(tsTaskm) != null;
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
	
	
	
	
	
