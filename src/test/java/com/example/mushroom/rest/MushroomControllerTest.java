package com.example.mushroom.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.mushroom.domain.Mushrooms;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:mushroom-schema.sql",
		"classpath:mushroom-data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")

public class MushroomControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;

	@Test
	public void testCreateCont() throws Exception {
		Mushrooms newMushroom = new Mushrooms("puffball", "mushroom", 1, "yes");

		String newJCSON = this.map.writeValueAsString(newMushroom);

		RequestBuilder mockRequest = post("/createMushroom").contentType(MediaType.APPLICATION_JSON).content(newJCSON);

		Mushrooms savedMushroom = new Mushrooms(2L, "puffball", "mushroom", 1, "yes");

		String savedCJSON = this.map.writeValueAsString(savedMushroom);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedCJSON);

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	public void getOneContTest() throws Exception {
		Mushrooms entry = new Mushrooms(1L, "puffball", "mushroom", 1, "yes");
		String entryAsJSON = this.map.writeValueAsString(entry);

		mock.perform(get("/getOne/1")).andExpect(status().isOk()).andExpect(content().json(entryAsJSON));

	}

	@Test
	public void getAllContTest() throws Exception {

		Mushrooms entry = new Mushrooms(1L, "puffball", "mushroom", 1, "yes");
		List<Mushrooms> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = this.map.writeValueAsString(output);

		mock.perform(get("/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void testUpdateCont() throws Exception {
		Mushrooms newMushroom = new Mushrooms("puffball", "mushroom", 1, "yes");

		String newJCSON = this.map.writeValueAsString(newMushroom);

		RequestBuilder mockRequest = post("/createMushroom").contentType(MediaType.APPLICATION_JSON).content(newJCSON);

		Mushrooms savedMushroom = new Mushrooms(2L, "puffball", "mushroom", 1, "yes");

		String savedCJSON = this.map.writeValueAsString(savedMushroom);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedCJSON);

		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

	@Test
	public void deleteTest() throws Exception {
		mock.perform(delete("/removeMushroom/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
		

	}
}
