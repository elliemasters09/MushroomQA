package com.example.mushroom.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.example.mushroom.domain.Mushrooms;
import com.example.mushroom.repo.MushroomRepo;

@Service
public class MushroomService implements ServiceCRUD<Mushrooms> {
	
	private MushroomRepo repo;
	
	public MushroomService(MushroomRepo repo) {
		this.repo = repo;
	}

	@Override
	public Mushrooms create(Mushrooms mushroom) {
		return this.repo.save(mushroom);
	}

	@Override
	public List<Mushrooms> getAll() {
		return this.repo.findAll();
		
	}

	@Override
	public Mushrooms getById(Long id) {
		return this.repo.findById(id).orElseThrow(EntityNotFoundException::new);
		
	}
	

	@Override
	public Mushrooms update(Long id, Mushrooms mushroom) {
		Mushrooms existing = this.repo.findById(id).get();
		existing.setName(mushroom.getName());
		existing.setLatin(mushroom.getLatin());
		existing.setDeadliness(mushroom.getDeadliness());
		existing.setIsEdible(mushroom.getIsEdible());
		return this.repo.save(existing);

	}

	@Override
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
}
