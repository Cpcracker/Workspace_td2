package br.com.financeiro.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa uma Entidade
 * 
 * @author Bruno.Almeida
 * 
 */
@Entity
@Table(name = "chamado")
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idChamado")
	private Integer idChamado;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "nomeChamado")
	private String nomeChamado;

	@Column(name = "tipo")
	private String tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa", nullable = true)
	private Pessoa pessoa;

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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idChamado == null) ? 0 : idChamado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (idChamado == null) {
			if (other.idChamado != null)
				return false;
		} else if (!idChamado.equals(other.idChamado))
			return false;
		return true;
	}

}
