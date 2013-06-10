package br.com.financeiro.persistencia;

import org.springframework.stereotype.Repository;

import br.com.financeiro.entidade.Especialidade;

/**
 * Classe que define as operacoes da camada de persistencia de Especialidade
 * 
 * @author Fernando Cardoso
 * 
 */
@Repository
public class EspecialidadeDAOImpl extends
		GenericoDAOImpl<Especialidade, Integer> implements EspecialidadeDAO {

}
