package br.com.financeiro.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.financeiro.entidade.Banco;
import br.com.financeiro.persistencia.AgenciaDAO;
import br.com.financeiro.persistencia.BancoDAO;
import br.com.financeiro.util.BancoException;

/**
 * Classe que define as operacoes da camada de negocio de Medico
 * 
 * @author Bruno.Almeida
 * 
 */
@Service
@Transactional
public class BancoServiceImpl implements BancoService {

	// Interface da persistencia
	private BancoDAO BancoDAO;
	// Interface da persistencia
	private AgenciaDAO AgenciaDAO;

	public AgenciaDAO getAgenciaDAO() {
		return AgenciaDAO;
	}

	@Autowired
	public void setAgenciaDAO(AgenciaDAO AgenciaDAO) {
		this.AgenciaDAO = AgenciaDAO;
	}

	public BancoDAO getBancoDAO() {
		return BancoDAO;
	}

	@Autowired
	public void setBancoDAO(BancoDAO BancoDAO) {
		this.BancoDAO = BancoDAO;
	}

	/**
	 * Inclui uma Banco
	 * 
	 * @param Banco
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Banco incluir(Banco Banco) throws BancoException {
		return getBancoDAO().incluir(Banco);
	}

	/**
	 * Altera uma Banco
	 * 
	 * @param Banco
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Banco alterar(Banco Banco) throws BancoException {

		return getBancoDAO().alterar(Banco);
	}

	/**
	 * Exclui uma Banco
	 * 
	 * @param Banco
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(Integer id) throws BancoException {

		getBancoDAO().excluir(id);
	}

	/**
	 * Consulta uma Banco pelo identificador
	 * 
	 * @param id
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Banco consultar(Integer id) throws BancoException {
		Banco Banco = getBancoDAO().consultar(id);
		// Inicializa a lista de Especialidades
		Hibernate.initialize(Banco.getIdagencia());
		return Banco;
	}

	/**
	 * Lista todas as Medicos cadastradas
	 * 
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Banco> listar() throws BancoException {
		return getBancoDAO().listar();
	}

}
