package br.com.toevaluate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Lider;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Rh;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.conexao.Conexao;

/**
 * Classe que contém os CRUD de Login do projeto
 * 
 * @author Mateus Ramos Martins
 * @version 2.0
 */
public class LoginDAO {
	private Connection con = Conexao.conectar();
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Conecta ao banco de dados
	 * 
	 * @author Mateus Ramos Martins
	 */
	public LoginDAO() throws Exception {
	}

	/**
	 * Finaliza a conexão com o banco de dados
	 * 
	 * @author Mateus Ramos Martins
	 */
	public void fechar() throws Exception {
		con.close();
	}

	/**
	 * Método CREATE para Adicionar os dados de um Login
	 * 
	 * @param login a ser instanciado
	 * @return A quantidade de Logins criados
	 * @author Mateus Ramos Martins
	 */
	public int add(Analista analista, Lider lider, Rh rh, Login login) throws Exception {

		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");

		if (lider == null && rh == null) {
			stmt = con.prepareStatement(
					"INSERT INTO T_TOEVALU_LOGIN (NM_EMAIL, NM_SENHA, ID_LOGIN, DT_INICIO, ID_FUNCIONARIO)\n"
							+ "VALUES (?, ?, ?, ?, ?)");

			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getSenha());
			stmt.setInt(3, login.getId());
			stmt.setDate(4, Date.valueOf(formatarDate.format(data)));
			stmt.setInt(5, analista.getId());
			return stmt.executeUpdate();

		} else if (analista == null && rh == null) {
			stmt = con.prepareStatement(
					"INSERT INTO T_TOEVALU_LOGIN (NM_EMAIL, NM_SENHA, ID_LOGIN, DT_INICIO, ID_FUNCIONARIO)\n"
							+ "VALUES (?, ?, SQ_TOEVALU_LOGIN.NEXTVAL, ?, ?)");

			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getSenha());
			stmt.setDate(3, Date.valueOf(formatarDate.format(data)));
			stmt.setInt(4, lider.getId());
			return stmt.executeUpdate();

		} else {
			stmt = con.prepareStatement(
					"INSERT INTO T_TOEVALU_LOGIN (NM_EMAIL, NM_SENHA, ID_LOGIN, DT_INICIO, ID_FUNCIONARIO)\n"
							+ "VALUES (?, ?, SQ_TOEVALU_LOGIN.NEXTVAL, ?, ?)");

			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getSenha());
			stmt.setDate(3, Date.valueOf(formatarDate.format(data)));
			stmt.setInt(4, rh.getId());
			return stmt.executeUpdate();
		}

	}

	/**
	 * Método DELETE que deleta um Usuário pelo ID
	 * 
	 * @param idUser a ser Deletado
	 * @return A quantidade de ID do usuario deletados
	 * @author Mateus Ramos Martins
	 */
	public int deletar(int idUser) throws Exception {
		this.stmt = this.con.prepareStatement("DELETE FROM T_TOEVALU_LOGIN WHERE ID_LOGIN=?");
		this.stmt.setInt(1, idUser);
		return stmt.executeUpdate();
	}

	/**
	 * Método UPDATE que modifica a senha do usuario
	 * 
	 * @param idUser ID do Usuário a ser pesquisado
	 * @param senha  Senha do Usuário a ser modificado
	 * @return A quantidade de Senhas alteradas
	 * @author Mateus Ramos Martins
	 */
	public int updateLogin(Login login, int id) throws Exception {
		this.stmt = this.con.prepareStatement("UPDATE T_TOEVALU_LOGIN "
				+ "SET NM_EMAIL = ?, NM_SENHA = ? WHERE ID_FUNCIONARIO = ?");
		this.stmt.setString(1, login.getEmail());
		this.stmt.setString(2,  login.getSenha());
		this.stmt.setInt(3, id);

		return this.stmt.executeUpdate();
	}

	/**
	 * Método READ que retorna os dados do Login
	 * 
	 * @param idUser ID do Usuário a ser consulatado
	 * @return Retorna um Login com seus dados relacionados
	 * @author Mateus Ramos Martins
	 */

	public Login ler(int id) throws Exception {

		stmt = con.prepareStatement("SELECT * FROM T_TOEVALU_LOGIN WHERE ID_FUNCIONARIO = ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if (rs.next()) {
			System.out.println(rs.getDate("DT_FINAL"));
			
			return new Login(rs.getString("NM_EMAIL"), rs.getString("NM_SENHA"), rs.getInt("ID_LOGIN"),
					new AnalistaDAO().ler(id), new LiderDAO().lerLider(id), new RhDAO().read(id),
					rs.getDate("DT_INICIO").toLocalDate(), null);
		}
		return new Login();

	}

	/**
	 * Método de Efetuar o Login do Usuário
	 * 
	 * @param email Email informado pelo Usuário
	 * @param senha Senha informado pelo Usuário
	 * @return Retorna uma String "Login realizado com sucesso!"
	 * @author Mateus Ramos Martins
	 */
	public Login efetuarLogin(Login login) throws Exception {
		String sqlL = "SELECT ID_LOGIN AS ID FROM T_TOEVALU_LOGIN WHERE NM_EMAIL = ? AND NM_SENHA = ?";
		stmt = con.prepareStatement(sqlL);
		stmt.setString(1, login.getEmail());
		stmt.setString(2, login.getSenha());
		rs = stmt.executeQuery();
		int idL = 0;
		if (rs.next())
			idL = rs.getInt("ID");
		login.setId(idL);

		String sql = "SELECT ST_LIDER,NM_DEPARTAMENTO " + "FROM T_TOEVALU_FUNCIONARIO  INNER JOIN T_TOEVALU_LOGIN "
				+ "ON T_TOEVALU_LOGIN.ID_FUNCIONARIO = T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO "
				+ "WHERE NM_EMAIL = ? AND NM_SENHA = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, login.getEmail());
		stmt.setString(2, login.getSenha());
		rs = stmt.executeQuery();
		if (rs.next()) {
			if (rs.getString("ST_LIDER").equals("SIM")) {

				String sqlLider = "SELECT ID_FUNCIONARIO AS ID FROM T_TOEVALU_LOGIN WHERE NM_EMAIL = ? AND NM_SENHA = ?";
				stmt = con.prepareStatement(sqlLider);
				stmt.setString(1, login.getEmail());
				stmt.setString(2, login.getSenha());
				rs = stmt.executeQuery();
				int id = 0;
				if (rs.next())
					id = rs.getInt("ID");
				Lider lider = new LiderDAO().lerLider(id);
				login.setLider(lider);
				stmt = con.prepareStatement(
						"SELECT * FROM T_TOEVALU_FUNCIONARIO INNER JOIN T_TOEVALU_LOGIN ON T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = T_TOEVALU_LOGIN.ID_FUNCIONARIO WHERE NM_EMAIL=? AND NM_SENHA =?");
				stmt.setString(1, login.getEmail());
				stmt.setString(2, login.getSenha());
				rs = stmt.executeQuery();

				if (rs.next()) {
					return new Login(rs.getString("NM_EMAIL"), rs.getString("NM_SENHA"), rs.getInt("ID_LOGIN"), null,
							new LiderDAO().lerLider(id), null, rs.getDate("DT_INICIO").toLocalDate(), null);
				}

			}

			if (rs.getString("ST_LIDER").equals("NÃO")) {
				String sqlAnalista = "SELECT ID_FUNCIONARIO AS ID FROM T_TOEVALU_LOGIN WHERE NM_EMAIL = ? AND NM_SENHA = ?";
				stmt = con.prepareStatement(sqlAnalista);
				stmt.setString(1, login.getEmail());
				stmt.setString(2, login.getSenha());
				rs = stmt.executeQuery();
				int id = 0;
				if (rs.next())
					id = rs.getInt("ID");
				Analista analista = new AnalistaDAO().ler(id);
				login.setAnalista(analista);
				stmt = con.prepareStatement(
						"SELECT * FROM T_TOEVALU_FUNCIONARIO INNER JOIN T_TOEVALU_LOGIN ON T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = T_TOEVALU_LOGIN.ID_FUNCIONARIO WHERE NM_EMAIL=? AND NM_SENHA =?");
				stmt.setString(1, login.getEmail());
				stmt.setString(2, login.getSenha());
				rs = stmt.executeQuery();

				if (rs.next()) {
					return new Login(rs.getString("NM_EMAIL"), rs.getString("NM_SENHA"), rs.getInt("ID_LOGIN"), null,
							new LiderDAO().lerLider(id), null, rs.getDate("DT_INICIO").toLocalDate(), null);
				}
			}

			if (rs.getString("NM_DEPARTAMENTO").equals("Recursos Humanos")
					|| rs.getString("NM_DEPARTAMENTO").equals("Recursos Humanos".toUpperCase())
					|| rs.getString("NM_DEPARTAMENTO").equals("Rh")
					|| rs.getString("NM_DEPARTAMENTO").equals("Rh".toUpperCase())) {
				String sqlRh = "SELECT ID_FUNCIONARIO AS ID FROM T_TOEVALU_LOGIN WHERE NM_EMAIL = ? AND NM_SENHA = ?";
				stmt = con.prepareStatement(sqlRh);
				stmt.setString(1, login.getEmail());
				stmt.setString(2, login.getSenha());
				rs = stmt.executeQuery();
				int id = 0;
				if (rs.next())
					id = rs.getInt("ID");
				Rh rh = new RhDAO().read(id);
				login.setRh(rh);
				stmt = con.prepareStatement(
						"SELECT * FROM T_TOEVALU_FUNCIONARIO INNER JOIN T_TOEVALU_LOGIN ON T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = T_TOEVALU_LOGIN.ID_FUNCIONARIO WHERE NM_EMAIL=? AND NM_SENHA =?");
				stmt.setString(1, login.getEmail());
				stmt.setString(2, login.getSenha());
				rs = stmt.executeQuery();

				if (rs.next()) {
					return new Login(rs.getString("NM_EMAIL"), rs.getString("NM_SENHA"), rs.getInt("ID_LOGIN"), null,
							new LiderDAO().lerLider(id), null, rs.getDate("DT_INICIO").toLocalDate(), null);
				}
			}

		}

		return new Login();

	}

	/**
	 * Métod para efetuar o Desligamento de um Funcionário
	 * 
	 * @param id      ID do Usuário a ser pesquisado
	 * @param dtFinal Data Final do Login do Usuário
	 * @return A quanridade de Funcionários Desligados
	 * @author Mateus Ramos Martins
	 */
	public int desligamentoFuncionario(int id, String dtFinal) throws Exception {
		stmt = con.prepareStatement("UPDATE T_TOEVALU_LOGIN SET DT_FIM = TO_DATE(?, 'DD/MM/YYYY') WHERE ID_USER = ?");
		stmt.setString(1, dtFinal);
		stmt.setInt(2, id);
		return stmt.executeUpdate();
	}

}
