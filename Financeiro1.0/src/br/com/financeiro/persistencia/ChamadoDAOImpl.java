package br.com.financeiro.persistencia;

import org.springframework.stereotype.Repository;

import br.com.financeiro.entidade.Chamado;

/**
 * Classe que define as operacoes da camada de persistencia de Chamado
 * 
 * @author Bruno.Almeida
 * 
 */
@Repository
public class ChamadoDAOImpl extends GenericoDAOImpl<Chamado, Integer> implements
		ChamadoDAO {

}
