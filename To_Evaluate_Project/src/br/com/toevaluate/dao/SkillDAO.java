package br.com.toevaluate.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import br.com.toevaluate.beans.Skill;
import br.com.toevaluate.conexao.Conexao;



/**
 * Nesta classe manipularemos a tabela T_TOEVALU_SKILLS, onde encontramos como 
 * chave primária a coluna ID_SKILL, e como colunas obrigatorias NM_SKILL e NM_DESCRICAO.
 * Criamos três atributos para armazenar os componentes do JDBC.
 * Na versão 3.0 foi alterado os métodos para atender o novo beans e as novas tabelas do banco de dados.
 * @author Gabriel Carvalho
 * @version 3.0 
 * @since 1.0
 * @see br.com.challenge.beans.Skill
 * @see br.com.projeto.bo.SkillBO
 */
public class SkillDAO {
	private Connection conect = Conexao.conectar();
	private PreparedStatement state;
	private ResultSet result;
	
	/**
	 * Método responsável pela conexão com o Banco de Dados
	 * @author Gabriel Carvalho
	 * @throws Exception
	 * @version 2.0
	 */
	public SkillDAO() throws Exception {
	}
	
	
	/**
	 * Método responsável que fecha a conexão com o Banco de Dados
	 * @author Gabriel
	 * @throws Exception
	 * @Version 2.0
	 */
	public void fecharBanco() throws Exception {
		this.conect.close();
	}
	
	/**
	 * Método para criar uma nova Skill com seus dados
	 * @param skill a ser intanciada e criada
	 * @return Retorna a quantidade de Skills criadas 
	 * @author Gabriel Carvalho
	 * @throws Exception
	 */
	public int adicionarSkill(Skill skill) throws Exception {
		String sql = "SELECT SQ_TOEVALU_SKILL.NEXTVAL AS ID FROM DUAL";
		state = conect.prepareStatement(sql);
		result = state.executeQuery();
		int id = 0;
		
		if (result.next()) {
			id = result.getInt("ID");
		}
		skill.setId(id);
		this.state = this.conect.prepareStatement("INSERT INTO T_TOEVALU_SKILLS (NM_SKILL, NM_DESCRICAO, ID_SKILL) VALUES(?,?,?)");
		this.state.setString(1, skill.getNome());
		this.state.setString(2, skill.getDescricao());
		this.state.setInt(3, skill.getId());
		addAnalistSkill(skill);
		
		return this.state.executeUpdate();
	}
	
	public int addAnalistSkill(Skill skill) throws Exception {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
		state = conect.prepareStatement("INSERT INTO T_TOEVALU_ANALISTA_SKILL (ID_ANALIST_SKILL, ID_FUNC_SKILL, ID_SKILL, DT_INICIO VALUES(SQ_TOEVALU_ANALIST_SKILL, ?,?,?))");
		state.setInt(1, skill.getAnalista().getId());
		state.setInt(2, skill.getId());
		state.setDate(3, Date.valueOf(formatarDate.format(data)));
		
		return state.executeUpdate();
	}
	
	/**
	 * Método UPDATE para modificar a Descrição de uma Skill
	 * @param id ID da skill a ser consultada
	 * @param descricao Descricao da Skill a ser modificada
	 * @return Retorna a quantidade de Descrições modificadas 
	 * @author Gabriel
	 */
	public int updateSkill(int id, String descricao) throws Exception {
		this.state = this.conect.prepareStatement("UPDATE T_TOEVALU_SKILLS SET NM_DESCRICAO = ? WHERE ID_SKILL=?");
		this.state.setString(1, descricao);
		this.state.setInt(2, id);
		return this.state.executeUpdate();
	}
	
	/**
	 * Método DELETE para deletar um Skill
	 * @param id ID da Skill a ser deletada
	 * @return Retorna a quantidade de Skills deletadas 
	 * @author Gabriel
	 */
	public int deleteSkill(int id) throws Exception {
		this.state = this.conect.prepareStatement("DELETE FROM T_TOEVALU_SKILLS WHERE ID_SKILL=?");
		this.state.setInt(1, id);
		return this.state.executeUpdate();
	}
	
	/**
	 * Método READ para pesquisar e retornar os daddos de uma Skill
	 * @param id ID da Skill a ser consultada
	 * @return Retorna uma Skill e seus dados relacionados 
	 * @author Gabriel
	 */
	public Skill lerSkills(int id) throws Exception {
		state = conect.prepareStatement("SELECT * FROM T_TOEVALU_SKILLS WHERE ID_SKILL=?");
		state.setInt(1, id);
		result = state.executeQuery();
		while (result.next()) {
			return
			 new Skill(result.getInt("ID_SKILL"),
					result.getString("NM_SKILL"),
				result.getString("NM_DESCRICAO"),
				null);		
		}
		return new Skill();
	}
	
}