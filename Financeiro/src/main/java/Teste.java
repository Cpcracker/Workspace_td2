import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.financeiro.entidade.Banco;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BeanFactory factory = new ClassPathXmlApplicationContext(
		        new String[] {"applicationContext.xml"});
		
		Banco medico = (Banco)factory.getBean("Medico");
		System.out.println(medico);
//		System.out.println(pessoa.getEndereco());

	}

}
