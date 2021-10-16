package com.evoluum.desafio.gateway;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import com.evoluum.desafio.dto.FileParametersDTO;

public class CsvResource {

	public static byte[] montCsvFile(List<FileParametersDTO> fileParametersDTOList) {
		List<List<String>> conteudo = new ArrayList<>();

		fileParametersDTOList.forEach(x -> {
			conteudo.add(Arrays.asList(x.getIdEstado().toString(), x.getSiglaEstado(), x.getRegiaoNome(),
					x.getNomeCidade(), x.getNomeMesorregiao(), x.getNomeFormatado()));
		});

		String[] cabecalho = { "idEstado", "siglaEstado", "regiaoNome", "nomeCidade", "nomeMesorregiao",
				"nomeFormatado" };

		StringBuilder csv = new StringBuilder();
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(byteArray, StandardCharsets.UTF_8);

		StringJoiner result = new StringJoiner(",");
		Arrays.asList(cabecalho).forEach(result::add);
		csv.append(result).append("\n");

		StringBuilder result1 = new StringBuilder();

		for (List<String> line : conteudo) {
			StringJoiner newLine = new StringJoiner(",");
			line.forEach(newLine::add);

			result1.append(newLine).append("\n");
		}

		csv.append(result1);

		byte[] arquivoCsb = null;

		try {
			writer.write(csv.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println("MOIO");
		}

		arquivoCsb = byteArray.toByteArray();

		return arquivoCsb;
	}

}
