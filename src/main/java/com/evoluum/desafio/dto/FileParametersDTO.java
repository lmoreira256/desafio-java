package com.evoluum.desafio.dto;

import java.io.Serializable;

public class FileParametersDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idEstado;

	private String siglaEstado;

	private String regiaoNome;

	private String nomeCidade;

	private String nomeMesorregiao;

	private String nomeFormatado;

	public FileParametersDTO() {
	}

	public FileParametersDTO(Integer idEstado, String siglaEstado, String regiaoNome, String nomeCidade,
			String nomeMesorregiao, String nomeFormatado) {
		super();
		this.idEstado = idEstado;
		this.siglaEstado = siglaEstado;
		this.regiaoNome = regiaoNome;
		this.nomeCidade = nomeCidade;
		this.nomeMesorregiao = nomeMesorregiao;
		this.nomeFormatado = nomeFormatado;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getRegiaoNome() {
		return regiaoNome;
	}

	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNomeMesorregiao() {
		return nomeMesorregiao;
	}

	public void setNomeMesorregiao(String nomeMesorregiao) {
		this.nomeMesorregiao = nomeMesorregiao;
	}

	public String getNomeFormatado() {
		return nomeFormatado;
	}

	public void setNomeFormatado(String nomeFormatado) {
		this.nomeFormatado = nomeFormatado;
	}

}
