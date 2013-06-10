package br.com.financeiro.persistencia;

import java.io.Serializable;
import java.util.List;

import br.com.financeiro.util.BancoException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Bruno.Almeida
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
	 * @throws BancoException
	 */
	public T incluir(T object) throws BancoException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws BancoException
	 */
	public T alterar(T object) throws BancoException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws BancoException
	 */
	public T consultar(Integer id) throws BancoException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws BancoException
	 */
	public void excluir(Integer id) throws BancoException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws BancoException
	 */
	public List<T> listar() throws BancoException;
}
