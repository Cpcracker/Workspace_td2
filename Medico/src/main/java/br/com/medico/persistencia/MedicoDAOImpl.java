package br.com.medico.persistencia;

import org.springframework.stereotype.Repository;

import br.com.medico.entidade.Medico;

/**
 * Classe que define as operacoes da camada de persistencia de Medico
 * 
 * @author Fernando Cardoso
 * 
 */
@Repository
public class MedicoDAOImpl extends GenericoDAOImpl<Medico, Integer> implements
		MedicoDAO {

}
