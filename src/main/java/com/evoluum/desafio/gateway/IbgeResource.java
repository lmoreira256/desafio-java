package com.evoluum.desafio.gateway;

public class IbgeResource {

	private static final String BASE_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/";
	private static final String GET_ALL_MUNICIPIOS = "municipios";

	public static String getAllMunicipios() {
		String responseJson = RequestResource.request(BASE_URL + GET_ALL_MUNICIPIOS);

		return responseJson;
	}

}
