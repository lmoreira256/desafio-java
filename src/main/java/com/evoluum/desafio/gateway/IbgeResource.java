package com.evoluum.desafio.gateway;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.exceptions.ErrorMessageException;

@Service
public class IbgeResource {

	private static final String GET_MUNICIPIOS = "estados/%1$2s/municipios";
	private static final String GET_ESTADOS = "estados";
	private static final String BASE_URL_IBGE = "https://servicodados.ibge.gov.br/api/v1/localidades/";

	@Cacheable("getAllMunicipios")
	public String getAllMunicipios(String estados) throws Exception {
		try {
			String responseJson = RequestResource.request(BASE_URL_IBGE + String.format(GET_MUNICIPIOS, estados));

			if (StringResource.isNullOrEmpty(responseJson)) {
				throw new ErrorMessageException(
						"Erro ao chamar o endereço: " + BASE_URL_IBGE + String.format(GET_MUNICIPIOS, estados) + ".");
			}

			return responseJson;
		} catch (Exception e) {
			throw new ErrorMessageException(
					"Erro ao chamar o endereço: " + BASE_URL_IBGE + String.format(GET_MUNICIPIOS, estados) + ".");
		}
	}

	@Cacheable("getAllEstados")
	public String getAllEstados() throws Exception {
		try {
			String responseJson = RequestResource.request(BASE_URL_IBGE + GET_ESTADOS);

			if (StringResource.isNullOrEmpty(responseJson)) {
				throw new ErrorMessageException("Erro ao chamar o endereço: " + BASE_URL_IBGE + GET_ESTADOS + ".");
			}

			return responseJson;
		} catch (Exception e) {
			throw new ErrorMessageException("Erro ao chamar o endereço: " + BASE_URL_IBGE + GET_ESTADOS + ".");
		}
	}

}
