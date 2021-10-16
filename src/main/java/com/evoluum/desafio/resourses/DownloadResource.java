package com.evoluum.desafio.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evoluum.desafio.services.DownloadService;

@RestController
@RequestMapping(value = "/download")
public class DownloadResource {

	@Autowired
	private DownloadService downloadService;

	private static final String CONTENT_DISPOSITION_FILE_NAME = "attachment;filename=desafio-evoluum.";
	private static final String CONTENT_TYPE_CSV = "text/csv";

	@Cacheable("json")
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public ResponseEntity<?> json() {
		byte[] byteFile = downloadService.json();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, CONTENT_DISPOSITION_FILE_NAME + "json")
				.contentType(MediaType.APPLICATION_JSON).contentLength(byteFile.length).body(byteFile);
	}

	@Cacheable("csv")
	@RequestMapping(value = "/csv", method = RequestMethod.GET)
	public ResponseEntity<?> csv() {
		byte[] byteFile = downloadService.csv();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, CONTENT_DISPOSITION_FILE_NAME + "csv");
		headers.set(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_CSV);

		return ResponseEntity.ok().headers(headers).body(byteFile);
	}

}
