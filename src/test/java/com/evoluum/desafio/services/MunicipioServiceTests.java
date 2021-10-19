package com.evoluum.desafio.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MunicipioServiceTests {

	@Autowired
	private MunicipioService municipioService;

	@Test
	void getAll() throws Exception {
		String municipiosString = municipioService.getAll();

		assertNotNull(municipiosString);
		assertTrue(municipiosString.length() > 0);
		assertTrue(municipiosString.contains("São Miguel do Oeste"));
	}

	@Test
	void searchByName() throws Exception {
		String municipiosString1 = municipioService.searchByName("saomigueldooeste");
		String municipiosString2 = municipioService.searchByName("São Miguel do Oeste");
		String municipiosString3 = municipioService.searchByName("SãoMiguel doOeste");
		String municipiosString4 = municipioService.searchByName("SÃO MIGUELDOOESTE");

		assertNotNull(municipiosString1);
		assertTrue(municipiosString1.length() > 0);
		assertNotNull(municipiosString2);
		assertTrue(municipiosString2.length() > 0);
		assertNotNull(municipiosString3);
		assertTrue(municipiosString3.length() > 0);
		assertNotNull(municipiosString4);
		assertTrue(municipiosString4.length() > 0);
	}

	@Test
	void searchByNameUnnamed() throws Exception {
		assertThrows(Exception.class, () -> municipioService.searchByName(""));
		assertThrows(Exception.class, () -> municipioService.searchByName("NOME QUE NÃO EXISTE"));
	}

}
