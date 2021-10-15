package com.evoluum.desafio.domain;

import java.io.Serializable;

public class MesorRegiao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private Uf UF;

	public MesorRegiao() {
	}

	public MesorRegiao(Integer id, String nome, Uf UF) {
		super();
		this.id = id;
		this.nome = nome;
		this.UF = UF;
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

	public Uf getUf() {
		return UF;
	}

	public void setUf(Uf UF) {
		this.UF = UF;
	}

}
