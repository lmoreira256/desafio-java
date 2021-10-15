package com.evoluum.desafio.services;

import java.text.Normalizer;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.evoluum.desafio.domain.Municipio;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class MunicipioService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Municipio> listar() {
		logger.info("Executando o método listar");

		final String uri = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";

		RestTemplate restTemplate = new RestTemplate();
		// Municipio[] result = restTemplate.getForObject(uri, Municipio[].class);
		String result2 = restTemplate.getForObject(uri, String.class);

		Gson gson = new Gson();
		List<Municipio> teste = gson.fromJson(result2, new TypeToken<List<Municipio>>(){}.getType());

		return teste;
	}

	@Cacheable("municipioBuscaPorNome")
	public List<Municipio> buscarPorNome(String nome) {
		logger.info("Executando o método buscarPorNome para o nome: " + nome);

		List<Municipio> listaMunicipio = listar();

		return listaMunicipio.stream().filter(x -> unaccent(x.getNome()).replaceAll(" ", "")
				.equalsIgnoreCase(unaccent(nome.trim()).replaceAll(" ", ""))).toList();
	}

	private static String unaccent(String src) {
		return Normalizer.normalize(src, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}
