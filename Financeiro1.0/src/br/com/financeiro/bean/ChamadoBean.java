package br.com.financeiro.bean;
/**
 * Classe que representa o formulario web de Pessoa
 * @author Bruno.Almeida
 *
 */
public class ChamadoBean {
	
	private Integer idChamado;	
	private String descricao;	
	private String nomeChamado;
	private String tipo;
	
	
	public Integer getIdChamado() {
		return idChamado;
	}
	public void setIdChamado(Integer idChamado) {
		this.idChamado = idChamado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNomeChamado() {
		return nomeChamado;
	}
	public void setNomeChamado(String nomeChamado) {
		this.nomeChamado = nomeChamado;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
