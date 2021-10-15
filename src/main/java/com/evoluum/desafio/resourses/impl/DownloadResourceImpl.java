package com.evoluum.desafio.resourses.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.evoluum.desafio.resourses.DownloadResource;
import com.evoluum.desafio.services.DownloadService;

public class DownloadResourceImpl implements DownloadResource {

	@Autowired
	private DownloadService downloadService;

	private static final String CONTENT_DISPOSITION_FILE_NAME = "attachment;filename=desafio-evoluum.";
	private static final String CONTENT_TYPE_CSV = "text/csv";

	@Override
	public ResponseEntity<?> json() {
		byte[] byteFile = downloadService.json();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, CONTENT_DISPOSITION_FILE_NAME + "json")
				.contentType(MediaType.APPLICATION_JSON).contentLength(byteFile.length).body(byteFile);
	}

	@Override
	public ResponseEntity<?> csv() {
		byte[] byteFile = downloadService.csv();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, CONTENT_DISPOSITION_FILE_NAME + "csv");
		headers.set(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_CSV);

		return ResponseEntity.ok().headers(headers).body(byteFile);
	}

}
