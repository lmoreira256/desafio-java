package com.evoluum.desafio.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evoluum.desafio.services.UfService;

@RestController
@RequestMapping(value = "/ufs")
public class UfResource {

	@Autowired
	private UfService ufService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista() {
		return ResponseEntity.ok(ufService.lista());
	}

}
