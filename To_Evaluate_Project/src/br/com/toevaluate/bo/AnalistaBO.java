package br.com.toevaluate.bo;

import java.util.List;

import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.dao.AnalistaDAO;
import br.com.toevaluate.dao.LoginDAO;
import br.com.toevaluate.util.Magic;





/**
 * Classe BO para validar os dados para o Banco de dados
 * 
 * @author Emily Vaconcelos
 * @version 2.0
 */
public class AnalistaBO extends UsuarioBO{


	public List<Usuario> listar() throws Exception {
		AnalistaDAO dao = new AnalistaDAO();
		List<Usuario> resp = dao.listar();
		dao.fecharBanco();
		return resp;
	}
	
	public static String login(Login login) throws Exception {

		if (login.getEmail().length() <= 6 && !login.getEmail().contains("@")) {
			return "Email invalido";
		}

		if (login.getSenha().length() < 3) {
			return "Senha inválida, muito pequena...";
		}

		login.setEmail(login.getEmail().toUpperCase());
		login.setSenha(login.getSenha());
		new LoginDAO().efetuarLogin(login);
		return "Login efetuado com Sucesso!!";
	}
	
	/**
	 * Método que valida os dados para Consultar um Analista cadastrado
	 * 
	 * @param id ID do Analista que será consultado
	 * @return Retorna o Analista com seus dados
	 * @author Emily Vaconcelos
	 */
	public static Analista consulta(int id) throws Exception {
		if (id < 1) {
			return new Analista();
		}
		AnalistaDAO dao = new AnalistaDAO();
		Analista resposta = dao.ler(id);
		if (resposta.getId() == 0) {
			dao.fecharBanco();
			return new Analista();
		}
		dao.ler(id);
		dao.fecharBanco();
		return resposta;
	}

	/**
	 * Método que valida os dados para Deletar um Analista
	 * 
	 * @param id ID do Analista que será deletado
	 * @return Retorna uma String "Dados apagados"
	 * @author Emily Vaconcelos
	 */
	public static String apagar(int id) throws Exception {
		if (id < 1) {
			return "ID não pode ser menor que 1";
		}

		AnalistaDAO dao = new AnalistaDAO();
		Analista func = dao.ler(id);
		if (func.getId() == 0) {
			dao.fecharBanco();
			return "ID não existente";
		}

		dao.deleteAnalista(id);
		dao.fecharBanco();
		return "Dados apagados";
	}

	/**
	 * Método que valida os dados para Atualizar o cargo do Analista
	 * 
	 * @param id    ID do Analista que será modificado
	 * @param cargo Cargo do Analista que será alterado
	 * @return Retorna uma String "Dados atualizados"
	 * @author Emily Vasconcelos
	 */
	public static String atualizar(int id, String cargo) throws Exception {
		cargo.toUpperCase();
		if (id < 1) {
			return "ID não pode ser menor que 1";
		}

		if (cargo.equals(null)) {
			return "Cargo invalido";
		}

		if (String.valueOf(id).equals(null)) {
			return "Id inválido";
		}

		AnalistaDAO dao = new AnalistaDAO();
		Analista func = dao.ler(id);
		if (func.getId() == 0) {
			dao.fecharBanco();
			return "Esse ID não existe";
		}

		if (func.getCargo().equals(cargo)) {
			dao.fecharBanco();
			return "Digite um cargo diferente do atual";
		}

		dao.updateAnalista(id, cargo);
		dao.fecharBanco();
		return "Dados atualizados";
	}

	/**
	 * Método que valida os dados para a Criação de um Analista
	 * 
	 * @param localDate a ser instanciado
	 * @return Retorna uma String "Dados gravados"
	 * @author Emily Vasconcelos
	 */
	public static String addAnalista(Analista analista, Login login) throws Exception {

		analista.getNome().toUpperCase();
		analista.getCargo().toUpperCase();
		analista.getDepartamento().toUpperCase();


		if (!(Magic.validacaoData(analista.getDt_nasc()) == "Ok")) {
			return "Data inválida";
		}

		if (analista.getNome().length() > 50) {
			return "Nome muito grande";
		}

		if (analista.getCargo().length() > 90) {
			return "Nome do cargo muito grande";
		}

		if (analista.getDepartamento().length() > 30) {
			return "Nome do departamento muito grande";
		}

		if (login.getEmail().length() > 50) {
			return "Email muito grande";
		}

		if (login.getSenha().length() > 20) {
			return "Senha muito grande";
		}
		
		AnalistaDAO dao = new AnalistaDAO();

		if (analista.getLider().getId() == 0) {
			return "Esse lider não existe";
		}
		
		dao.adicionarAnalista(analista, login);
		dao.fecharBanco();
		return "Dados gravados";

	}


}
