package com.evoluum.desafio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.gateway.IbgeResource;

@Service
public class MunicipioService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String getAll() {
		logger.info("Listando todos os municipios");

		return IbgeResource.getAllMunicipios();
	}

}
