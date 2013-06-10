package br.com.financeiro.controller;

import java.util.Date;
import java.util.List;

import br.com.financeiro.entidade.Banco;

public class AgenciaBean {

	private Integer idagencia;
	private String nome;
	private Date datacadastro;
	private List<Banco> listaBanco;

	public Integer getIdagencia() {
		return idagencia;
	}

	public void setIdagencia(Integer idagencia) {
		this.idagencia = idagencia;
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

	public List<Banco> getListaBancos() {
		return listaBanco;
	}

	public void setListaBanco(List<Banco> listaBancos) {
		this.listaBanco = listaBancos;
	}

}
