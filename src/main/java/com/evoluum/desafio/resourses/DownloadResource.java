package com.evoluum.desafio.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public interface DownloadResource {

	@GetMapping("/json")
	public abstract ResponseEntity<?> json();

	@GetMapping("/csv")
	public abstract ResponseEntity<?> csv();

}
