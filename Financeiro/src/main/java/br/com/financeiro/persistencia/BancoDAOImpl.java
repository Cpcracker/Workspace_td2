package br.com.financeiro.persistencia;

import org.springframework.stereotype.Repository;

import br.com.financeiro.entidade.Banco;

/**
 * Classe que define as operacoes da camada de persistencia de Banco
 * 
 * @author Bruno.Almeida
 * 
 */
@Repository
public class BancoDAOImpl extends GenericoDAOImpl<Banco, Integer> implements
		BancoDAO {

}
