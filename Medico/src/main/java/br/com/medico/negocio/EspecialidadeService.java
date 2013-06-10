package br.com.medico.negocio;

import java.util.List;

import br.com.medico.entidade.Especialidade;
import br.com.medico.util.AgendaException;

/**
 * Interface que define as operacoes da camada de negocio de Especialidade
 * @author Gilcimar
 *
 */
public interface EspecialidadeService {
	
	/**
	 * Inclui uma Especialidade
	 * @param Especialidade
	 * @return
	 * @throws AgendaException
	 */
	public Especialidade incluir(Especialidade Especialidade) throws AgendaException;
	
	/**
	 * Altera uma Especialidade
	 * @param Especialidade
	 * @return
	 * @throws AgendaException
	 */
	public Especialidade alterar(Especialidade Especialidade) throws AgendaException;
	
	/**
	 * Exclui uma Especialidade
	 * @param id
	 * @throws AgendaException
	 */
	public void excluir(Integer id) throws AgendaException;
	
	/**
	 * Consulta uma Especialidade pelo identificador
	 * @param id
	 * @return
	 * @throws AgendaException
	 */
	public Especialidade consultar(Integer id) throws AgendaException;
	
	/**
	 * Lista todas as Especialidades cadastradas
	 * @return
	 * @throws AgendaException
	 */
	public List<Especialidade> listar() throws AgendaException;

}
