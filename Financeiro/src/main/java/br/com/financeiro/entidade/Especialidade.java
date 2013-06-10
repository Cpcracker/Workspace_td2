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
@Table(name="especialidade")
public class Especialidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3839032971082756080L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idespecialidade")
	private Integer idespecialidade;

	@Column(name = "nome")
	private String nome;

	@Column(name = "datacadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datacadastro;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "idespecialidade")
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idespecialidade != null ? idespecialidade.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Especialidade)) {
			return false;
		}
		Especialidade other = (Especialidade) object;
		if ((this.idespecialidade == null && other.idespecialidade != null)
				|| (this.idespecialidade != null && !this.idespecialidade
						.equals(other.idespecialidade))) {
			return false;
		}
		return true;
	}

}
