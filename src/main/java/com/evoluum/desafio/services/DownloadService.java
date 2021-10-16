package com.evoluum.desafio.services;

import java.nio.charset.Charset;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.dto.FileParametersDTO;
import com.evoluum.desafio.gateway.CsvResource;
import com.evoluum.desafio.gateway.JsonResource;

@Service
public class DownloadService {

	@Autowired
	private MunicipioService municipioService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public byte[] json() {
		logger.info("Iniciando montagem do json.");

		List<FileParametersDTO> fileParametersDTOList = getFileData();

		String jsonString = JsonResource.convertListToString(fileParametersDTOList);

		return jsonString.getBytes(Charset.forName("UTF-8"));
	}

	public byte[] csv() {
		logger.info("Iniciando montagem do csv.");

		List<FileParametersDTO> fileParametersDTOList = getFileData();

		return CsvResource.montCsvFile(fileParametersDTOList);
	}

	private List<FileParametersDTO> getFileData() {
		logger.info("Iniciando montagem do conteúdo dos arquivos.");

		String municipiosJson = municipioService.getAll();

		return JsonResource.convertJsonToParameters(municipiosJson);
	}

}
