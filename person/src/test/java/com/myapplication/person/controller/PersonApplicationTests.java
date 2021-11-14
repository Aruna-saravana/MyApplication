package com.myapplication.person.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
class PersonApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PersonController person;

	@Test
	public void getCount() throws Exception {

		mvc.perform(get("/person/count").contentType(APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void getAllPersons() throws Exception {

		mvc.perform(get("/persons").contentType(APPLICATION_JSON)).andExpect(status().isOk());

	}

}
