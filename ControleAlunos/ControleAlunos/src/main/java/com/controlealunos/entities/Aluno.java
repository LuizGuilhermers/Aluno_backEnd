package com.controlealunos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idAluno;
	
	@Column (name ="nome")
	private String nome;
	
	@Column(name ="cpf")
	private String cpf;
	
	@Column(name ="rg")
	private String rg;
	
	@Column(name ="endereco")
	private String endereco;


	public Long getId() {
		return idAluno;
	}

	public void setId(Long idAluno) {
		this.idAluno = idAluno;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getEnd() {
		return endereco;
	}

	public void setProduto(String endereco) {
		this.endereco = endereco;
	}
}
	

	
	