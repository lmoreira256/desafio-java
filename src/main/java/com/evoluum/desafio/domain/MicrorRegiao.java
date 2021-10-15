package com.evoluum.desafio.domain;

import java.io.Serializable;

public class MicrorRegiao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private MesorRegiao mesorregiao;

	public MicrorRegiao() {
	}

	public MicrorRegiao(Integer id, String nome, MesorRegiao mesorregiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.mesorregiao = mesorregiao;
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

	public MesorRegiao getMesorRegiao() {
		return mesorregiao;
	}

	public void setMesorRegiao(MesorRegiao mesorregiao) {
		this.mesorregiao = mesorregiao;
	}

}
