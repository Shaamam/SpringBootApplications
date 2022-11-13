package com.example1.webseries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example1.webseries.model.webseries;
import com.example1.webseries.repo.webseriesRepository;


@Service
public class webseriesService {
	@Autowired
	private webseriesRepository wRepository;
	
	public webseries getWebseriesById(Long id) {
		return wRepository.findById(id).orElse(null);
	}
	
	public List<webseries> getWebseriesByName(String name) {
		
		return (List<webseries>)wRepository.findByName(name);
	}
	
	public List<webseries> getWebseries() {
		return wRepository.findAll();
	}
	
	public webseries addWebseries(webseries wsWebseries) {
		try {
			return wRepository.save(wsWebseries);
		} catch (Exception e) {
			return null;
		}	
	}
	
	public boolean updateWebseries(Long id, webseries wrWebseries) {
		try {
			if(this.getWebseriesById(id) == null)
				return false;
			return wRepository.save(wrWebseries) != null;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean deleteWebseries(Long id) {
		try {
			if(this.getWebseriesById(id) != null)
			wRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println("error: " + e);
			return false;
		}	
	}
}
