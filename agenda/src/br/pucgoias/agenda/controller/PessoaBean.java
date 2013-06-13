package br.pucgoias.agenda.controller;

import java.util.List;

/**
 * Classe que representa o formulario web de Pessoa
 * @author Gilcimar
 *
 */
public class PessoaBean {
	
	private Integer idPessoa;
	private String dsNome;
	private Integer vlIdade;
	private List<TelefoneBean> listaTelefone;
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getDsNome() {
		return dsNome;
	}
	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}
	public List<TelefoneBean> getListaTelefone() {
		return listaTelefone;
	}
	public void setListaTelefone(List<TelefoneBean> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}
	public void setVlIdade(Integer vlIdade) {
		this.vlIdade = vlIdade;
	}
	public Integer getVlIdade() {
		return vlIdade;
	}
	
}



