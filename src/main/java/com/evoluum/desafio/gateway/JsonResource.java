package com.evoluum.desafio.gateway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.evoluum.desafio.domain.Municipio;
import com.evoluum.desafio.domain.Uf;
import com.evoluum.desafio.dto.FileParametersDTO;
import com.evoluum.desafio.exceptions.ErrorMessageException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResource {

	public static String convertListToString(List<?> list) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			throw new ErrorMessageException("Erro ao converter a lista para JSON.");
		}
	}

	public static List<FileParametersDTO> convertJsonToParameters(String json) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

		try {
			List<FileParametersDTO> fileParametersDTOList = new ArrayList<FileParametersDTO>();

			JsonNode rootNode = objectMapper.readTree(json);

			rootNode.forEach(municipioNode -> {
				JsonNode microrRegiaoNode = municipioNode.path("microrregiao");
				JsonNode mesorRegiaoNode = microrRegiaoNode.path("mesorregiao");
				JsonNode ufNode = mesorRegiaoNode.path("UF");
				JsonNode regiaoNode = ufNode.path("regiao");

				Integer idEstado = ufNode.path("id").asInt();
				String siglaEstado = ufNode.path("sigla").asText();
				String regiaoNome = regiaoNode.path("nome").asText();
				String nomeCidade = municipioNode.path("nome").asText();
				String nomeMesorregiao = mesorRegiaoNode.path("nome").asText();
				String nomeFormatado = nomeCidade + "/" + ufNode.path("nome").asText();

				fileParametersDTOList.add(new FileParametersDTO(idEstado, siglaEstado, regiaoNome, nomeCidade,
						nomeMesorregiao, nomeFormatado));
			});

			return fileParametersDTOList;
		} catch (JsonProcessingException e) {
			throw new ErrorMessageException("Erro ao montar os parâmetros dos arquivos.");
		}
	}

	public static String covertJsonToStringList(String json) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

		try {
			Uf[] ufArray = objectMapper.readValue(json, Uf[].class);

			return Arrays.asList(ufArray).stream().map(x -> x.getId().toString()).collect(Collectors.joining("|"));
		} catch (JsonProcessingException e) {
			throw new ErrorMessageException("Erro ao converter o JSON para Lista.");
		}

	}

	public static List<Municipio> convertJsonToMunicipio(String json) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);

		try {
			Municipio[] municipioArray = objectMapper.readValue(json, Municipio[].class);

			return Arrays.asList(municipioArray);
		} catch (JsonProcessingException e) {
			throw new ErrorMessageException("Erro ao converter o JSON para os Municipios.");
		}
	}

}
