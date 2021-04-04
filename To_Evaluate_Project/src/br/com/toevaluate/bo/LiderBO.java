package br.com.toevaluate.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Avaliacao;
import br.com.toevaluate.beans.Lider;
import br.com.toevaluate.beans.Skill;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.dao.LiderDAO;
import br.com.toevaluate.util.Magic;

/**
 * Classe de Validação dos dados do Líder que irá para o Banco de Dados
 * 
 * @author Thalita Feitosa
 * @version 2.0
 */
public class LiderBO {

	
	/**
	 * Método que valida os dados para Deletar um Líder
	 * 
	 * @param id ID do Líder a ser Deletado
	 * @return Retorna uma String "Líder Apagado com sucesso"
	 * @author Thalita Feitosa
	 */
	public static String apagar(int id) throws Exception {
		if (id <= 0) {
			return "ID Inválido";
		}
		LiderDAO dao = new LiderDAO();
		Usuario lider = dao.lerLider(id);
		if (lider.getId() == 0) {
			dao.fecharBanco();
			return "ID não existe";
		}
		dao.delLider(id);
		dao.fecharBanco();
		return "Líder Apagado com sucesso";
	}

	/**
	 * Método que valida dados para Consultar um Líder
	 * 
	 * @param id ID do Líder a ser pesquisado
	 * @return Retorna um Líder com seus dados relacionados
	 * @author Thalita Feitosa
	 */
	public static Lider psqLider(int id) throws Exception {
		if (id < 1) {
			return new Lider();
		}
		LiderDAO dao = new LiderDAO();
		Lider ldr = dao.lerLider(id);
		dao.fecharBanco();
		return ldr;

	}
	public static List<Analista> verSubordinados(Lider lider)throws Exception{
		List<Analista> list = new ArrayList();
		if (lider.getIdFuncLider() < 1) {
			return list;
		}
		LiderDAO dao = new LiderDAO();
		list = dao.listaDeAnalistas(lider);
		dao.fecharBanco();
		return list;
	}

	/**
	 * Método que valida dos dados para Atualizar o cargo do Líder
	 * 
	 * @param id    ID do Líder a ser pesquisado
	 * @param nome  Nome do equipe a ser modificado
	 * @param subor A quantidade de subordinados a ser modificado
	 * @return Retorna um String "Dados do Lider atualizado!"
	 * @author Thalita Feitosa
	 */
	public static String atualizar(int id, String situacao) throws Exception {
		situacao.toUpperCase();
		if (id < 1) {
			return "ID Inválido";
		}

		LiderDAO dao = new LiderDAO();
		Lider lider = dao.lerLider(id);
		if (lider.getId() == 0) {
			dao.fecharBanco();
			return "ID não existe";
		}

		if (lider.getSituacao().equals(situacao)) {
			return "Esse lider já está " + situacao;
		}

		dao.updateLider(id, situacao);
		dao.fecharBanco();
		return "Dados do Lider atualizado!";

	}

	/**
	 * Método que valida os dados para Adicionar um Líder
	 * 
	 * @param lider a ser instanciado
	 * @return Retorna um String "Líder adicionado com sucesso!"
	 * @author Thalita Feitosa
	 */
	public static String addLider(Lider analista, Login login) throws Exception {

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

		LiderDAO dao = new LiderDAO();
		dao.addEmLider(analista, login);
		dao.fecharBanco();
		return "Dados gravados";

	}

	/**
	 * Método que valida os dados para o Líder Avaliar um Analista
	 * 
	 * @param id a ser pesquisado
	 * @return Retorna uma String "Avaliação realizada!"
	 * @author Thalita Feitosa
	 */
	public static List<Skill>  skillsSubordinados(Lider lider)throws Exception{
		List<Skill> skillLista = new ArrayList<Skill>();
		if (lider.getIdFuncLider() <= 0) {
			 return skillLista;
		}
		LiderDAO dao = new LiderDAO();
		skillLista = dao.idSkills(lider);
		dao.fecharBanco();
		return skillLista;
	}
	public static String criarAvaliacao(Avaliacao avaliacao, Lider lider ) throws Exception {
		if (!(Magic.validacaoData(avaliacao.getDataLimite()) == "Ok")) {
			return "Data inválida";
		}
		if (!(Magic.validacaoData(avaliacao.getDataResposta()) == "Ok")) {
			return "Data inválida";
		}
		if (lider.getIdFuncLider() <= 0) {
			return "ID Inválido";
		}
		LiderDAO dao = new LiderDAO();
		dao.cadastrarAvaliacao(avaliacao, lider);
		dao.fecharBanco();
		return "Avaliação Cadastrada!";
	}
	public static String avaliar(Lider lider, int idFunc,int idSkill,int nota) throws Exception {		
		if (lider.getIdFuncLider() <= 0) {
			return "ID do Lider Inválido";
		}
		if (nota < 0 || nota > 10) {
			return "Nota Inválida.";
		}
		LiderDAO dao = new LiderDAO();
		dao.enviarNota(lider, idFunc,idSkill,nota);
		dao.fecharBanco();
		return "Avaliação Computada!";
	}
	public static String cadastrarSkill(Skill skill)throws Exception{

		if(skill.getNome().length() > 30) {
			return "Número de caracteres excedeu a quantidade permitida";
		}
		if(skill.getNome().length() == 0) {
			return "O nome da Skill precisa ser preenchido";
		}
		if(skill.getDescricao().length() > 260) {
			return "Número de caracteres excedeu a quantidade permitida";
		}
		LiderDAO dao = new LiderDAO();
		dao.criarSkill(skill);
		dao.fecharBanco();
		return "Skill Cadastrada";
		
	}

	public static List<Skill> skillsAnalista(int id)throws Exception{
		List<Skill> skillLista = new ArrayList<Skill>();
		if (id <= 0) {
			 return skillLista;
		}
		LiderDAO dao = new LiderDAO();
		skillLista = dao.skillAnalista(id);
		dao.fecharBanco();
		return skillLista;
	}
	
	public static String sequenciaAnalista(int idAnalista, String nome)throws Exception{
		if(idAnalista <= 0) {
			return "ID Inválido";
		}
		if(nome.length() == 0 || nome.length() > 30) {
			return "Por favor, verifique o nome da Skill";
		}
		LiderDAO dao = new LiderDAO();
		String resultado = dao.idSequence(idAnalista, nome);
		dao.fecharBanco();
		return resultado;
	}
	
}

