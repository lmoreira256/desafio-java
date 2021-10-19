package com.evoluum.desafio.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.evoluum.desafio.exceptions.AppExceptionHandler;
import com.evoluum.desafio.gateway.IbgeResource;
import com.evoluum.desafio.resourses.MunicipioResource;

@SpringBootTest
class MunicipioResourceTests {

	private MockMvc mvc;

	@Mock
	private IbgeResource ibgeResource;

	@InjectMocks
	private MunicipioResource municipioResource;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);

		mvc = MockMvcBuilders.standaloneSetup(municipioResource).setControllerAdvice(AppExceptionHandler.class).build();
	}

	@Test
	public void searchByName() throws Exception {
		when(ibgeResource.getAllEstados()).thenReturn("[{id:42},{id:43}]");
		when(ibgeResource.getAllMunicipios(anyString()))
				.thenReturn("[{nome:'São Miguel do Oeste'},{nome:'Guaraciaba'}]");

		MvcResult response = mvc.perform(get("/municipios?nomeCidade=São Miguel do Oeste")).andExpect(status().isOk())
				.andReturn();

		assertNotNull(response.getResponse().getContentAsString());
		assertEquals(response.getResponse().getContentAsString(), "4217204");
	}

	@Test
	public void searchByNameUnnamed() throws Exception {
		when(ibgeResource.getAllEstados()).thenReturn("[{id:42},{id:43}]");
		when(ibgeResource.getAllMunicipios(anyString()))
				.thenReturn("[{nome:'São Miguel do Oeste'},{nome:'Guaraciaba'}]");

		mvc.perform(get("/municipios?nomeCidade=").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError()).andReturn().getResolvedException().getMessage();
	}

	@Test
	public void searchByInvalidName() throws Exception {
		when(ibgeResource.getAllEstados()).thenReturn("[{id:42},{id:43}]");
		when(ibgeResource.getAllMunicipios(anyString()))
				.thenReturn("[{nome:'São Miguel do Oeste'},{nome:'Guaraciaba'}]");

		mvc.perform(get("/municipios?nomeCidade=nome que não exite").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError()).andReturn().getResolvedException().getMessage();
	}

}
