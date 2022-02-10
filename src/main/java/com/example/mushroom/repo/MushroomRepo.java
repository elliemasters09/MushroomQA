package com.example.mushroom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mushroom.domain.Mushrooms;

@Repository
public interface MushroomRepo extends JpaRepository<Mushrooms, Long> {
	

}
