package br.com.medico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import br.com.medico.entidade.Especialidade;
import br.com.medico.entidade.Medico;
import br.com.medico.negocio.MedicoService;
import br.com.medico.util.AgendaException;

/**
 * Classe que controla as requisicoes do cliente web
 * 
 * @author Fernando Cardoso
 * 
 */
@Controller
@ViewScoped
@ManagedBean(name = "medicoController")
public class MedicoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	private MedicoBean medicoBean;
	private List<MedicoBean> listaMedicoBean;
	@ManagedProperty(value = "#{MedicoService}")
	private MedicoService medicoService;
	private String idespecialidade;

	@PostConstruct
	public void init() {
		medicoBean = new MedicoBean();

		listaMedicoBean = new ArrayList<MedicoBean>();
		listaMedicoBean.addAll(getListar());

	}

	public void cadastrar() {

		try {

			Medico medico = new Medico();
			medico.setNome(medicoBean.getNome());

			Especialidade especialidade = new Especialidade();
			especialidade.setIdespecialidade(Integer.valueOf(idespecialidade));
			medico.setIdespecialidade(especialidade);

			getMedicoService().incluir(medico);
			medicoBean = new MedicoBean();

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Medico", "Inclusão realizada.");
			FacesContext.getCurrentInstance().addMessage("Medico", msg);

			listaMedicoBean.addAll(getListar());
			
		} catch (Exception e) {
			String msg = ((e instanceof AgendaException ? ((AgendaException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Inclusão não realizada. Movito: ", msg);
			FacesContext.getCurrentInstance().addMessage("Medico", message);  
		}

	}

	public void alterar(ActionEvent actionEvent) {
		// new PessoaDao().alterar(pessoa);
		// pessoas = new PessoaDao().listar();
		// pessoa = new Pessoa();
	}

	public void excluir() {
		try{

			getMedicoService().excluir(medicoBean.getIdmedico());

			medicoBean = new MedicoBean();
			listaMedicoBean.addAll(getListar());
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Medico", "Exclusão realizada. ");
			FacesContext.getCurrentInstance().addMessage("Medico", msg);
			
			
		} catch (Exception e) {
			String msg = ((e instanceof AgendaException ? ((AgendaException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exclusão não realizada. Movito: ", msg);
			FacesContext.getCurrentInstance().addMessage("Medico", message);  
		}
	}

	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		medicoBean.setIdmedico(0);
		medicoBean.setNome("");

	}

	/**
	 * Lista as medicos cadastradas
	 * 
	 * @return
	 */
	public List<MedicoBean> getListar() {

		try {
			List<Medico> listaMedico = getMedicoService().listar();

			if (listaMedico == null || listaMedico.size() == 0) {
				return new ArrayList<MedicoBean>();
			}

			// preeche a lista de medicos da tela
			// ArrayList<MedicoBean> listaMedicoBean = new
			// ArrayList<MedicoBean>();
			listaMedicoBean = new ArrayList<MedicoBean>();
			for (Medico med : listaMedico) {
				MedicoBean medico = new MedicoBean();
				medico.setIdmedico(med.getIdmedico());
				medico.setNome(med.getNome());
				listaMedicoBean.add(medico);
			}

			return listaMedicoBean;
		} catch (Exception e) {
			String msg = "Listagem não realizada. Movito: "
					+ ((e instanceof AgendaException ? ((AgendaException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("Medico", message);
			e.printStackTrace();
			return null;
		}
	}

	public MedicoService getMedicoService() {
		return medicoService;
	}

	@Autowired
	public void setMedicoService(MedicoService medicoService) {
		this.medicoService = medicoService;
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public MedicoBean getMedicoBean() {
		return medicoBean;
	}

	public void setMedicoBean(MedicoBean medicoBean) {
		this.medicoBean = medicoBean;
	}

	public List<MedicoBean> getListaMedicoBean() {
		return listaMedicoBean;
	}

	public void setListaMedicoBean(List<MedicoBean> listaMedicoBean) {
		this.listaMedicoBean = listaMedicoBean;
	}

	public String getIdespecialidade() {
		return idespecialidade;
	}

	public void setIdespecialidade(String idespecialidade) {
		this.idespecialidade = idespecialidade;
	}

}
