package br.com.financeiro.entidade;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Classe que representa uma Entidade
 * @author Bruno.Almeida
 *
 */
@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPessoa")
	private Integer idPessoa;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="profissao")
	private String profissao;	
	
	@Column(name="senha")
	private String senha;
	
	@OneToMany(mappedBy="pessoa", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Banco> banco;
	
	
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
	
	public List<Banco> getBanco() {
		return banco;
	}
	public void setBancos(List<Banco> bancos) {
		this.banco = bancos;
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
	
}
