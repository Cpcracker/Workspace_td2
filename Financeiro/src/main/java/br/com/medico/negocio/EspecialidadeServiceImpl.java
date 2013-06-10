package br.com.medico.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.medico.entidade.Especialidade;
import br.com.medico.entidade.Medico;
import br.com.medico.persistencia.EspecialidadeDAO;
import br.com.medico.persistencia.MedicoDAO;
import br.com.medico.util.AgendaException;


/**
 * Classe que define as operacoes da camada de negocio de Especialidade
 * @author Gilcimar
 *
 */
@Service
@Transactional
public class EspecialidadeServiceImpl implements EspecialidadeService {

	//Interface da persistencia
	private EspecialidadeDAO EspecialidadeDAO;
	//Interface da persistencia
	private MedicoDAO MedicoDAO;
	
	public MedicoDAO getMedicoDAO() {
		return MedicoDAO;
	}

	@Autowired
	public void setMedicoDAO(MedicoDAO MedicoDAO) {
		this.MedicoDAO = MedicoDAO;
	}

	public EspecialidadeDAO getEspecialidadeDAO() {
		return EspecialidadeDAO;
	}

	@Autowired
	public void setEspecialidadeDAO(EspecialidadeDAO EspecialidadeDAO) {
		this.EspecialidadeDAO = EspecialidadeDAO;
	}

	/**
	 * Inclui uma Especialidade
	 * @param Especialidade
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Especialidade incluir(Especialidade Especialidade) throws AgendaException {
		return getEspecialidadeDAO().incluir(Especialidade);
	}

	/**
	 * Altera uma Especialidade
	 * @param Especialidade
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Especialidade alterar(Especialidade Especialidade) throws AgendaException {
		
		//exclui os itens da base que foram removidos da tela
		Especialidade EspecialidadeExistente = this.consultar(Especialidade.getIdespecialidade());
		/*for (Medico Medico : EspecialidadeExistente.getListaMedico()) {
			if(!Especialidade.getListaMedico().contains(Medico)){
				getMedicoDAO().excluir(Medico.getIdespecialidade());
			}
		}*/
		
		return getEspecialidadeDAO().alterar(Especialidade);
	}

	/**
	 * Exclui uma Especialidade
	 * @param Especialidade
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws AgendaException {
		
		//exclui todos os itens antes de excluir a Especialidade
		Especialidade EspecialidadeExistente = this.consultar(id);
		/*for (Medico Medico : EspecialidadeExistente.getListaMedico()) {
			getMedicoDAO().excluir(Medico.getIdMedico());
		}*/

		getEspecialidadeDAO().excluir(id);
	}

	/**
	 * Consulta uma Especialidade pelo identificador
	 * @param id
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Especialidade consultar(Integer id) throws AgendaException {
		Especialidade Especialidade = getEspecialidadeDAO().consultar(id);
		//Inicializa a lista de Medicos
		Hibernate.initialize(Especialidade.getIdespecialidade());
		return Especialidade;
	}

	/**
	 * Lista todas as Especialidades cadastradas
	 * @return
	 * @throws AgendaException
	 */
	@Override
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Especialidade> listar() throws AgendaException {
		return getEspecialidadeDAO().listar();
	}

}
