package br.com.chamado.persistencia;

import java.io.Serializable;
import java.util.List;
import br.com.chamado.util.ChamadoException;
/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Murillo
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {
	
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws ChamadoException
	 */
	public T incluir(T object) throws ChamadoException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws ChamadoException
	 */
	public T alterar(T object) throws ChamadoException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws ChamadoException
	 */
	public T consultar(Integer id) throws ChamadoException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws ChamadoException
	 */
	public void excluir(Integer id) throws ChamadoException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws ChamadoException
	 */
	public List<T> listar() throws ChamadoException;

}
