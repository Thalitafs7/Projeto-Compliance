package br.com.toevaluate.bo;

import br.com.toevaluate.beans.Login;
import br.com.toevaluate.dao.LoginDAO;

/**
 * Classe de validação dos dados de Login para o Banco de Dados
 * 
 * @author Mateus Ramos Martins
 *
 */
public class LoginBO {

	/**
	 * Método que valida os dados para Desligar um Funcionário
	 * 
	 * @param id      ID do Usuário a ser pesquisado
	 * @param dtFinal Data Final do Login do Usuário
	 * @return Retorna uma String "Funcionário desligado."
	 * @author Mateus Ramos Martins
	 */
	public static String desligamento(int id, String dtFinal) throws Exception {

		LoginDAO dao = new LoginDAO();
		Login resposta = dao.ler(id);
		if (resposta.getId() == 0) {
			dao.fechar();
			return "Esse ID não consta em nosso banco";
		}
		dao.desligamentoFuncionario(id, dtFinal);
		dao.fechar();
		return "Funcionário desligado.";

	}

	/**
	 * Método que valida os dados para Deletar um Login
	 * 
	 * @param idUser ID do Usuário a ser apagado
	 * @return Retorna uma String "Login Apagado!"
	 * @author Mateus Ramos Martins
	 */
	public static String apagar(int id) throws Exception {
		if (id < 1) {
			return "Id inválido";
		}

		LoginDAO dao = new LoginDAO();
		if (dao.ler(id).equals(null)) {
			dao.fechar();
			return "Esse ID não consta em nosso banco";
		}
		dao.deletar(id);
		dao.fechar();
		return "Login Apagado!";
	}

	/**
	 * Método que valida os dados para Atualizar um Login
	 * 
	 * @param idUser ID do Usuário a ser apagado
	 * @param senha  Senha a ser alterada
	 * @return Retorna uma String "Login Atualizado!"
	 * @author Mateus Ramos Martins
	 */
	public static String update(int id, Login login) throws Exception {
		if (login.getSenha().length() > 30) {
			return "Senha muito grande";
		}
		if (login.getSenha().length() == 0) {
			return "Digite um senha válida";
		}

		if (login.getSenha().equals(null)) {
			return "Campo vazio";
		}

		if (id < 1) {
			return "Id inválido";
		}

		LoginDAO dao = new LoginDAO();
		Login resp = dao.ler(id);
		if (dao.ler(id).equals(null)) {
			dao.fechar();
			return "Esse ID não consta em nosso banco";
		}

		dao.updateLogin(login, id);
		dao.fechar();
		return "Login Atualizado!";
	}

	/**
	 * Método que valida os dados para Consultar os dados do Login
	 * 
	 * @param id ID do Usuário a ser consultado
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
//			return "Data inválida";
//		}

		LoginDAO dao = new LoginDAO();
//		Login log = dao.ler(login.getId());
//		if (!log.getEmail().equals(null)) {
//			return "Email já existente";
//		}

		dao.add(null, null, null, login);
		dao.fechar();

		return "Dados do Login criado com sucesso";
	}

	/**
	 * Método que valida os dados para efetuar o Login
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
			return "Senha inválida, muito pequena...";
		}

		LoginDAO dao = new LoginDAO();

		dao.efetuarLogin(login);
		dao.fechar();
		return "Login efetuado com Sucesso!!";
	}

}
