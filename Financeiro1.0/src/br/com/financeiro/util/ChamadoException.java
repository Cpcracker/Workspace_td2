package br.com.financeiro.util;

public class ChamadoException extends Exception {

	private static final long serialVersionUID = 1189188521388183949L;
	private Exception ex;
	private String msg;

	public ChamadoException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

	public ChamadoException(Exception e, String mensagem){
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
