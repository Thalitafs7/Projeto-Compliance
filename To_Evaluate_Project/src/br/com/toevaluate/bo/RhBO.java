package br.com.toevaluate.bo;

import br.com.toevaluate.beans.Avaliacao;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Rh;
import br.com.toevaluate.beans.Telefone;
import br.com.toevaluate.dao.AvaliacaoDAO;
import br.com.toevaluate.dao.LoginDAO;
import br.com.toevaluate.dao.RhDAO;

/**
 * Classe de validação dos dados do RH para o Banco de Dados
 * 
 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
 * @version 2.0
 */
public class RhBO {

	/**
	 * Método que valida os dados do Desempenho e suas respectivas validações
	 * 
	 * @param id ID do RH e ID da Skill a ser verificado
	 * @return Retorna uma Srting "Desempenho verificado!"
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public static String verificarDesempenho(int id) throws Exception {

		RhDAO dao = new RhDAO();
		Rh funcRh = dao.read(id);

		if (funcRh.getId() == 0) {

			return "ID não existente";
		}

		AvaliacaoDAO daoA = new AvaliacaoDAO();
		Avaliacao avaliacao = daoA.read(id);

		if (String.valueOf(avaliacao.getNotaAnalista()).equals(null)
				|| String.valueOf(avaliacao.getNotaLider()).equals(null)) {
			dao.fechar();
			return "Avaliações incompletas";
		}

		dao.verificarDesempenho(id);

		dao.fechar();
		return "Desempenho verificado!";

	}

	/**
	 * Método que valida os dados das Avaliações
	 * 
	 * @param id ID do RH e ID da Skill a ser verificado
	 * @return Retorna uma Srting "Avaliações realizadas com sucesso!"
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public static String vereficarAva(int id) throws Exception {
		RhDAO dao = new RhDAO();
		Rh funcRh = dao.read(id);
		if (funcRh.getId() == 0) {
			dao.fechar();
			return "ID não existente";
		}
		dao.verificarAvaliacao(id);
		dao.fechar();
		return "Avaliações realizadas com sucesso!";
	}

	/**
	 * Método que valida os dados para Criar um novo Login para o Usuário
	 * 
	 * @param login a ser instanciado e criado
	 * @return Retorna uma Srting "Usuário cadastrado com sucesso"
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public static String novoUsuario(Login login) throws Exception {

		int numero = login.getId();

		if (login.getEmail().length() > 30) {
			System.out.println("Email maior que o permitido");
			return "Email incorreto (muitos caracteres)";
		}
		if (login.getSenha().length() > 30) {
			System.out.println("Senha muito grande");
			return "Senha muito grande";
		}
		if (login.getSenha().length() == 0) {

			return "Digite um senha válida";
		}
		if (String.valueOf(numero).length() > 4) {

			return "Número de ID maior que o permitido";
		}
		LoginDAO dao = new LoginDAO();
		RhDAO daoRh = new RhDAO();
		daoRh.cadastrarUsuario(login);
		dao.fechar();
		return "Usuário cadastrado com sucesso";

	}

	/**
	 * Método que valida os dados para Consultar um RH
	 * 
	 * @param id ID do RH a ser pesquisado
	 * @return Retorna o RH com seus dados relacionados
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public static Rh consulta(int id) throws Exception {
		if (id < 1) {
			return new Rh();
		}
		RhDAO dao = new RhDAO();
		Rh funRH = dao.read(id);
		if (funRH.getId() == 0) {
			dao.fechar();
			return new Rh();
		}
		dao.fechar();
		return funRH;
	}

	/**
	 * Método que valida os dados para Atualizar o RH
	 * 
	 * @param rh a ser moddificado
	 * @return Retorna uma Srting "Rh atualizado"
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public static String atualizar(Rh rh) throws Exception {
		if (rh.getId() < 1) {
			return "ID não pode ser menor que 1";
		}

		RhDAO dao = new RhDAO();
		Rh funcRh = dao.read(rh.getId());
		if (funcRh.getId() == 0) {
			dao.fechar();
			return "Esse ID não existe";
		}
		
		dao.updateRh(rh);
		dao.fechar();
		return "Funcionario Rh atualizado";
	}

	/**
	 * Método que valida os dados para Deletar o RH
	 * 
	 * @param id a ser deletado
	 * @return Retorna uma Srting "Rh deletado"
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public static String deletar(int id) throws Exception {
		if (id < 1) {
			return "ID inválido";
		}
		RhDAO dao = new RhDAO();
		Rh funcRh = dao.read(id);
		if (funcRh.getId() == 0) {
			dao.fechar();
			return "ID não existente";
		}

		dao.deleteRh(id);
		dao.fechar();
		return "Rh deletado";
	}

	/**
	 * Método que valida os dados para Adicioanr um novo RH
	 * 
	 * @param rh a ser instanciado e criado
	 * @return Retorna uma Srting "Rh cadastrado"
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public static String addRh(Rh rh, Login login) throws Exception {

//		if (rh.getId() < 1) {
//			return "ID inválido";
//		}

		RhDAO dao = new RhDAO();
		Rh funcRh = dao.read(rh.getId());
		if (funcRh.getId() != 0) {
			dao.fechar();
			return "ID inválido";
		}

		dao.addRh(rh, login);
		dao.fechar();
		return "Rh cadastrado";
	}
	
	public static String validarUpdate(Telefone tel, Login login, Rh rh) throws Exception {
		int indice = 0;
		if (tel.getDdd() < 11 || tel.getDdd() > 99) {
			return "DDD Inválido";
		}
		String num = Integer.toString(tel.getNumero());
		for (int i = 0; i < num.length(); i++) {
			indice = i;
		}
		if (indice != 8) {
			return "Número Inválido";
		}

		if (rh.getId() <= 0) {
			return "ID do Funcionário Inválido";
		}
		
		if (login.getSenha().length() > 30) {
			return "Senha muito grande";
		}
		if (login.getSenha().length() == 0) {
			return "Digite um senha válida";
		}

		if (login.getSenha().equals(null)) {
			return "Campo vazio";
		}

		LoginDAO dao = new LoginDAO();
		if (dao.ler(rh.getId()).equals(null)) {
			dao.fechar();
			return "Esse ID não consta em nosso banco";
		}


		if (rh.getId() < 1) {
			return "ID não pode ser menor que 1";
		}
				
		return null;
	}

}
