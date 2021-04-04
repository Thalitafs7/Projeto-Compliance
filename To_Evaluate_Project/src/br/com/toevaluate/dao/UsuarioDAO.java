package br.com.toevaluate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.conexao.Conexao;



/**
 * Classe que cont�m os CRUD do Funcion�rio do projeto.
 * 
 * @author Gabriel Carvalho
 * @version 2.0
 */
public class UsuarioDAO {

	private Connection conect;
	private PreparedStatement state;
	private ResultSet result;

	/**
	 * Conecta ao banco de dados
	 * 
	 * @author Gabriel Carvalho
	 */
	public UsuarioDAO() throws Exception {
		conect = Conexao.conectar();
	}

	/**
	 * M�todo que finaliza a conex�o com o banco de dados
	 * 
	 * @author Gabriel Carvalho
	 */
	public void fecharBanco() throws Exception {
		conect.close();
	}

	/**
	 * M�todo CREATE para cria��o de um Funcion�rio
	 * 
	 * @param funcionario a ser criado
	 * @return A quantidade de Funcion�rios criados
	 * @author Gabriel Carvalho
	 */
	public int adicionarFunci(Usuario func) throws Exception {
		state = conect.prepareStatement(
				"INSERT INTO T_TOEVALU_FUNCIONARIO (ID_FUNCIONARIO, NM_FUNCIONARIO,NM_CARGO, NM_DEPARTAMENTO, ST_FUNCIONARIO, DT_NASCIMENTO) VALUES(?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY'))");

		state.setInt(1, func.getId());
		state.setString(2, func.getNome());
		state.setString(3, func.getCargo());
		state.setString(4, func.getDepartamento());
		state.setString(5, func.getStatus());
		state.setDate(6, Date.valueOf(func.getDt_nasc()));

		return state.executeUpdate();
	}

	/**
	 * M�todo UPDATE para modifica��o do status dos Funcion�rio
	 * 
	 * @param status Status a ser modificado
	 * @param id     ID do Funcion�rio a ser pesquisado
	 * @return A quantidade de Funcion�rio modificados
	 * @author Gabriel Carvalho
	 */
	public int updateStatus(String status, int id) throws Exception {
		state = conect.prepareStatement("UPDATE T_TOEVALU_FUNCIONARIO SET ST_FUNCIONARIO = ? WHERE ID_FUNCIONARIO = ?");
		state.setString(1, status);
		state.setInt(2, id);
		return state.executeUpdate();
	}

	/**
	 * M�todo DELETE para deletar um Funcion�rio cadastrado
	 * 
	 * @param idFunc ID do Funcion�rio que ser� Deletado
	 * @return A quantidade de Funcion�rio Deletados
	 * @author Gabriel Carvalho
	 */
	public int deleteFunci(int idFunc) throws Exception {
		state = conect.prepareStatement("DELETE FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO=?");
		state.setInt(1, idFunc);
		return state.executeUpdate();
	}

	/**
	 * M�todo READ para pesquisar um Funcion�rio e retorna seus dados
	 * 
	 * @param id ID do Funcion�rio a ser pesquisado
	 * @return Retorna os dados do Funcion�rio
	 * @author Gabriel Carvalho
	 */
	public Usuario lerFunc(int id) throws Exception {
		state = conect.prepareStatement(
				"SELECT * FROM T_TOEVALU_FUNCIONARIO INNER JOIN T_TOEVALU_TELEFONE ON T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = T_TOEVALU_TELEFONE.ID_FUNCIONARIO WHERE ID_FUNCIONARIO=?");
		state.setInt(1, id);
		result = state.executeQuery();

		if (result.next()) {
			return new Usuario(result.getInt("ID_FUNCIONARIO"), result.getString("NM_FUNCIONARIO"),
					result.getString("NM_CARGO"), result.getString("NM_DEPARTAMENTO"), result.getString("ST_LIDER"),
					result.getDate("DT_NASCIMENTO").toLocalDate(), null, null);
		}
		return new Usuario();

	}
	
	public List<Usuario> listar() throws Exception {
		state = conect.prepareStatement("SELECT * FROM T_TOEVALU_FUNCIONARIO ORDER BY ID_FUNCIONARIO");
		result = state.executeQuery();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		while (result.next()) {
			listaUsuario.add(new Analista(result.getInt("ID_FUNCIONARIO"), result.getString("NM_FUNCIONARIO"),
					result.getString("NM_CARGO"), result.getString("NM_DEPARTAMENTO"), result.getString("ST_LIDER"),
					result.getDate("DT_NASCIMENTO").toLocalDate(), null, result.getString("ST_FUNCIONARIO")));
		}

		return listaUsuario;
	}
	
	
}
