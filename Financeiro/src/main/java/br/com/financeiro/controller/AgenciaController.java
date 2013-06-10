package br.com.financeiro.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.financeiro.entidade.Agencia;
import br.com.financeiro.negocio.AgenciaService;
import br.com.financeiro.util.BancoException;

/**
 * Classe que controla as requisicoes do cliente web
 * 
 * @author Bruno.Almeida
 * 
 */
@SuppressWarnings("unused")
@Controller
@ViewScoped
@ManagedBean(name = "agenciaController")
public class AgenciaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	private AgenciaBean agenciaBean;
	private List<AgenciaBean> listaAgenciaBeans;
	@ManagedProperty(value = "#{AgenciaService}")
	private AgenciaService agenciaService;

	@PostConstruct
	public void init() {
		agenciaBean = new AgenciaBean();

		listaAgenciaBeans = new ArrayList<AgenciaBean>();
		listaAgenciaBeans.addAll(getListar());

	}

	@Autowired
	public void cadastrar() {

		try {

			Agencia agencia = new Agencia();
			agencia.setNome(agenciaBean.getNome());

			getAgenciaService().incluir(agencia);
			agenciaBean = new AgenciaBean();

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Especialidade", "Inclusão realizada.");
			FacesContext.getCurrentInstance().addMessage("Especialidade", msg);

			listaAgenciaBeans.addAll(getListar());

		} catch (Exception e) {
			String msg = ((e instanceof BancoException ? ((BancoException) e)
					.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Inclusão não realizada. Movito: ", msg);
			FacesContext.getCurrentInstance().addMessage("Especialidade",
					message);
		}

	}

	public void alterar() {
		// new PessoaDao().alterar(pessoa);
		// pessoas = new PessoaDao().listar();
		// pessoa = new Pessoa();
	}

	public void excluir() {
		try {

			getAgenciaService().excluir(agenciaBean.getIdagencia());

			agenciaBean = new AgenciaBean();
			listaAgenciaBeans.addAll(getListar());

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Especialidade", "Exclusão realizada. ");
			FacesContext.getCurrentInstance().addMessage("Especialidade", msg);

		} catch (Exception e) {
			String msg = ((e instanceof BancoException ? ((BancoException) e)
					.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Exclusão não realizada. Movito: ", msg);
			FacesContext.getCurrentInstance().addMessage("Especialidade",
					message);
		}
	}

	/**
	 * Lista as medicos cadastradas
	 * 
	 * @return
	 */
	public List<AgenciaBean> getListar() {
		try {

			List<Agencia> listaEspecialidade = getAgenciaService().listar();

			if (listaEspecialidade == null || listaEspecialidade.size() == 0) {
				return new ArrayList<AgenciaBean>();
			}

			// preeche a lista de medicos da tela
			listaAgenciaBeans = new ArrayList<AgenciaBean>();
			for (Agencia especialidade : listaEspecialidade) {
				AgenciaBean agenciaBean = new AgenciaBean();
				agenciaBean.setIdagencia(especialidade.getIdagencia());
				agenciaBean.setNome(agenciaBean.getNome());
				listaAgenciaBeans.add(agenciaBean);
			}

			return listaAgenciaBeans;
		} catch (Exception e) {
			String msg = "Listagem não realizada. Movito: "
					+ ((e instanceof BancoException ? ((BancoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return null;
		}
	}

	public AgenciaService getAgenciaService() {
		return agenciaService;
	}

	@Autowired
	public void setAgenciaService(AgenciaService especialidadeService, AgenciaService agenciaService) {
		this.agenciaService = agenciaService;
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public AgenciaBean getAgenciaBean() {
		return agenciaBean;
	}

	public void setAgenciaBean(AgenciaBean agenciaBean) {
		this.agenciaBean = agenciaBean;
	}

	public List<AgenciaBean> getListaAgenciaBean() {
		return listaAgenciaBeans;
	}

	public void setListaAgenciaBean(List<AgenciaBean> listaAgenciaBean) {
		this.listaAgenciaBeans = listaAgenciaBean;
	}

}
