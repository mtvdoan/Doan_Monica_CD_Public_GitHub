package com.codingdojo.dojosninjas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojos;
import com.codingdojo.dojosninjas.models.Ninjas;
import com.codingdojo.dojosninjas.repositories.NinjasRepository;

@Service
public class NinjasServices{
	@Autowired
    private final NinjasRepository ninjasRepository;
	
	public NinjasServices(NinjasRepository ninjasRepository) {
		this.ninjasRepository = ninjasRepository;
	}
	
	public Ninjas getOne(Long id) {
		Optional<Ninjas> ninjas = ninjasRepository.findOneById(id);
		if(ninjas.isPresent()) {
			return ninjas.get();
		}
		else {
			return null;
		}
	}
	
	public List<Ninjas> getAll(){
		return ninjasRepository.findAll();
	}
	
	public Ninjas createNinjas(Ninjas ninjas) {
		return ninjasRepository.save(ninjas);
	}
	
	public Ninjas findNinjas(Long id) {
		Optional<Ninjas> optionalNinjas = ninjasRepository.findById(id);
		if(optionalNinjas.isPresent()) {
	      return optionalNinjas.get();
		} 
		else {
			return null;
		}
	}
	
	public Ninjas updateDojos(Ninjas ninjas) {
		return ninjasRepository.save(ninjas);
    }
	
	public void deleteNinjas(Long id) {
		ninjasRepository.deleteById(id);
	}
	
    public List<Ninjas> byDojo(Dojos dojos) {
    	return ninjasRepository.findAllByDojos(dojos);
    }
}