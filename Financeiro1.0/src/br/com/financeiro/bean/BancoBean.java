package br.com.financeiro.bean;

/**
 * Classe que representa o formulario web de Pessoa
 * 
 * @author Bruno.Almeida
 * 
 */
public class BancoBean {

	private Integer idBanco;
	private String descricao;
	private String nomeBanco;
	private String agencia;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

}
