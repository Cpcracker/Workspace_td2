package br.com.chamado.negocio;

import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.chamado.entidade.Chamado;
import br.com.chamado.entidade.Pessoa;
import br.com.chamado.persistencia.ChamadoDAO;
import br.com.chamado.persistencia.PessoaDAO;
import br.com.chamado.util.ChamadoException;

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
	private ChamadoDAO chamadoDAO;

	public ChamadoDAO getchamadoDAO() {
		return chamadoDAO;
	}

	@Autowired
	public void setchamadoDAO(ChamadoDAO chamadoDAO) {
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
		for (Chamado chamado : pessoaExistente.getChamados()) {
			if (!pessoa.getChamados().contains(chamado)) {
				getchamadoDAO().excluir(chamado.getIdChamado());
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
		for (Chamado chamado : pessoaExistente.getChamados()) {
			getchamadoDAO().excluir(chamado.getIdChamado());
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
		Hibernate.initialize(pessoa.getChamados());
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
