import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.financeiro.entidade.Banco;

public class Teste {

	/**
	 * @param args
	 * @author Bruno.Almeida
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BeanFactory factory = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		Banco banco = (Banco) factory.getBean("Banco");
		System.out.println(banco);
		// System.out.println(pessoa.getEndereco());

	}

}
