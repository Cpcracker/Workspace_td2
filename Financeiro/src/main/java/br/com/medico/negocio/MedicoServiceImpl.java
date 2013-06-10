package br.com.medico.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.medico.entidade.Medico;
import br.com.medico.persistencia.MedicoDAO;
import br.com.medico.persistencia.EspecialidadeDAO;
import br.com.medico.util.AgendaException;


/**
 * Classe que define as operacoes da camada de negocio de Medico
 * @author Gilcimar
 *
 */
@Service
@Transactional
public class MedicoServiceImpl implements MedicoService {

	//Interface da persistencia
	private MedicoDAO MedicoDAO;
	//Interface da persistencia
	private EspecialidadeDAO EspecialidadeDAO;
	
	public EspecialidadeDAO getEspecialidadeDAO() {
		return EspecialidadeDAO;
	}

	@Autowired
	public void setEspecialidadeDAO(EspecialidadeDAO EspecialidadeDAO) {
		this.EspecialidadeDAO = EspecialidadeDAO;
	}

	public MedicoDAO getMedicoDAO() {
		return MedicoDAO;
	}

	@Autowired
	public void setMedicoDAO(MedicoDAO MedicoDAO) {
		this.MedicoDAO = MedicoDAO;
	}

	/**
	 * Inclui uma Medico
	 * @param Medico
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Medico incluir(Medico Medico) throws AgendaException {
		return getMedicoDAO().incluir(Medico);
	}

	/**
	 * Altera uma Medico
	 * @param Medico
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Medico alterar(Medico Medico) throws AgendaException {
		
		return getMedicoDAO().alterar(Medico);
	}

	/**
	 * Exclui uma Medico
	 * @param Medico
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws AgendaException {
		
		getMedicoDAO().excluir(id);
	}

	/**
	 * Consulta uma Medico pelo identificador
	 * @param id
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Medico consultar(Integer id) throws AgendaException {
		Medico Medico = getMedicoDAO().consultar(id);
		//Inicializa a lista de Especialidades
		Hibernate.initialize(Medico.getIdespecialidade());
		return Medico;
	}

	/**
	 * Lista todas as Medicos cadastradas
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Medico> listar() throws AgendaException {
		return getMedicoDAO().listar();
	}

}
