package com.example.mushroom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mushrooms {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
		
	private String latin;

	private int deadliness;
		
	private String isEdible;

	public Mushrooms() {
		
	}

	public Mushrooms(Long id, String name, String latin, int deadliness, String isEdible) {
		this.id = id;
		this.name = name;
		this.latin = latin;
		this.deadliness = deadliness;
		this.isEdible = isEdible;
	}

	public Mushrooms(String name, String latin, int deadliness, String isEdible) {
		this.name = name;
		this.latin = latin;
		this.deadliness = deadliness;
		this.isEdible = isEdible;
	}
	
	
	
	

}

