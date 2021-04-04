package br.com.toevaluate.bo;

import br.com.toevaluate.beans.Skill;
import br.com.toevaluate.dao.SkillDAO;

/**
 * Classe de Validações dos dados de Skill para o Banco de Dados
 * 
 * @author Gabriel
 * @version 2.0
 */
public class SkillBO {

	/**
	 * Método que valida os dados para criação de uma nova Skill
	 * 
	 * @param skill Skill a ser adicionada
	 * @return Retorna uma String "Skill Adicionada"
	 * @author Gabriel
	 */
	public static String adicionarSkill(Skill skill) throws Exception {
		int variavel = skill.getId();
		if (skill.getNome().length() < 4) {
			return "Nome da Skill muito pequeno";
		}
		if (skill.getNome().length() > 30) {
			return "Nome da Skill muito grande";
		}
		if (String.valueOf(variavel).length() >= 4) {
			return "ID Maior que o permitido";
		}
		if (skill.getDescricao().length() <= 4 || skill.getDescricao().length() >= 40) {
			return "Verifique o tamanho, ele pode estar menor ou maior do que o permitido";
		}
		SkillDAO dao = new SkillDAO();
		dao.adicionarSkill(skill);
		dao.fecharBanco();
		return "Skill Adicionada";
	}

	/**
	 * Método que valida os dados para deleatar uma Skill
	 * 
	 * @param idSkill ID da Skill a ser deletada
	 * @return Retorna uma String "Skill deletada"
	 * @author Gabriel
	 */
	public static String deletarSkill(int idSkill) throws Exception {
		if (idSkill < 1) {
			return "Valor do ID menor que o permitido";
		}
		SkillDAO dao = new SkillDAO();
		Skill resposta = dao.lerSkills(idSkill);
		if (resposta.getId() == 0) {
			dao.fecharBanco();
			return "Esse ID nao consta em nosso banco";
		}

		dao.deleteSkill(idSkill);
		dao.fecharBanco();
		return "Skill deletada";
	}

	/**
	 * Método que valida os dados para consultar uma Skill cadastrada
	 * 
	 * @param idSkill ID da Skill a ser consultada
	 * @return Retorna um Skill com seus dados relacionados
	 * @author Gabriel
	 */
	public static Skill lerSkill(int idSkill) throws Exception {
		if (idSkill < 1) {

			return new Skill();
		}
		SkillDAO dao = new SkillDAO();
		Skill resposta = dao.lerSkills(idSkill);

		if (resposta.getId() == 0) {
			dao.fecharBanco();
			return new Skill();
		}
		dao.fecharBanco();
		return resposta;
	}

	/**
	 * Método que valida os dados para atualizar uma Skill
	 * 
	 * @param id        ID da Skill a ser pesquisada
	 * @param descricao Descrição da Skill a ser modificada
	 * @return Retorna uma String "Dados atualizados"
	 * @author Gabriel
	 */
	public static String atualizarSkill(int id, String descricao) throws Exception {

		if (id < 1) {
			return "ID não pode ser menor que 1";
		}

		if (descricao.equals(null)) {
			return "Cargo invalido";
		}

		SkillDAO dao = new SkillDAO();
		Skill func = dao.lerSkills(id);
		if (func.getId() == 0) {
			dao.fecharBanco();
			return "Esse ID nÃo existe";
		}
		dao.updateSkill(id, descricao);
		dao.fecharBanco();
		return "Dados atualizados";
	}

}
