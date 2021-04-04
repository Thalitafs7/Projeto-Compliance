package br.com.toevaluate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import br.com.toevaluate.beans.Avaliacao;
import br.com.toevaluate.beans.Lider;
import br.com.toevaluate.beans.Skill;
import br.com.toevaluate.conexao.Conexao;


/**
 * Classe respons�vel pelos CRUD de Avalia��o do projeto
 * 
 * @author Gabriel Lucas
 * @version 2.0
 */
public class AvaliacaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Conecta ao banco de dados
	 * 
	 * @author Gabriel Lucas
	 */
	public AvaliacaoDAO() throws Exception {
		con = Conexao.conectar();
	}

	/**
	 * M�todo que finaliza a conex�o com o banco de dados
	 * 
	 * @author Gabriel Lucas
	 */
	public void fechar() throws Exception {
		con.close();
	}

	/**
	 * M�todo CREATE para cria��o de uma Avalia��o
	 * 
	 * @param aval Uma Avalia��o a ser criada
	 * @return A quantidade de Avalia��es criadas
	 * @author Gabriel Lucas
	 */

//	REVISAR ESSE ADD
	public void add(Avaliacao aval) throws Exception {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");

		String sql = "SELECT SQ_TOEVALU_AVALIACAO.NEXTVAL AS ID FROM DUAL";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		int id = 0;
		if (rs.next())
			id = rs.getInt("ID");
		aval.setId(id);

		String banco = "SELECT T_TOEVALU_FUNC_LIDER.ID_FUNC_LIDER AS ID FROM"
				+ " T_TOEVALU_FUNC_LIDER INNER JOIN T_TOEVALU_FUNCIONARIO "
				+ "ON (T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = T_TOEVALU_FUNC_LIDER.ID_FUNCIONARIO) "
				+ "WHERE T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = ?";
		stmt = con.prepareStatement(banco);
		stmt.setInt(1, aval.getAnalista().getId());

		rs = stmt.executeQuery();
		int idLider = 0;
		if (rs.next())
			idLider = rs.getInt("ID");
		Lider lider = new LiderDAO().lerLider(idLider);
		aval.setLider(lider);

		stmt = con.prepareStatement(
				"INSERT INTO T_TOEVALU_AVALIACAO (ID_AVALIACAO,ID_FUNC_LIDER,DT_ATUAL,DT_AVALIACAO) VALUES (?,?,?,?)");
		stmt.setInt(1, aval.getId());
		stmt.setInt(2, aval.getLider().getId());
		stmt.setDate(3, Date.valueOf(formatarDate.format(data)));
		stmt.setDate(4, Date.valueOf(aval.getDataLimite()));
		stmt.executeUpdate();
		addAvalFunc(aval);
	}

	public void addAvalFunc(Avaliacao aval) throws Exception {
		String sql = "SELECT DISTINCT T_TOEVALU_ANALISTA_SKILL.ID_ANALIST_SKILL "
				+ "AS ID FROM T_TOEVALU_ANALISTA_SKILL  INNER JOIN T_TOEVALU_AVAL_FUNC "
				+ "ON (T_TOEVALU_AVAL_FUNC.ID_FUNC_SKILL = T_TOEVALU_ANALISTA_SKILL.ID_FUNC_SKILL) "
				+ "WHERE T_TOEVALU_AVAL_FUNC.ID_FUNC_SKILL = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, aval.getAnalista().getId());

		rs = stmt.executeQuery();
		while (rs.next()) {
			int id = 0;
			id = rs.getInt("ID");
			Skill skill = new SkillDAO().lerSkills(id);
			aval.setSkill(skill);
			stmt = con.prepareStatement("INSERT INTO T_TOEVALU_AVAL_FUNC (ID_AVAL_FUNC, "
					+ "ID_FUNC_SKILL, ID_ANALIST_SKILL, ID_FUNC_LIDER, ID_AVALIACAO) "
					+ "VALUES (SQ_TOEVALU_AVAL_FUNC.NEXTVAL, ?, ?, ?, ?)");
			this.stmt.setInt(1, aval.getAnalista().getId());
			this.stmt.setInt(2, aval.getSkill().getId());
			this.stmt.setInt(3, aval.getLider().getId());
			this.stmt.setInt(4, aval.getId());
			stmt.executeUpdate();
		}

	}

	/**
	 * M�todo DELETE para deletar uma Avalia��o cadastrada
	 * 
	 * @param id ID da Avali��o a ser deletada
	 * @return A quantidade de Avalia��es Deletadas
	 * @author Gabriel Lucas
	 */
	public int delete(int id) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_TOEVALU_AVALIACAO WHERE ID_AVALIACAO = ?");
		stmt.setInt(1, id);

		return stmt.executeUpdate();
	}

	/**
	 * M�todo UPDATE para modifica��o da data da Avalia��o
	 * 
	 * @param aval Avalia��o a ser modificada
	 * @return A quantidade de Avalia��es modificadas
	 * @author Gabriel Lucas
	 */
	public int update(int id, LocalDate data) throws Exception {
		stmt = con.prepareStatement("UPDATE T_TOEVALU_AVALIACAO " + "SET DT_AVALIACAO=? " + "WHERE ID_AVALIACAO=?");

		stmt.setDate(1, Date.valueOf(data));
		stmt.setInt(2, id);
		return stmt.executeUpdate();
	}

	/**
	 * M�todo READ para pesquisar uma Avalia��o e retorna seus dados
	 * 
	 * @param id_avaliacao ID da Avalia��o a ser pesquisado
	 * @return Retorna os dados da Avalia��o
	 * @author Gabriel Lucas
	 */
	public Avaliacao read(int id_avaliacao) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_TOEVALU_AVALIACAO WHERE ID_AVALIACAO=?");
		stmt.setInt(1, id_avaliacao);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return new Avaliacao(rs.getInt("ID_AVALIACAO"), rs.getDouble("NR_NOTA_LIDER"), rs.getDouble("NR_NOTA_FUNC"),
					rs.getDate("DT_AVALIACAO").toLocalDate(), rs.getDate("DT_INICIO").toLocalDate(), null, null, null);
//			System.out.println("\n\nID Avalia��o: " + rs.getInt("ID_AVALIACAO") + "\nNome Funcionario: "
//					+ rs.getNString("NM_FUNCIONARIO") + "\nID do funcion�rio: " + rs.getInt("ID_FUNCIONARIO")
//					+ "\nSkills: " + rs.getNString("NM_SKILL") + "\nData da avalia��o: "
//					+ rs.getDate("DT_AVALIACAO").toLocalDate().format(formatter));

		}
		return new Avaliacao();
	}
}