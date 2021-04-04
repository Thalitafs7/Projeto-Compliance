package br.com.toevaluate.bo;

import br.com.toevaluate.beans.Login;
import br.com.toevaluate.dao.LoginDAO;

/**
 * Classe de valida��o dos dados de Login para o Banco de Dados
 * 
 * @author Mateus Ramos Martins
 *
 */
public class LoginBO {

	/**
	 * M�todo que valida os dados para Desligar um Funcion�rio
	 * 
	 * @param id      ID do Usu�rio a ser pesquisado
	 * @param dtFinal Data Final do Login do Usu�rio
	 * @return Retorna uma String "Funcion�rio desligado."
	 * @author Mateus Ramos Martins
	 */
	public static String desligamento(int id, String dtFinal) throws Exception {

		LoginDAO dao = new LoginDAO();
		Login resposta = dao.ler(id);
		if (resposta.getId() == 0) {
			dao.fechar();
			return "Esse ID n�o consta em nosso banco";
		}
		dao.desligamentoFuncionario(id, dtFinal);
		dao.fechar();
		return "Funcion�rio desligado.";

	}

	/**
	 * M�todo que valida os dados para Deletar um Login
	 * 
	 * @param idUser ID do Usu�rio a ser apagado
	 * @return Retorna uma String "Login Apagado!"
	 * @author Mateus Ramos Martins
	 */
	public static String apagar(int id) throws Exception {
		if (id < 1) {
			return "Id inv�lido";
		}

		LoginDAO dao = new LoginDAO();
		if (dao.ler(id).equals(null)) {
			dao.fechar();
			return "Esse ID n�o consta em nosso banco";
		}
		dao.deletar(id);
		dao.fechar();
		return "Login Apagado!";
	}

	/**
	 * M�todo que valida os dados para Atualizar um Login
	 * 
	 * @param idUser ID do Usu�rio a ser apagado
	 * @param senha  Senha a ser alterada
	 * @return Retorna uma String "Login Atualizado!"
	 * @author Mateus Ramos Martins
	 */
	public static String update(int id, Login login) throws Exception {
		if (login.getSenha().length() > 30) {
			return "Senha muito grande";
		}
		if (login.getSenha().length() == 0) {
			return "Digite um senha v�lida";
		}

		if (login.getSenha().equals(null)) {
			return "Campo vazio";
		}

		if (id < 1) {
			return "Id inv�lido";
		}

		LoginDAO dao = new LoginDAO();
		Login resp = dao.ler(id);
		if (dao.ler(id).equals(null)) {
			dao.fechar();
			return "Esse ID n�o consta em nosso banco";
		}

		dao.updateLogin(login, id);
		dao.fechar();
		return "Login Atualizado!";
	}

	/**
	 * M�todo que valida os dados para Consultar os dados do Login
	 * 
	 * @param id ID do Usu�rio a ser consultado
	 * @return Retorna um Login com seus dados relacionados
	 * @author Mateus Ramos Martins
	 */
	public static Login consultar(int id) throws Exception {
		if (id < 1) {
			return new Login();
		}
		LoginDAO dao = new LoginDAO();
		Login login = dao.ler(id);
		if (login.getId() == 0) {
			dao.fechar();
			return new Login();
		}
		dao.fechar();
		return login;
	}

	public static String addLogin(Login login) throws Exception {
		if (login.getEmail().length() > 50) {
			return "Email muito grande";
		}

		if (login.getSenha().length() > 20) {
			return "Senha muito grande";
		}

//		if (!(Magic.validacaoData(login.getDtInicio()) == "Ok")) {
//			return "Data inv�lida";
//		}

		LoginDAO dao = new LoginDAO();
//		Login log = dao.ler(login.getId());
//		if (!log.getEmail().equals(null)) {
//			return "Email j� existente";
//		}

		dao.add(null, null, null, login);
		dao.fechar();

		return "Dados do Login criado com sucesso";
	}

	/**
	 * M�todo que valida os dados para efetuar o Login
	 * 
	 * @param login a ser instanciado
	 * @return Retorna uma String "Login efetuado com Sucesso!!"
	 * @author Mateus Ramos Martins
	 */
	public static String login(Login login) throws Exception {

		if (login.getEmail().length() <= 6 && !login.getEmail().contains("@")) {
			return "Email invalido";
		}

		if (login.getSenha().length() < 3) {
			return "Senha inv�lida, muito pequena...";
		}

		LoginDAO dao = new LoginDAO();

		dao.efetuarLogin(login);
		dao.fechar();
		return "Login efetuado com Sucesso!!";
	}

}
