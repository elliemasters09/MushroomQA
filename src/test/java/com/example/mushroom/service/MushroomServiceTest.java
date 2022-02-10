package com.example.mushroom.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import com.example.mushroom.domain.Mushrooms;
import com.example.mushroom.repo.MushroomRepo;

@SpringBootTest

@ActiveProfiles("test")
public class MushroomServiceTest {

	private Mushrooms newMushroom;
	private Mushrooms savedMushroom;

	@Autowired
	private MushroomService service;

	@MockBean
	private MushroomRepo repo;

	@BeforeEach
	public void setUp() {
		newMushroom = new Mushrooms("black ink cap", "Coprinopsis atramentaria", 5, "no");
		savedMushroom = new Mushrooms(1L, "black ink cap", "Coprinopsis atramentaria", 5, "no");

	}

// :)
	@Test
	public void testCreate() {

//given
//testing data

//when
		Mockito.when(this.repo.save(newMushroom)).thenReturn(savedMushroom);
//then
		assertEquals(savedMushroom, this.service.create(newMushroom));
//verify
		Mockito.verify(this.repo, Mockito.times(1)).save(newMushroom);
	}

	@Test
	public void testGetAll() throws Exception {
		List<Mushrooms> all = new ArrayList<Mushrooms>();
		all.add(new Mushrooms("lack nk ap", "oprinopsis tramentaria", 4, "yes"));
		Mockito.when(this.repo.findAll()).thenReturn(all);
		assertThat(this.service.getAll()).isEqualTo(all);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	public void testGetById() throws Exception {

		Long id = 1L;

		Mushrooms toUpdate = new Mushrooms(id, "lack nk ap", "oprinopsis tramentaria", 4, "yes");
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(toUpdate));
		assertThat(this.service.getById(id)).isEqualTo(toUpdate);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);

	}

	@Test
	public void testUpdate() {
		Long id = 1L;
		Mushrooms toUpdate = new Mushrooms("lack nk ap", "oprinopsis tramentaria", 4, "yes");
		Optional<Mushrooms> optMushrooms = Optional.of(new Mushrooms(id, null, null, 0, null));
		Mushrooms updated = new Mushrooms(id, toUpdate.getName(), toUpdate.getLatin(), toUpdate.getDeadliness(),
				toUpdate.getIsEdible());

		Mockito.when(this.repo.findById(id)).thenReturn(optMushrooms);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		// assertEquals(savedMushroom, this.service.updated());

		assertThat(this.service.update(id, toUpdate)).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);

	}

	// :)
	@Test
	public void testDelete() {
		Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(true, false);
		assertEquals(false, this.service.delete(id));
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

	}

}