package com.alunos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Alunos")

public class Alunos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	private String cpf;
	
	@NotNull
	@NotBlank
	private String rg;
	
	@NotNull
	@NotBlank
	private String endereco;

	public Long getId() {
		return idAluno;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setId(Long id) {
		this.idAluno = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}