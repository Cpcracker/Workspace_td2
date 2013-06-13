package br.com.chamado.bean;

import java.util.Date;
import java.util.List;

/**
 * Classe que representa o formulario web de Pessoa
 * 
 * @author Bruno.Almeida
 * 
 */
public class PessoaBean {

	private Integer idPessoa;
	private String nome;
	private String profissao;	
	private String senha;
	private String confirmaSenha;
	private List<ChamadoBean> chamados;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public List<ChamadoBean> getChamados() {
		return chamados;
	}

	public void setChamados(List<ChamadoBean> chamados) {
		this.chamados = chamados;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the confirmaSenha
	 */
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	/**
	 * @param confirmaSenha the confirmaSenha to set
	 */
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	
	

}
