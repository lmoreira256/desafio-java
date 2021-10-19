package com.evoluum.desafio.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EstadoServiceTests {

	@Autowired
	private EstadoService estadoService;

	@Test
	void getAll() throws Exception {
		String estadoString = estadoService.getAll();

		assertNotNull(estadoString);
		assertTrue(estadoString.length() > 0);
		assertTrue(estadoString.contains("Santa Catarina"));
	}

}
