package br.com.chamado.negocio;

import java.util.List;

import br.com.chamado.entidade.Pessoa;
import br.com.chamado.util.ChamadoException;
/**
 * Interface que define as operacoes da camada de negocio de Pessoa
 * @author Bruno.Almeida
 *
 */
public interface PessoaService {
	/**
	 * Inclui uma pessoa
	 * @param pessoa
	 * @return
	 * @throws ChamadoException
	 */
	public Pessoa incluir(Pessoa pessoa) throws ChamadoException;
	
	/**
	 * Altera uma pessoa
	 * @param pessoa
	 * @return
	 * @throws ChamadoException
	 */
	public Pessoa alterar(Pessoa pessoa) throws ChamadoException;
	
	/**
	 * Exclui uma pessoa
	 * @param id
	 * @throws ChamadoException
	 */
	public void excluir(Integer id) throws ChamadoException;
	
	/**
	 * Consulta uma pessoa pelo identificador
	 * @param id
	 * @return
	 * @throws ChamadoException
	 */
	public Pessoa consultar(Integer id) throws ChamadoException;
	
	/**
	 * Lista todas as pessoas cadastradas
	 * @return
	 * @throws ChamadoException
	 */
	public List<Pessoa> listar() throws ChamadoException;

}
