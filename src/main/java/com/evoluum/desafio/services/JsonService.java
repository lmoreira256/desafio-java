package com.evoluum.desafio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evoluum.desafio.domain.MesorRegiao;
import com.evoluum.desafio.domain.MicrorRegiao;
import com.evoluum.desafio.domain.Municipio;
import com.evoluum.desafio.domain.Regiao;
import com.evoluum.desafio.domain.Uf;
import com.evoluum.desafio.dto.FileParametersDTO;
import com.google.gson.Gson;

@Service
public class JsonService {

	@Autowired
	private MunicipioService municipioService;

	public byte[] generateBytes() {
		List<FileParametersDTO> data = getDataFile();

		String jsonString = generateJson(data);

		return jsonString.getBytes();
	}

	private List<FileParametersDTO> getDataFile() {
		List<Municipio> municipioList = municipioService.listar();

		List<FileParametersDTO> retorno = new ArrayList<FileParametersDTO>();

		municipioList.forEach(x -> {
			FileParametersDTO fileParametersDTO = new FileParametersDTO();

			MicrorRegiao microrRegiao = x.getMicrorRegiao();
			MesorRegiao mesorRegiao = microrRegiao.getMesorRegiao();
			Uf uf = mesorRegiao.getUf();
			Regiao regiao = uf.getRegiao();

			fileParametersDTO.setIdEstado(uf.getId());
			fileParametersDTO.setNomeFormatado(x.getNome() + "/" + uf.getNome());
			fileParametersDTO.setNomeMesorregiao(mesorRegiao.getNome());
			fileParametersDTO.setRegiaoNome(regiao.getNome());
			fileParametersDTO.setSiglaEstado(uf.getSigla());
			fileParametersDTO.setNomeCidade(x.getNome());

			retorno.add(fileParametersDTO);
		});

		return retorno;
	}

	private String generateJson(List<FileParametersDTO> data) {
		Gson gson = new Gson();
		return gson.toJson(data);
	}

}
