package com.evoluum.desafio.resources;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class DownloadResourcesTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void json() throws Exception {
		MvcResult response = mvc.perform(get("/download/json")).andExpect(status().isOk()).andReturn();

		assertNotNull(response.getResponse().getContentAsString());
		assertTrue(response.getResponse().getContentAsString().contains("Leste Rondoniense"));
	}

	@Test
	void csv() throws Exception {
		MvcResult response = mvc.perform(get("/download/csv")).andExpect(status().isOk()).andReturn();

		assertNotNull(response.getResponse().getContentAsString());
		assertTrue(response.getResponse().getContentAsString().contains("Leste Rondoniense"));
	}

}
