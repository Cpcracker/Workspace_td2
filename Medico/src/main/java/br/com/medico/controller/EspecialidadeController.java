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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.medico.entidade.Especialidade;
import br.com.medico.negocio.EspecialidadeService;
import br.com.medico.util.AgendaException;

/**
 * Classe que controla as requisicoes do cliente web
 * 
 * @author Fernando Cardoso
 * 
 */
@Controller
@ViewScoped
@ManagedBean(name = "especialidadeController")
public class EspecialidadeController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    
	private EspecialidadeBean especialidadeBean;
	private List<EspecialidadeBean> listaEspecialidadeBean;
	@ManagedProperty(value="#{EspecialidadeService}")
	private EspecialidadeService especialidadeService;

    @PostConstruct
    public void init(){	
		especialidadeBean = new EspecialidadeBean();
    	
    	listaEspecialidadeBean = new ArrayList<EspecialidadeBean>();
    	listaEspecialidadeBean.addAll(getListar());
    	
    }
	
	public void cadastrar() {

		try {

			Especialidade especialidade = new Especialidade();
			especialidade.setNome(especialidadeBean.getNome());

			getEspecialidadeService().incluir(especialidade);
			especialidadeBean = new EspecialidadeBean();

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Especialidade", "Inclusão realizada.");
			FacesContext.getCurrentInstance().addMessage("Especialidade", msg);

			listaEspecialidadeBean.addAll(getListar());
			
		} catch (Exception e) {
			String msg = ((e instanceof AgendaException ? ((AgendaException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Inclusão não realizada. Movito: ", msg);
			FacesContext.getCurrentInstance().addMessage("Especialidade", message);  
		}

	}

	public void alterar() {
		// new PessoaDao().alterar(pessoa);
		// pessoas = new PessoaDao().listar();
		// pessoa = new Pessoa();
	}

	public void excluir() {
		try{

			getEspecialidadeService().excluir(especialidadeBean.getIdespecialidade());

			especialidadeBean = new EspecialidadeBean();
			listaEspecialidadeBean.addAll(getListar());
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Especialidade", "Exclusão realizada. ");
			FacesContext.getCurrentInstance().addMessage("Especialidade", msg);
			
			
		} catch (Exception e) {
			String msg = ((e instanceof AgendaException ? ((AgendaException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exclusão não realizada. Movito: ", msg);
			FacesContext.getCurrentInstance().addMessage("Especialidade", message);  
		}
	}

	/**
	 * Lista as medicos cadastradas
	 * 
	 * @return
	 */
	public List<EspecialidadeBean> getListar() {
		try {

			List<Especialidade> listaEspecialidade = getEspecialidadeService().listar();

			if (listaEspecialidade == null || listaEspecialidade.size() == 0) {
				return new ArrayList<EspecialidadeBean>();			
			}
			
			// preeche a lista de medicos da tela
			listaEspecialidadeBean = new ArrayList<EspecialidadeBean>();
			for (Especialidade especialidade : listaEspecialidade) {
				EspecialidadeBean especialidadeBean = new EspecialidadeBean();
				especialidadeBean.setIdespecialidade(especialidade.getIdespecialidade());
				especialidadeBean.setNome(especialidade.getNome());
				listaEspecialidadeBean.add(especialidadeBean);
			}

			return listaEspecialidadeBean;
		} catch (Exception e) {
			String msg = "Listagem não realizada. Movito: "
					+ ((e instanceof AgendaException ? ((AgendaException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return null;
		}
	}


	public EspecialidadeService getEspecialidadeService() {
		return especialidadeService;
	}

	@Autowired
	public void setEspecialidadeService(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}


	public EspecialidadeBean getEspecialidadeBean() {
		return especialidadeBean;
	}

	public void setEspecialidadeBean(EspecialidadeBean especialidadeBean) {
		this.especialidadeBean = especialidadeBean;
	}

	public List<EspecialidadeBean> getListaEspecialidadeBean() {
		return listaEspecialidadeBean;
	}

	public void setListaEspecialidadeBean(List<EspecialidadeBean> listaEspecialidadeBean) {
		this.listaEspecialidadeBean = listaEspecialidadeBean;
	}


}
