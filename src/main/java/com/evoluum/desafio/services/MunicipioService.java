package com.evoluum.desafio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.domain.Municipio;
import com.evoluum.desafio.gateway.IbgeResource;
import com.evoluum.desafio.gateway.JsonResource;
import com.evoluum.desafio.gateway.StringResource;

@Service
public class MunicipioService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Cacheable("getAllMunicipios")
	public String getAll() {
		logger.info("Listando todos os municipios");

		String estadosJson = IbgeResource.getAllEstados();

		String estados = JsonResource.covertJsonToStringList(estadosJson);

		return IbgeResource.getAllMunicipios(estados);
	}

	@Cacheable("searchByNameMunicipios")
	public String searchByName(String name) {
		logger.info("Buscando id municipio por nome");

		List<Municipio> municipioList = JsonResource.convertJsonToMunicipio(getAll());

		String id = municipioList.stream().filter(x -> StringResource.stringComparator(x.getNome(), name))
				.map(x -> x.getId().toString()).collect(Collectors.joining(", "));

		return StringResource.isNullOrEmpty(id) ? "Nenhum id com o nome: " + name + " foi encontrado!" : id;
	}

}
