package br.com.financeiro.persistencia;

import org.springframework.stereotype.Repository;

import br.com.financeiro.entidade.Pessoa;
/**
 * Classe que define as operacoes da camada de persistencia de Pessoa
 * @author Bruno.Almeida
 *
 */
@Repository
public class PessoaDAOImpl extends GenericoDAOImpl<Pessoa, Integer> implements
		PessoaDAO {

}