package br.com.medico.controller;

import java.util.Date;
import java.util.List;

import br.com.medico.entidade.Medico;

public class EspecialidadeBean {

	private Integer idespecialidade;
	private String nome;
	private Date datacadastro;
	private List<Medico> listaMedico;

	public Integer getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(Integer idespecialidade) {
		this.idespecialidade = idespecialidade;
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

	public List<Medico> getListaMedico() {
		return listaMedico;
	}

	public void setListaMedico(List<Medico> listaMedico) {
		this.listaMedico = listaMedico;
	}

}
