package com.codingdojo.savetravels.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.SaveTravels;
import com.codingdojo.savetravels.repositories.SaveTravelsRepository;

@Service
public class SaveTravelsServices{
	@Autowired
    private final SaveTravelsRepository saveTravelsRepository;
    
	public SaveTravelsServices(SaveTravelsRepository saveTravelsRepository) {
		this.saveTravelsRepository = saveTravelsRepository;
	}
	
	public List<SaveTravels> getAll(){
		return saveTravelsRepository.findAll();
	}
	
	public SaveTravels getOne(Long id) {
		Optional<SaveTravels> saveTravels = saveTravelsRepository.findOneById(id);
		if(saveTravels.isPresent()) {
			return saveTravels.get();
		}
		else {
			return null;
		}
	}
	

	public SaveTravels createSaveTravels(SaveTravels saveTravels) {
		return saveTravelsRepository.save(saveTravels);
	}
	
	public SaveTravels findSaveTravels(Long id) {
		Optional<SaveTravels> optionalSaveTravels = saveTravelsRepository.findById(id);
		if(optionalSaveTravels.isPresent()) {
	      return optionalSaveTravels.get();
		} 
		else {
			return null;
		}
	}
	
	public SaveTravels updateSaveTravels(SaveTravels saveTravels) {
		return saveTravelsRepository.save(saveTravels);
    }
	
	public void deleteSaveTravels(Long id) {
		saveTravelsRepository.deleteById(id);
	}

}