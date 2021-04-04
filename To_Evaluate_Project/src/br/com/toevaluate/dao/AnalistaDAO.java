package br.com.toevaluate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Avaliacao;
import br.com.toevaluate.beans.Lider;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Skill;
import br.com.toevaluate.beans.Usuario;
import br.com.toevaluate.conexao.Conexao;



/**
 * Classe que contém os CRUD do Analista do projeto.
 * 
 * @author Emily Vasconcelos
 * @version 2.0
 */

public class AnalistaDAO {

	private Connection conect = Conexao.conectar();
	private PreparedStatement state;
	private ResultSet result;
	private Login login;

	
	/**
	 * Método para Conectar ao Banco de Dados
	 * 
	 * @author Gabriel Carvalho
	 * 
	 */
	public AnalistaDAO() throws Exception {
	}

	/**
	 * Método para Fechar a conexão com o Banco de Dados
	 * 
	 * @author Gabriel Carvalho
	 * 
	 */
	public void fecharBanco() throws Exception {
		conect.close();
	}

	/**
	 * Método CREATE para criação de um Analista
	 * 
	 * @param analista a ser criado
	 * @return A quantidade de objetos criados
	 * @author Emily Vasconcelos
	 */
	public void adicionarAnalista(Analista analista, Login login) throws Exception {
		String sql = "SELECT SQ_TOEVALU_FUNC.NEXTVAL AS ID FROM DUAL";
		state = conect.prepareStatement(sql);
		result = state.executeQuery();
		int id = 0;
		if (result.next())
			id = result.getInt("ID");
		analista.setId(id);

		state = conect
				.prepareStatement("INSERT INTO T_TOEVALU_FUNCIONARIO (ID_FUNCIONARIO,NM_FUNCIONARIO,DT_NASCIMENTO,"
						+ "NM_DEPARTAMENTO,NM_CARGO,ST_FUNCIONARIO,ST_LIDER) " + "VALUES (?,?,?,?,?,'ATIVO','NAO')");
		state.setInt(1, analista.getId());
		state.setString(2, analista.getNome());
		state.setDate(3, Date.valueOf(analista.getDt_nasc()));
		state.setString(4, analista.getDepartamento());
		state.setString(5, analista.getCargo());

		state.executeUpdate();
		
		state = conect.prepareStatement("SELECT SQ_TOEVALU_FUNC.CURRVAL AS ID FROM DUAL");
		result = state.executeQuery();
		int idLogin = 0;
		if (result.next())
			idLogin = result.getInt("ID");
		login.setId(idLogin);
		System.out.println("LOGIN" + id);
		
		new LoginDAO().add(analista, null, null, login);
		adicionarFuncLider(analista);

	}

	public int adicionarFuncLider(Analista analista) throws Exception {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
		state = conect
				.prepareStatement("INSERT INTO T_TOEVALU_FUNC_LIDER (ID_LIDER_FUNC_SEQ, ID_FUNCIONARIO, ID_FUNC_LIDER,"
						+ " DT_INICIO) VALUES (SQ_TOEVALU_FUNC_LIDER.NEXTVAL, ?, ?,?)");

		state.setInt(1, analista.getId());
		state.setInt(2, analista.getLider().getId());
		state.setDate(3, Date.valueOf(formatarDate.format(data)));
		return state.executeUpdate();
	}

	/**
	 * Método UPDATE para modificar o cargo de um Analista
	 * 
	 * @param id    ID do Analista a ser pesquisado
	 * @param cargo Cargo a ser modificado
	 * @return A quantidade de cargos modificados
	 * @author Emily Vasconcelos
	 */
	public int updateAnalista(int id, String cargo) throws Exception {
		this.state = this.conect
				.prepareStatement("UPDATE T_TOEVALU_FUNCIONARIO SET NM_CARGO = ? WHERE ID_FUNCIONARIO = ?");
		this.state.setString(1, cargo);
		this.state.setInt(2, id);
		return this.state.executeUpdate();
	}

