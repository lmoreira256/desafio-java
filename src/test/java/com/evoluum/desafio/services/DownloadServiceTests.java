package com.evoluum.desafio.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DownloadServiceTests {

	@Autowired
	private DownloadService downloadService;

	@Test
	void json() throws Exception {
		byte[] jsonByte = downloadService.json();

		assertNotNull(jsonByte);
		assertTrue(jsonByte.length > 0);
	}

	@Test
	void csv() throws Exception {
		byte[] csvByte = downloadService.csv();

		assertNotNull(csvByte);
		assertTrue(csvByte.length > 0);
	}

}
