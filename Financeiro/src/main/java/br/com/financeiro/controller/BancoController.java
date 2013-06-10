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
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import br.com.financeiro.entidade.Agencia;
import br.com.financeiro.entidade.Banco;
import br.com.financeiro.negocio.BancoService;
import br.com.financeiro.util.BancoException;

/**
 * Classe que controla as requisicoes do cliente web
 * 
 * @author Fernando Cardoso
 * 
 */
@SuppressWarnings("unused")
@Controller
@ViewScoped
@ManagedBean(name = "bancoController")
public class BancoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	private BancoBean bancoBean;
	private List<BancoBean> listaBancoBeans;
	@ManagedProperty(value = "#{BancoService}")
	private BancoService bancoService;
	private String idagencia;

	@PostConstruct
	public void init() {
		bancoBean = new BancoBean();

		listaBancoBeans = new ArrayList<BancoBean>();
		listaBancoBeans.addAll(getListar());

	}

	public void cadastrar() {

		try {

			Banco banco = new Banco();
			banco.setNome(bancoBean.getNome());

			Agencia agencia = new Agencia();
			agencia.setIdagencia(Integer.valueOf(idagencia));
			banco.setIdagencia(agencia);

			getBancoService().incluir(banco);
			bancoBean = new BancoBean();

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Medico", "Inclusão realizada com sucesso.");
			FacesContext.getCurrentInstance().addMessage("Banco", msg);

			listaBancoBeans.addAll(getListar());
			
		} catch (Exception e) {
			String msg = ((e instanceof BancoException ? ((BancoException) e)
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

			getBancoService().excluir(bancoBean.getIdbanco());

			bancoBean = new BancoBean();
			listaBancoBeans.addAll(getListar());
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Medico", "Exclusão realizada com sucesso. ");
			FacesContext.getCurrentInstance().addMessage("Banco", msg);
			
			
		} catch (Exception e) {
			String msg = ((e instanceof BancoException ? ((BancoException) e)
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
		bancoBean.setIdbanco(0);
		bancoBean.setNome("");

	}

	/**
	 * Lista as medicos cadastradas
	 * 
	 * @return
	 */
	public List<BancoBean> getListar() {

		try {
			List<Banco> listaBancos = getBancoService().listar();

			if (listaBancos == null || listaBancos.size() == 0) {
				return new ArrayList<BancoBean>();
			}

			// preeche a lista de medicos da tela
			// ArrayList<MedicoBean> listaMedicoBean = new
			// ArrayList<MedicoBean>();
			listaBancoBeans = new ArrayList<BancoBean>();
			for (Banco bank : listaBancos) {
				BancoBean banco = new BancoBean();
				banco.setIdbanco(bank.getIdbanco());
				banco.setNome(bank.getNome());
				listaBancoBeans.add(banco);
			}

			return listaBancoBeans;
		} catch (Exception e) {
			String msg = "Listagem não realizada. Movito: "
					+ ((e instanceof BancoException ? ((BancoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("Banco", message);
			e.printStackTrace();
			return null;
		}
	}

	public BancoService getBancoService() {
		return bancoService;
	}

	@Autowired
	public void setBancoService(BancoService bancoService) {
		this.bancoService = bancoService;
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public BancoBean getMedicoBean() {
		return bancoBean;
	}

	public void setbancoBean(BancoBean bancoBean) {
		this.bancoBean = bancoBean;
	}

	public List<BancoBean> getLBancoBeans() {
		return listaBancoBeans;
	}

	public void setListaBancoBean(List<BancoBean> listaBancoBean) {
		this.listaBancoBeans = listaBancoBean;
	}

	public String getIdagencia() {
		return idagencia;
	}

	public void setIdagencia(String idespecialidade) {
		this.idagencia = idespecialidade;
	}

}
