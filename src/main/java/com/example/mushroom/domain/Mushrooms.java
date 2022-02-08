package com.example.mushroom.domain;

import java.util.Objects;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatin() {
		return latin;
	}

	public void setLatin(String latin) {
		this.latin = latin;
	}

	public int getDeadliness() {
		return deadliness;
	}

	public void setDeadliness(int deadliness) {
		this.deadliness = deadliness;
	}

	public String getIsEdible() {
		return isEdible;
	}

	public void setIsEdible(String isEdible) {
		this.isEdible = isEdible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deadliness, id, isEdible, latin, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mushrooms other = (Mushrooms) obj;
		return deadliness == other.deadliness && Objects.equals(id, other.id)
				&& Objects.equals(isEdible, other.isEdible) && Objects.equals(latin, other.latin)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Mushrooms [id=" + id + ", name=" + name + ", latin=" + latin + ", deadliness=" + deadliness
				+ ", isEdible=" + isEdible + "]";
	}
	
	
	
	

}

