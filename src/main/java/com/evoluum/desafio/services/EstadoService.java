package com.evoluum.desafio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.gateway.IbgeResource;

@Service
public class EstadoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String getAll() throws Exception {
		logger.info("Listando todos os estados");

		return IbgeResource.getAllEstados();
	}

}
