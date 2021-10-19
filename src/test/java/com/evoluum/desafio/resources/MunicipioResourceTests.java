package com.evoluum.desafio.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class MunicipioResourceTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void searchByName() throws Exception {
		MvcResult response = mvc.perform(get("/municipios?nomeCidade=São Miguel do Oeste")).andExpect(status().isOk())
				.andReturn();

		assertNotNull(response.getResponse().getContentAsString());
		assertEquals(response.getResponse().getContentAsString(), "4217204");
	}

	@Test
	void searchByNameUnnamed() throws Exception {
		mvc.perform(get("/municipios?nomeCidade=").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError()).andReturn().getResolvedException().getMessage();
	}

	@Test
	void searchByInvalidName() throws Exception {
		mvc.perform(get("/municipios?nomeCidade=nome que não exite").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError()).andReturn().getResolvedException().getMessage();
	}

}
