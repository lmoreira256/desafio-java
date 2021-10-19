package com.evoluum.desafio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.gateway.IbgeResource;

@Service
public class EstadoService {

	@Autowired
	private IbgeResource ibgeResource;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Cacheable("getAllEstados")
	public String getAll() throws Exception {
		logger.info("Listando todos os estados");

		return ibgeResource.getAllEstados();
	}

}
