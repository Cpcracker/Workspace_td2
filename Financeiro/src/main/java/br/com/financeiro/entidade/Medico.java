package br.com.financeiro.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="medico")
public class Medico implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2935272184619380958L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    private Integer idmedico;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "datacadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadastro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ativo")
    private Float ativo;
    
    @JoinColumn(name = "idespecialidade", referencedColumnName = "idespecialidade")
    @ManyToOne(fetch=FetchType.LAZY)
    private Especialidade idespecialidade;

	public Integer getIdmedico() {
		return idmedico;
	}

	public void setIdmedico(Integer idmedico) {
		this.idmedico = idmedico;
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

	public Especialidade getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(Especialidade idespecialidade) {
		this.idespecialidade = idespecialidade;
	}
	
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedico != null ? idmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idmedico == null && other.idmedico != null) || (this.idmedico != null && !this.idmedico.equals(other.idmedico))) {
            return false;
        }
        return true;
    }
	
}
