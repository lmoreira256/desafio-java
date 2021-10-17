package com.evoluum.desafio.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evoluum.desafio.services.MunicipioService;

@RestController
@RequestMapping(value = "/municipios")
public class MunicipioResource {

	@Autowired
	private MunicipioService municipioService;

	@Cacheable("searchByName")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> searchByName(@RequestParam(name = "nomeCidade") String name) throws Exception {
		String id = municipioService.searchByName(name);

		return ResponseEntity.ok().body(id);
	}

}
