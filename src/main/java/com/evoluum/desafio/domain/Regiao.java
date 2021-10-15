package com.evoluum.desafio.domain;

import java.io.Serializable;

public class Regiao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String sigla;

	private String nome;

	public Regiao() {
	}

	public Regiao(Integer id, String nome, String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
