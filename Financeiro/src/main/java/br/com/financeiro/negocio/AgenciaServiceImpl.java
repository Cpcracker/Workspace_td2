package br.com.financeiro.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.financeiro.entidade.Agencia;
import br.com.financeiro.entidade.Banco;
import br.com.financeiro.persistencia.AgenciaDAO;
import br.com.financeiro.persistencia.BancoDAO;
import br.com.financeiro.util.BancoException;

/**
 * Classe que define as operacoes da camada de negocio de Especialidade
 * 
 * @author Bruno.Almeida
 * 
 */
@SuppressWarnings("unused")
@Service
@Transactional
public class AgenciaServiceImpl implements AgenciaService {

	// Interface da persistencia
	private AgenciaDAO AgenciaDAO;
	// Interface da persistencia
	private BancoDAO BancoDAO;

	public BancoDAO getBancoDAO() {
		return BancoDAO;
	}

	@Autowired
	public void setBancoDAO(BancoDAO BancoDAO) {
		this.BancoDAO = BancoDAO;
	}

	public AgenciaDAO getAgenciaDAO() {
		return AgenciaDAO;
	}

	@Autowired
	public void setAgenciaDAO(AgenciaDAO AgenciaDAO) {
		this.AgenciaDAO = AgenciaDAO;
	}

	/**
	 * Inclui uma Agencia
	 * 
	 * @param Agencia
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Agencia incluir(Agencia Agencia) throws BancoException {
		return getAgenciaDAO().incluir(Agencia);
	}

	/**
	 * Altera uma Agencia
	 * 
	 * @param Agencia
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Agencia alterar(Agencia Agencia) throws BancoException {

		// exclui os itens da base que foram removidos da tela
		Agencia AgenciaExistente = this.consultar(Agencia.getIdagencia());
		/*
		 * for (Medico Medico : EspecialidadeExistente.getListaMedico()) {
		 * if(!Especialidade.getListaMedico().contains(Medico)){
		 * getMedicoDAO().excluir(Medico.getIdespecialidade()); } }
		 */

		return getAgenciaDAO().alterar(Agencia);
	}

	/**
	 * Exclui uma Agencia
	 * 
	 * @param Agencia
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(Integer id) throws BancoException {

		// exclui todos os itens antes de excluir a Especialidade
		Agencia AgenciaExistente = this.consultar(id);
		/*
		 * for (Medico Medico : EspecialidadeExistente.getListaMedico()) {
		 * getMedicoDAO().excluir(Medico.getIdMedico()); }
		 */

		getAgenciaDAO().excluir(id);
	}

	/**
	 * Consulta uma Agencia pelo identificador
	 * 
	 * @param id
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Agencia consultar(Integer id) throws BancoException {
		Agencia Agencia = getAgenciaDAO().consultar(id);
		// Inicializa a lista de Agencias
		Hibernate.initialize(Agencia.getIdagencia());
		return Agencia;
	}

	/**
	 * Lista todas as Agencias cadastradas
	 * 
	 * @return
	 * @throws BancoException
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Agencia> listar() throws BancoException {
		return getAgenciaDAO().listar();
	}

}
