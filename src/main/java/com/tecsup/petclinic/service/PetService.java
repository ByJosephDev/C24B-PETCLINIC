package com.tecsup.petclinic.service;

import java.util.List;
import com.tecsup.petclinic.domain.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

/**
 * 
 * @author jgomezm
 *
 */
public interface PetService {

	Pet create(Pet pet);
	Pet update(Pet pet);
	void delete(Long id) throws PetNotFoundException;
	Pet findById(long id) throws PetNotFoundException;
	List<Pet> findByName(String name);
	List<Pet> findByTypeId(int typeId);
	List<Pet> findByOwnerId(int ownerId);
	Iterable<Pet> findAll();

}