package br.com.financeiro.persistencia;

import org.springframework.stereotype.Repository;

import br.com.financeiro.entidade.Agencia;

/**
 * Classe que define as operacoes da camada de persistencia de Agencia
 * 
 * @author Bruno.Almeida
 * 
 */
@Repository
public class AgenciaDAOImpl extends
		GenericoDAOImpl<Agencia, Integer> implements AgenciaDAO {

}
