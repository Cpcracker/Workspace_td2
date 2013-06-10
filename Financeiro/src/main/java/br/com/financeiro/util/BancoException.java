package br.com.financeiro.util;

/**
 * Classe que encapsula as excecoes da aplicacao Financeira
 * 
 * @author Bruno.Almeida
 * 
 */
public class BancoException extends Exception {

	private static final long serialVersionUID = 1189188521388183949L;
	private Exception ex;
	private String msg;

	public BancoException(Exception e) {
		ex = e;
		msg = e.getMessage();
	}

	public BancoException(Exception e, String mensagem) {
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}

}
