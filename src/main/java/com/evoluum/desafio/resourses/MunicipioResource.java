package com.evoluum.desafio.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evoluum.desafio.services.MunicipioService;

@RestController
@RequestMapping(value = "/municipios")
public class MunicipioResource {

	@Autowired
	private MunicipioService municipioService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(municipioService.listar());
	}

	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(municipioService.buscarPorNome(nome));
	}

}
