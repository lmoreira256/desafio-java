package com.evoluum.desafio.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evoluum.desafio.domain.Municipio;
import com.evoluum.desafio.dto.FileParametersDTO;
import com.evoluum.desafio.services.DownloadService;

public class DownloadServiceImpl implements DownloadService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public byte[] json() {
		logger.info("Iniciando montagem do json.");

		return null;
	}

	@Override
	public byte[] csv() {
		logger.info("Iniciando montagem do csv.");

		return null;
	}

	private List<FileParametersDTO> getFileData() {
		logger.info("Iniciando montagem do conteúdo dos arquivos.");

		List<Municipio> municipioList;

		return null;
	}

}
