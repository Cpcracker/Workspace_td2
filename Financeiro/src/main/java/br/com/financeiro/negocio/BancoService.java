package br.com.financeiro.negocio;

import java.util.List;
import br.com.financeiro.entidade.Banco;
import br.com.financeiro.util.BancoException;

/**
 * Interface que define as operacoes da camada de negocio de Medico
 * 
 * @author Bruno.Almeida
 * 
 */
public interface BancoService {

	/**
	 * Inclui um Banco
	 * 
	 * @param Banco
	 * @return
	 * @throws BancoException
	 */
	public Banco incluir(Banco Banco) throws BancoException;

	/**
	 * Altera uma Banco
	 * 
	 * @param Banco
	 * @return
	 * @throws BancoException
	 */
	public Banco alterar(Banco Banco) throws BancoException;

	/**
	 * Exclui uma Banco
	 * 
	 * @param id
	 * @throws BancoException
	 */
	public void excluir(Integer id) throws BancoException;

	/**
	 * Consulta uma Banco pelo identificador
	 * 
	 * @param id
	 * @return
	 * @throws BancoException
	 */
	public Banco consultar(Integer id) throws BancoException;

	/**
	 * Lista todas os Bancos cadastrados
	 * 
	 * @return
	 * @throws BancoException
	 */
	public List<Banco> listar() throws BancoException;

}
