package com.evoluum.desafio.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.evoluum.desafio.domain.Uf;

@Service
public class UfService {

	@Cacheable("ufLista")
	public List<Uf> lista() {

		final String uri = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";

		RestTemplate restTemplate = new RestTemplate();
		Uf[] result = restTemplate.getForObject(uri, Uf[].class);

		return Arrays.asList(result);
	}

}
