package com.evoluum.desafio.gateway;

import org.springframework.cache.annotation.Cacheable;

public class IbgeResource {

	private static final String BASE_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/";
	private static final String GET_MUNICIPIOS = "estados/%1$2s/municipios";
	private static final String GET_ESTADOS = "estados";

	@Cacheable("getAllMunicipios")
	public static String getAllMunicipios(String estados) {
		String responseJson = RequestResource.request(BASE_URL + String.format(GET_MUNICIPIOS, estados));

		return responseJson;
	}

	@Cacheable("getAllEstados")
	public static String getAllEstados() {
		String responseJson = RequestResource.request(BASE_URL + GET_ESTADOS);

		return responseJson;
	}

}
