package br.com.chamado.persistencia;

import org.springframework.stereotype.Repository;
import br.com.chamado.entidade.Chamado;

/**
 * Classe que define as operacoes da camada de persistencia de Chamado
 * 
 * @author Murillo
 * 
 */
@Repository
public class ChamadoDAOImpl extends GenericoDAOImpl<Chamado, Integer> implements
		ChamadoDAO {

}
