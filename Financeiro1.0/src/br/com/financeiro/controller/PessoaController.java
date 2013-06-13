package br.com.financeiro.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.financeiro.bean.ChamadoBean;
import br.com.financeiro.bean.PessoaBean;
import br.com.financeiro.entidade.Chamado;
import br.com.financeiro.entidade.Pessoa;
import br.com.financeiro.negocio.PessoaService;
import br.com.financeiro.util.ChamadoException;

/**
 * Classe que controla as requisicoes do cliente web
 * 
 * @author Bruno.Almeida
 * 
 */
@Controller
@Scope("request")
public class PessoaController {

	private PessoaBean pessoaBean;
	private List<PessoaBean> listaPessoaBean;
	private PessoaService pessoaService;
	private ChamadoBean chamadoBean;

	public String includ() {
		try {

			Pessoa pessoa = new Pessoa();

			// preenche os dados da tela no objeto persistente
			pessoa.setIdPessoa(pessoaBean.getIdPessoa());
			pessoa.setNome(pessoaBean.getNome());
			pessoa.setProfissao(pessoaBean.getProfissao());

			getPessoaService().incluir(pessoa);
			return "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Inclusão não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * compara usuario e senha.
	 */
	public String senha() {
		try {
			List<Pessoa> listaPessoa = getPessoaService().listar();
			Pessoa pessoa = new Pessoa();

			// preenche os dados da tela no objeto persistente
			pessoa.setIdPessoa(pessoaBean.getIdPessoa());
			pessoa.setNome(pessoaBean.getNome());
			pessoa.setProfissao(pessoaBean.getProfissao());
			pessoa.setSenha(pessoaBean.getSenha());

			// preeche a lista de pessoas da tela
			listaPessoaBean = new ArrayList<PessoaBean>();
			for (Pessoa pessoa1 : listaPessoa) {
				PessoaBean pessoaBean = new PessoaBean();
				pessoaBean.setIdPessoa(pessoa1.getIdPessoa());
				pessoaBean.setNome(pessoa1.getNome());
				pessoaBean.setProfissao(pessoa1.getProfissao());
				pessoaBean.setSenha(pessoa1.getSenha());

				if (pessoaBean.getNome().equals(pessoa.getNome())
						&& pessoaBean.getSenha().equals(pessoa.getSenha())) {
					FacesMessage msg = new FacesMessage("Senha Correta");
					getFacesContext().addMessage(null, msg);
					return "principal";
				} else {
					FacesMessage msg = new FacesMessage(
							"Usuario ou Senha Incorretos");
					getFacesContext().addMessage("index", msg);
					return "index";
				}
			}
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Listagem não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage(null, message);
			return "falha";
		}
	}

	/**
	 * Construtor da classe de pessoa
	 */
	@SuppressWarnings("unchecked")
	public PessoaController() {
		pessoaBean = new PessoaBean();
		if (this.getFacesContext().getExternalContext().getSessionMap()
				.get("chamados") != null) {
			pessoaBean.setChamados((List<ChamadoBean>) getSession("chamados"));
		} else {
			pessoaBean.setChamados(new ArrayList<ChamadoBean>());
		}
		chamadoBean = new ChamadoBean();
	}

	/**
	 * Inclui uma pessoa na base de dados
	 * 
	 * @return
	 */
	public String incluir() {
		try {

			Pessoa pessoa = new Pessoa();
			

			// preenche os dados da tela no objeto persistente
			pessoa.setIdPessoa(pessoaBean.getIdPessoa());
			pessoa.setNome(pessoaBean.getNome());
			pessoa.setProfissao(pessoaBean.getProfissao());
			pessoa.setSenha(pessoaBean.getSenha());
			
			
			

			// preeche a lista de Chamados da tela na lista de Chamados
			// persistente
			pessoa.setChamados(new ArrayList<Chamado>());
			for (ChamadoBean chamadoBean : pessoaBean.getChamados()) {
				Chamado chamado = new Chamado();
				chamado.setTipo(chamadoBean.getTipo());
				chamado.setNomeChamado(chamadoBean.getNomeChamado());
				chamado.setDescricao(chamadoBean.getDescricao());
				chamado.setPessoa(pessoa);
				pessoa.getChamados().add(chamado);
				
			}
			
			getPessoaService().incluir(pessoa);
			pessoaBean = new PessoaBean();
		
			return "sucesso";
		} catch (Exception e) {
			String msg = "Inclusão não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Lista as pessoas cadastradas
	 * 
	 * @return
	 */
	public String listar() {
		try {

			List<Pessoa> listaPessoa = getPessoaService().listar();

			if (listaPessoa == null || listaPessoa.size() == 0) {
				FacesMessage message = new FacesMessage(
						"Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			// preeche a lista de pessoas da tela
			listaPessoaBean = new ArrayList<PessoaBean>();
			for (Pessoa pessoa : listaPessoa) {
				PessoaBean pessoaBean = new PessoaBean();
				pessoaBean.setIdPessoa(pessoa.getIdPessoa());
				pessoaBean.setNome(pessoa.getNome());
				listaPessoaBean.add(pessoaBean);
			}

			return "listar";
		} catch (Exception e) {
			String msg = "Listagem não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	/**
	 * Consulta uma pessoa cadastrada
	 * 
	 * @return
	 */
	public String consultar() {
		try {

			HtmlInputHidden idPessoa = (HtmlInputHidden) this.getFacesContext()
					.getViewRoot().findComponent("formulario:idPessoa");

			Pessoa pessoa = getPessoaService().consultar(
					(Integer) idPessoa.getValue());

			if (pessoa == null || pessoa.getIdPessoa() == null) {
				FacesMessage message = new FacesMessage(
						"Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			// preenche os dados do bean da tela
			pessoaBean.setIdPessoa(pessoa.getIdPessoa());
			pessoaBean.setNome(pessoa.getNome());
			pessoaBean.setProfissao(pessoa.getProfissao());

			// preeche a lista de telefones da tela
			pessoaBean.setChamados(new ArrayList<ChamadoBean>());
			for (Chamado chamado : pessoa.getChamados()) {
				ChamadoBean chamadoBean = new ChamadoBean();
				chamadoBean.setIdChamado(chamado.getIdChamado());
				chamadoBean.setTipo(chamado.getTipo());
				chamadoBean.setNomeChamado(chamado.getNomeChamado());
				chamadoBean.setDescricao(chamado.getDescricao());
				pessoaBean.getChamados().add(chamadoBean);
			}

			this.setSession("chamados", pessoaBean.getChamados());

			return "editar";
		} catch (Exception e) {
			String msg = "Consulta não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
        
	/**
	 * Cria uma nova pessoa
	 * 
	 * @return
	 */
	public String criar() {
		try {

			pessoaBean = new PessoaBean();
			pessoaBean.setChamados(new ArrayList<ChamadoBean>());

			this.setSession("chamados", pessoaBean.getChamados());

			return "criar";
		} catch (Exception e) {
			String msg = "Criação não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Adiciona um Chamado de uma pessoa
	 * 
	 * @return
	 */
	public String adicionar() {
		try {

			ChamadoBean novo = new ChamadoBean();
			novo.setTipo(chamadoBean.getTipo());
			novo.setNomeChamado(chamadoBean.getNomeChamado());
			novo.setDescricao(chamadoBean.getDescricao());

			pessoaBean.getChamados().add(novo);

			chamadoBean = new ChamadoBean();

			this.setSession("chamados", pessoaBean.getChamados());

			return "criar";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					"Criação não realizada. Movito: " + e.getMessage());
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Adiciona um Chamado de uma pessoa
	 * 
	 * @return
	 */
	public String adicionarEditar() {
		try {

			ChamadoBean novo = new ChamadoBean();
			novo.setTipo(chamadoBean.getTipo());
			novo.setNomeChamado(chamadoBean.getNomeChamado());
			novo.setDescricao(chamadoBean.getDescricao());

			pessoaBean.getChamados().add(novo);

			chamadoBean = new ChamadoBean();

			this.setSession("telefones", pessoaBean.getChamados());

			return "editar";
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(
					"Criação não realizada. Movito: " + e.getMessage());
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Remove um Chamado da lista de uma pessoa
	 * 
	 * @return
	 */
	public String remover() {
		try {

			HtmlDataTable telefones = (HtmlDataTable) this.getFacesContext()
					.getViewRoot().findComponent("formulario:chamados");
			pessoaBean.getChamados().remove(
					pessoaBean.getChamados().indexOf(telefones.getRowData()));

			return null;
		} catch (Exception e) {
			String msg = "Exclusão não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui uma pessoa cadastrada
	 * 
	 * @return
	 */
	public String excluir() {
		try {

			HtmlInputHidden idPessoa = (HtmlInputHidden) this.getFacesContext()
					.getViewRoot().findComponent("formulario:idPessoa");

			Pessoa pessoa = getPessoaService().consultar(
					(Integer) idPessoa.getValue());

			if (pessoa == null || pessoa.getIdPessoa() == null) {
				FacesMessage message = new FacesMessage(
						"Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			getPessoaService().excluir(pessoa.getIdPessoa());

			return "sucesso";
		} catch (Exception e) {
			String msg = "Exclusão não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui uma pessoa cadastrada
	 * 
	 * @return
	 */
	public String alterar() {
		try {

			Pessoa pessoa = getPessoaService().consultar(
					pessoaBean.getIdPessoa());

			if (pessoa == null || pessoa.getIdPessoa() == null) {
				FacesMessage message = new FacesMessage(
						"Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			// preenche os dados da tela no objeto persistente
			pessoa.setNome(pessoaBean.getNome());
			pessoa.setProfissao(pessoaBean.getProfissao());

			// preeche a lista de Chamados da tela na lista de Chamados
			// persistente
			pessoa.setChamados(new ArrayList<Chamado>());
			for (ChamadoBean chamadoBean : pessoaBean.getChamados()) {
				Chamado chamado = new Chamado();
				chamado.setIdChamado(chamadoBean.getIdChamado() == 0 ? null
						: chamadoBean.getIdChamado());
				chamado.setTipo(chamadoBean.getTipo());
				chamado.setNomeChamado(chamadoBean.getNomeChamado());
				chamado.setDescricao(chamadoBean.getDescricao());
				chamado.setPessoa(pessoa);
				pessoa.getChamados().add(chamado);
			}

			getPessoaService().alterar(pessoa);
			return "sucesso";

		} catch (Exception e) {
			String msg = "Alteração não realizada. Movito: "
					+ ((e instanceof ChamadoException ? ((ChamadoException) e)
							.getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}


	/**
	 * Editar uma pessoa cadastrada
	 */
	public void editar() {
		
		
	}
	public PessoaService getPessoaService() {
		return pessoaService;
	}

	@Autowired
	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	private Object getSession(String variavel) {
		return this.getFacesContext().getExternalContext().getSessionMap()
				.get(variavel);
	}

	private void setSession(String variavel, Object objeto) {
		this.getFacesContext().getExternalContext().getSessionMap()
				.put(variavel, objeto);
	}

	public PessoaBean getPessoaBean() {
		return pessoaBean;
	}

	public void setPessoaBean(PessoaBean pessoaBean) {
		this.pessoaBean = pessoaBean;
	}

	public List<PessoaBean> getListaPessoaBean() {
		return listaPessoaBean;
	}

	public void setListaPessoaBean(List<PessoaBean> listaPessoaBean) {
		this.listaPessoaBean = listaPessoaBean;
	}

	public ChamadoBean getChamadoBean() {
		return chamadoBean;
	}

	public void setChamadoBean(ChamadoBean chamadoBean) {
		this.chamadoBean = chamadoBean;
	}
	
	 public void sucesso(ActionEvent actionEvent) {  
	        FacesContext context = FacesContext.getCurrentInstance();  
	        context.addMessage(null, new FacesMessage("Incluido com Sucesso"));  
	    }  
	 
}
