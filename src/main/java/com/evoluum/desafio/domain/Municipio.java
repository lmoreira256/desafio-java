package com.evoluum.desafio.domain;

import java.io.Serializable;

public class Municipio implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

	private MicrorRegiao microrregiao;

	public Municipio() {
	}

	public Municipio(Integer id, String nome, MicrorRegiao microrregiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.microrregiao = microrregiao;
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

	public MicrorRegiao getMicrorRegiao() {
		return microrregiao;
	}

	public void setMicrorRegiao(MicrorRegiao microrregiao) {
		this.microrregiao = microrregiao;
	}

}
