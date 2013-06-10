package br.com.financeiro.negocio;

import java.util.List;

import br.com.financeiro.entidade.Agencia;
import br.com.financeiro.util.BancoException;

/**
 * Interface que define as operacoes da camada de negocio de Especialidade
 * @author Gilcimar
 *
 */
public interface AgenciaService {
	
	/**
	 * Inclui uma Agencia
	 * @param Agencia
	 * @return
	 * @throws BancoException
	 */
	public Agencia incluir(Agencia Agencia) throws BancoException;
	
	/**
	 * Altera uma Agencia
	 * @param Agencia
	 * @return
	 * @throws BancoException
	 */
	public Agencia alterar(Agencia Agencia) throws BancoException;
	
	/**
	 * Exclui uma Agencia
	 * @param id
	 * @throws BancoException
	 */
	public void excluir(Integer id) throws BancoException;
	
	/**
	 * Consulta uma Agencia pelo identificador
	 * @param id
	 * @return
	 * @throws BancoException
	 */
	public Agencia consultar(Integer id) throws BancoException;
	
	/**
	 * Lista todas as Agencia cadastradas
	 * @return
	 * @throws BancoException
	 */
	public List<Agencia> listar() throws BancoException;

}