	/**
	 * Método DELETE para deletar um Analista
	 * 
	 * @param id ID do Analista a ser deletado
	 * @return A quantidade de Analistas deletados
	 * @author Emily Vasconcelos
	 */
	public int deleteAnalista(int id) throws Exception {
		this.state = this.conect.prepareStatement("DELETE FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO = ?");
		this.state.setInt(1, id);
		return this.state.executeUpdate();
	}

	/**
	 * Método READ para consultar os dados de um Analista
	 * 
	 * @param id ID do Analista a ser pesquisado
	 * @return A um Analista com seus dados
	 * @author Emily Vasconcelos
	 */

	public Analista ler(int id) throws Exception {
        String banco = "SELECT T_TOEVALU_FUNC_LIDER.ID_FUNC_LIDER AS ID FROM"
                + " T_TOEVALU_FUNC_LIDER INNER JOIN T_TOEVALU_FUNCIONARIO "
                + "ON (T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = T_TOEVALU_FUNC_LIDER.ID_FUNCIONARIO) "
                + "WHERE T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO = ?";
        state = conect.prepareStatement(banco);
        state.setInt(1, id);
        result = state.executeQuery();
        int idLider = 0;
        if (result.next())
            idLider = result.getInt("ID");
        Lider lider = new LiderDAO().lerLider(idLider);
        lider.setId(idLider);
        state = conect
                .prepareStatement("SELECT * FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO = ? AND ST_LIDER = 'NAO'");
        state.setInt(1, id);
        result = state.executeQuery();
        if (result.next()) {
            return new Analista(result.getInt("ID_FUNCIONARIO"), result.getString("NM_FUNCIONARIO"),
                    result.getString("NM_CARGO"), result.getString("NM_DEPARTAMENTO"), result.getString("ST_LIDER"),
                    result.getDate("DT_NASCIMENTO").toLocalDate(), null, result.getString("ST_FUNCIONARIO"), null,
                    new LiderDAO().lerLider(idLider), null);
        }
        return new Analista();
    }

	/**
	 * Método de Auto-avaliação do Analista
	 * 
	 * @param id a ser consultado
	 * @return A quantidade de Notas e seus valores respectivos
	 * @author Emily Vasconcelos
	 */
	public void autoAvaliar(int id, Skill skill, Avaliacao nota) throws Exception {
		state = conect.prepareStatement(
				"SELECT * FROM T_TOEVALU_SKILLS INNER JOIN T_TOEVALU_FUNCIONARIO ON T_TOEVALU_FUNCIONARIO.ID_FUNCIONARIO=?");
		state.setInt(1, id);
		state.executeQuery();
		result = state.executeQuery();
		while (result.next()) {
			boolean cond = true;
			while (cond) {
				nota.setNotaAnalista(Integer.parseInt(JOptionPane.showInputDialog("Digite a nota para a Skill: \n"
						+ result.getString("NM_SKILL") + " de ID: " + result.getInt("ID_SKILL"))));
				if (nota.getNotaAnalista() < 1 || nota.getNotaAnalista() > 10) {
					// System.out.println("Nota inválida");
					cond = true;
				} else {
					this.state = this.conect
							.prepareStatement("UPDATE T_TOEVALU_AVAL_FUNC SET NR_NOTA_ANALIST = ? WHERE NM_SKILL = ?");
					this.state.setDouble(1, nota.getNotaAnalista());
					this.state.setString(2, result.getString("NM_SKILL"));
					this.state.executeUpdate();
					cond = false;
				}
			}

		}

	}

	public List<Usuario> listar() throws Exception {
		state = conect.prepareStatement("SELECT * FROM T_TOEVALU_FUNCIONARIO WHERE ST_LIDER = 'NAO' AND NOT NM_DEPARTAMENTO = 'rh' OR NM_DEPARTAMENTO = 'RH' ORDER BY ID_FUNCIONARIO");
		result = state.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();
		while (result.next()) {
			lista.add(new Analista(result.getInt("ID_FUNCIONARIO"), result.getString("NM_FUNCIONARIO"),
					result.getString("NM_CARGO"), result.getString("NM_DEPARTAMENTO"), result.getString("ST_LIDER"),
					result.getDate("DT_NASCIMENTO").toLocalDate(), null, result.getString("ST_FUNCIONARIO")));
		}

		return lista;
	}	
	
	
}
