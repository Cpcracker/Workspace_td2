package br.com.financeiro.controller;

import java.util.Date;

import br.com.financeiro.entidade.Agencia;

public class BancoBean {

	private Integer idbanco;
	private String nome;
	private Date datacadastro;
	private Float ativo;
	private Agencia idaAgencia;

	public Integer getIdbanco() {
		return idbanco;
	}

	public void setIdbanco(Integer idbanco) {
		this.idbanco = idbanco;
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

	public Agencia getIdaAgencia() {
		return idaAgencia;
	}

	public void setIdaAgencia(Agencia idaAgencia) {
		this.idaAgencia = idaAgencia;
	}

}
