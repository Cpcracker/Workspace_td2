package br.com.medico.negocio;

import java.util.List;

import br.com.medico.entidade.Medico;
import br.com.medico.util.AgendaException;

/**
 * Interface que define as operacoes da camada de negocio de Medico
 * @author Gilcimar
 *
 */
public interface MedicoService {
	
	/**
	 * Inclui uma Medico
	 * @param Medico
	 * @return
	 * @throws AgendaException
	 */
	public Medico incluir(Medico Medico) throws AgendaException;
	
	/**
	 * Altera uma Medico
	 * @param Medico
	 * @return
	 * @throws AgendaException
	 */
	public Medico alterar(Medico Medico) throws AgendaException;
	
	/**
	 * Exclui uma Medico
	 * @param id
	 * @throws AgendaException
	 */
	public void excluir(Integer id) throws AgendaException;
	
	/**
	 * Consulta uma Medico pelo identificador
	 * @param id
	 * @return
	 * @throws AgendaException
	 */
	public Medico consultar(Integer id) throws AgendaException;
	
	/**
	 * Lista todas as Medicos cadastradas
	 * @return
	 * @throws AgendaException
	 */
	public List<Medico> listar() throws AgendaException;

}
