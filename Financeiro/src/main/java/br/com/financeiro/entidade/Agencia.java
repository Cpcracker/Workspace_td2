package br.com.financeiro.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "agencia")
public class Agencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3839032971082756080L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idagencia")
	private Integer idagencia;

	@Column(name = "nome")
	private String nome;

	@Column(name = "datacadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datacadastro;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idagencia")
	private List<Banco> listaagencia;

	public Integer getIdagencia() {
		return idagencia;
	}

	public void setIdagencia(Integer idagencia) {
		this.idagencia = idagencia;
	}

	public List<Banco> getListaagencia() {
		return listaagencia;
	}

	public void setListaagencia(List<Banco> listaagencia) {
		this.listaagencia = listaagencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public List<Banco> getListaMedico() {
		return listaagencia;
	}

	public void setListaMedico(List<Banco> listaMedico) {
		this.listaagencia = listaMedico;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idagencia != null ? idagencia.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Agencia)) {
			return false;
		}
		Agencia other = (Agencia) object;
		if ((this.idagencia == null && other.idagencia != null)
				|| (this.idagencia != null && !this.idagencia
						.equals(other.idagencia))) {
			return false;
		}
		return true;
	}

}
