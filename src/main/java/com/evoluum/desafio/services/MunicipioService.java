package com.evoluum.desafio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.domain.Municipio;
import com.evoluum.desafio.exceptions.ErrorMessageException;
import com.evoluum.desafio.gateway.IbgeResource;
import com.evoluum.desafio.gateway.JsonResource;
import com.evoluum.desafio.gateway.StringResource;

@Service
public class MunicipioService {

	@Autowired
	private IbgeResource ibgeResource;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Cacheable("getAllMunicipios")
	public String getAll() throws Exception {
		logger.info("Listando todos os municipios");

		String estadosJson = ibgeResource.getAllEstados();

		String estados = JsonResource.covertJsonToStringList(estadosJson);

		return ibgeResource.getAllMunicipios(estados);
	}

	@Cacheable("searchByNameMunicipios")
	public String searchByName(String name) throws Exception {
		logger.info("Buscando id municipio por nome");

		if (StringResource.isNullOrEmpty(name)) {
			throw new ErrorMessageException("O parâmetro de busca está inválido.");
		}

		List<Municipio> municipioList = JsonResource.convertJsonToMunicipio(getAll());

		String id = municipioList.stream().filter(x -> StringResource.stringComparator(x.getNome(), name))
				.map(x -> x.getId().toString()).collect(Collectors.joining(", "));

		if (StringResource.isNullOrEmpty(id)) {
			throw new ErrorMessageException("Nenhum id com o nome: " + name + " foi encontrado.");
		}

		return id;
	}

}
