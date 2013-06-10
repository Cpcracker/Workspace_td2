package br.com.medico.controller;

import java.util.Date;

import br.com.medico.entidade.Especialidade;

public class MedicoBean {

	private Integer idmedico;
	private String nome;
	private Date datacadastro;
	private Float ativo;
	private Especialidade idespecialidade;

	public Integer getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Float getAtivo() {
		return ativo;
	}

	public void setAtivo(Float ativo) {
		this.ativo = ativo;
	}

	public Especialidade getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(Especialidade idespecialidade) {
		this.idespecialidade = idespecialidade;
	}

}
