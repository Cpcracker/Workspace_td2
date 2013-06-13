package br.com.financeiro.negocio;

import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.financeiro.entidade.Banco;
import br.com.financeiro.entidade.Pessoa;
import br.com.financeiro.persistencia.BancoDAO;
import br.com.financeiro.persistencia.PessoaDAO;
import br.com.financeiro.util.ChamadoException;

/**
 * Classe que define as operacoes da camada de negocio de Pessoa
 * 
 * @author Bruno.Almeida
 * 
 */
@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {

	// Interface da persistencia
	private PessoaDAO pessoaDAO;
	// Interface da persistencia
	private BancoDAO chamadoDAO;

	public BancoDAO getchamadoDAO() {
		return chamadoDAO;
	}

	@Autowired
	public void setchamadoDAO(BancoDAO chamadoDAO) {
		this.chamadoDAO = chamadoDAO;
	}

	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	@Autowired
	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	/**
	 * Inclui uma pessoa
	 * 
	 * @param pessoa
	 * @return
	 * @throws ChamadoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Pessoa incluir(Pessoa pessoa) throws ChamadoException {
		return getPessoaDAO().incluir(pessoa);
	}

	/**
	 * Altera uma pessoa
	 * 
	 * @param pessoa
	 * @return
	 * @throws ChamadoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Pessoa alterar(Pessoa pessoa) throws ChamadoException {

		// exclui os itens da base que foram removidos da tela
		Pessoa pessoaExistente = this.consultar(pessoa.getIdPessoa());
		for (Banco chamado : pessoaExistente.getBanco()) {
			if (!pessoa.getBanco().contains(chamado)) {
				getchamadoDAO().excluir(chamado.getIdBanco());
			}
		}

		return getPessoaDAO().alterar(pessoa);
	}

	/**
	 * Exclui uma pessoa
	 * 
	 * @param pessoa
	 * @throws ChamadoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(Integer id) throws ChamadoException {

		// exclui todos os itens antes de excluir a pessoa
		Pessoa pessoaExistente = this.consultar(id);
		for (Banco chamado : pessoaExistente.getBanco()) {
			getchamadoDAO().excluir(chamado.getIdBanco());
		}

		getPessoaDAO().excluir(id);
	}

	/**
	 * Consulta uma pessoa pelo identificador
	 * 
	 * @param id
	 * @return
	 * @throws ChamadoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Pessoa consultar(Integer id) throws ChamadoException {
		Pessoa pessoa = getPessoaDAO().consultar(id);
		// Inicializa a lista de telefones
		Hibernate.initialize(pessoa.getBanco());
		return pessoa;
	}

	/**
	 * Lista todas as pessoas cadastradas
	 * 
	 * @return
	 * @throws ChamadoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Pessoa> listar() throws ChamadoException {
		return getPessoaDAO().listar();
	}

}
