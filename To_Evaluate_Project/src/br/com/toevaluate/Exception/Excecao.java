package br.com.toevaluate.Exception;

import java.sql.SQLException;

public class Excecao extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String tratarExcecoes(Exception erro) {
		if(erro instanceof NullPointerException) {
			return "Objeto Nulo!!";
			
		} else if (erro instanceof NumberFormatException) {
			return "Número inválido digitado!";
			
		}else if (erro instanceof SQLException) {
			return "Erro no Banco de Dados FIAP verifique as tabelas....";
			
		}else if (erro instanceof ArithmeticException) {
			return "Operação invalida, verifique se não existe divisão por 0.";
		}
		else {
			return "Exceção deconhecida...talvez ela não foi tratada ainda.";
		}
	}
}
