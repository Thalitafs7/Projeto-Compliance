package br.com.toevaluate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Rh;
import br.com.toevaluate.conexao.Conexao;

/**
 * Classe que contém as validações dos dados de Login do projeto.
 * 
 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
 * @version 2.0
 */
public class RhDAO {

	private Connection conect;
	private PreparedStatement state;
	private ResultSet rs;

	/**
	 * Método que realiza a conexão com o Banco de Dados
	 * 
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public RhDAO() throws Exception {
		conect = Conexao.conectar();

	}

	/**
	 * Método que finaliza a conexão com o Banco de Dados
	 * 
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public void fechar() throws Exception {
		conect.close();

	}

	/**
	 * Método que valida os dados para Adiocionar Funcionarios
	 * 
	 * @param rh a ser instanciado
	 * @return A quantidade de RH criados
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public int addRh(Rh rh, Login login) throws Exception {
		String sql = "SELECT SQ_TOEVALU_FUNC.NEXTVAL AS ID FROM DUAL";
		state = conect.prepareStatement(sql);
		rs = state.executeQuery();
		int id = 0;
		if (rs.next())
			id = rs.getInt("ID");
		rh.setId(id);

		state = conect
				.prepareStatement("INSERT INTO T_TOEVALU_FUNCIONARIO (ID_FUNCIONARIO,NM_FUNCIONARIO,DT_NASCIMENTO,"
						+ "NM_DEPARTAMENTO,NM_CARGO,ST_FUNCIONARIO,ST_LIDER) " + "VALUES (?,?,?,?,?,'ATIVO','NAO')");

		this.state.setInt(1, rh.getId());
		this.state.setString(2, rh.getNome());
		this.state.setDate(3, Date.valueOf(rh.getDt_nasc()));
		this.state.setString(4, rh.getDepartamento());
		this.state.setString(5, rh.getCargo());
		int x = state.executeUpdate();
		new LoginDAO().add(null, null, rh, login);
		return x;
	}

	/**
	 * Método que valida os dados para Deletar um Funcionario
	 * 
	 * @param id ID do Funcionario a ser Deletado
	 * @return A quantidade de Funcionários Deletaddos
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public int deleteRh(int id) throws Exception {
		state = conect.prepareStatement("DELETE FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO = ?");
		state.setInt(1, id);
		return state.executeUpdate();
	}

	/**
	 * Método que valida os dados para Moddificar a quantidade de Funcionários
	 * 
	 * @param rh a ser pesquisado
	 * @return A quantidade de Funcionários alterados
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public int updateRh(Rh rh) throws Exception {
		state = conect.prepareStatement("UPDATE T_TOEVALU_FUNCIONARIO "
				+ "SET NM_FUNCIONARIO = ?, DT_NASCIMENTO = ? WHERE ID_FUNCIONARIO = ?");	
		System.out.println(rh.getNome());
		state.setString(1, rh.getNome());
		state.setDate(2, Date.valueOf(rh.getDt_nasc()));
		state.setInt(3, rh.getId());
		
		return state.executeUpdate();
	}

	/**
	 * Método que valida os dados para Consultar os dados do RH
	 * 
	 * @param idRh a ser consultado os dados
	 * @return O RH com seus dados realcionados
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public Rh read(int idRh) throws Exception {
		state = conect.prepareStatement("SELECT * FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO=?");
		state.setInt(1, idRh);
		rs = state.executeQuery();
		if (rs.next()) {
			return new Rh(rs.getInt("ID_FUNCIONARIO"), rs.getString("NM_FUNCIONARIO"), rs.getString("NM_CARGO"),
					rs.getString("NM_DEPARTAMENTO"), rs.getString("ST_LIDER"),
					rs.getDate("DT_NASCIMENTO").toLocalDate(), null, rs.getString("ST_FUNCIONARIO"));

		} else {
			return new Rh();
		}

	}

	/**
	 * Método que verifica as Avaliações feita por Analista e Líder
	 * 
	 * @param id do Funcioanrio a ser pesquisado
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public void verificarAvaliacao(int id) throws Exception {
		SkillDAO dao = new SkillDAO();
		state = conect.prepareStatement(
				"SELECT * FROM T_TOEVALU_SKILL INNER JOIN T_TOVALU_RH ON T_TOEVALU_RH.ID_FUNCIONARIO = ?");
		state.setInt(1, id);
		rs = state.executeQuery();
		while (rs.next()) {
			if (rs.getString("NR_NOTA_ANALIST") == null) {
				dao.fecharBanco();
				// System.out.println("Analista não respondeu a avaliação de " +
				// rs.getString("NM_SKILL"));
			}

			if (rs.getString("NR_NOTA_LIDER") == null) {
				dao.fecharBanco();
				// System.out.println("Lider não respondeu a avaliação de " +
				// rs.getString("NM_SKILL"));
			}
		}
		dao.fecharBanco();

	}

	/**
	 * Método que verifica os Desempenho do Funcionário
	 * 
	 * @param id do Funcioanrio a ser pesquisado
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public void verificarDesempenho(int id) throws Exception {
		SkillDAO dao = new SkillDAO();
		state = conect.prepareStatement(
				"SELECT NR_NOTA_ANALIST, NR_NOTA_LIDER FROM T_TOEVALU_SKILL INNER JOIN T_TOEVALU_RH ON T_TOEVALU_RH.ID_FUNCIONARIO = ?");
		state.setInt(1, id);
		rs = state.executeQuery();
		// SKILLS EXIGIDAS
		// System.out.println("|NOTA ANALISTA: |NOTA LIDER:");
		while (rs.next()) {
			// System.out.println("|" + rs.getInt("NR_NOTA_ANALIST") + " |" +
			// rs.getInt("NR_NOTA_LIDER"));
			dao.fecharBanco();
		}
		state = conect.prepareStatement(
				"SELECT NM_SKILL, NR_NOTA_ANALIST, NR_NOTA_LIDER FROM T_TOEVALU_SKILL INNER JOIN T_TOEVALU_RH ON T_TOEVALU_RH.ID_FUNCIONARIO = ?");
		state.setInt(1, id);
		rs = state.executeQuery();
		while (rs.next()) {
			int diferenca = rs.getInt("NR_NOTA_ANALIST") - rs.getInt("NR_NOTA_LIDER");
			// System.out.println(rs.getString("NM_SKILL") + ": " +
			// rs.getInt("NR_NOTA_ANALIST") + "-"
			// + rs.getInt("NR_NOTA_LIDER") + " = " + diferenca);
			dao.fecharBanco();
		}
		dao.fecharBanco();

	}

	/**
	 * Método que cadastra um Usuário
	 * 
	 * @param login a ser instanciado e criado
	 * @return A quantidade de cadastros feitos
	 * @author Gabriel Lucas, Mateus Ramos, Emily Vasconcelos
	 */
	public int cadastrarUsuario(Login login) throws Exception {
		state = conect.prepareStatement(
				"INSERT INTO T_TOEVALU_LOGIN (NM_EMAIL, NM_SENHA, DT_INICIO, DT_FIM, ID_LOGIN) VALUES (?, ?, TO_DATE(?, 'DD/MM/YYY'), TO_DATE(?, 'DD/MM/YYYY'), T_SQ_TOEVALU_LOGIN.NEXVAL)");
		state.setString(1, login.getEmail());
		state.setString(2, login.getSenha());
		state.setDate(3, Date.valueOf(login.getDtInicio()));
		state.setDate(4, Date.valueOf(login.getDtFim()));

		return state.executeUpdate();

	}

}
