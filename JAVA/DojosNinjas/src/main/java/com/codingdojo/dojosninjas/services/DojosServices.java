package com.codingdojo.dojosninjas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojos;
import com.codingdojo.dojosninjas.repositories.DojosRepository;

@Service
public class DojosServices{
	@Autowired
    private final DojosRepository dojosRepository;
    
	public DojosServices(DojosRepository dojosRepository) {
		this.dojosRepository = dojosRepository;
	}
	
	
	public Dojos getOne(Long id) {
		Optional<Dojos> dojos = dojosRepository.findOneById(id);
		if(dojos.isPresent()) {
			return dojos.get();
		}
		else {
			return null;
		}
	}
	
	public List<Dojos> getAll(){
		return dojosRepository.findAll();
	}

	public Dojos createDojos(Dojos dojos) {
		return dojosRepository.save(dojos);
	}
	
	public Dojos findDojos(Long id) {
		Optional<Dojos> optionalDojos = dojosRepository.findById(id);
		if(optionalDojos.isPresent()) {
	      return optionalDojos.get();
		} 
		else {
			return null;
		}
	}
	
	public Dojos updateDojos(Dojos dojos) {
		return dojosRepository.save(dojos);
    }
	
	public void deleteDojos(Long id) {
		dojosRepository.deleteById(id);
	}

}