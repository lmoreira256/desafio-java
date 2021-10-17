package com.evoluum.desafio.gateway;

import org.springframework.cache.annotation.Cacheable;

import com.evoluum.desafio.dto.ErrorMessageDTO;

public class IbgeResource {

	private static final String BASE_URL = "https://servicodados..gov.br/api/v1/localidades/";
	private static final String GET_MUNICIPIOS = "estados/%1$2s/municipios";
	private static final String GET_ESTADOS = "estados";

	@Cacheable("getAllMunicipios")
	public static String getAllMunicipios(String estados) throws Exception {
		try {
			String responseJson = RequestResource.request(BASE_URL + String.format(GET_MUNICIPIOS, estados));

			if (StringResource.isNullOrEmpty(responseJson)) {
				throw new Exception(
						"Erro ao chamar o endereço: " + BASE_URL + String.format(GET_MUNICIPIOS, estados) + ".");
			}

			return responseJson;
		} catch (Exception e) {
			throw new Exception(
					"Erro ao chamar o endereço: " + BASE_URL + String.format(GET_MUNICIPIOS, estados) + ".");
		}
	}

	@Cacheable("getAllEstados")
	public static String getAllEstados() throws Exception {
		try {
			String responseJson = RequestResource.request(BASE_URL + GET_ESTADOS);

			if (StringResource.isNullOrEmpty(responseJson)) {
				throw new ErrorMessageDTO("Erro ao chamar o endereço: " + BASE_URL + GET_ESTADOS + ".");
			}

			return responseJson;
		} catch (Exception e) {
			throw new Exception("Erro ao chamar o endereço: " + BASE_URL + GET_ESTADOS + ".");
		}
	}

}
