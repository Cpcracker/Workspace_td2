import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.pucgoias.agenda.entidade.Pessoa;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BeanFactory factory = new ClassPathXmlApplicationContext(
		        new String[] {"applicationContext.xml"});
		
		Pessoa pessoa = (Pessoa)factory.getBean("ePessoa");
		System.out.println(pessoa);
//		System.out.println(pessoa.getEndereco());

	}

}
