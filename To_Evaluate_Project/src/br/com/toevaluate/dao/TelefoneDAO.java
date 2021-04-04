package br.com.toevaluate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.toevaluate.beans.Telefone;
import br.com.toevaluate.conexao.Conexao;


public class TelefoneDAO {
	private Connection conect;
	private PreparedStatement stmt;
	private ResultSet result;
	
	public TelefoneDAO() throws Exception {
		conect = Conexao.conectar();
	}
	public void fecharBanco() throws Exception {
		conect.close();
	}
	public Telefone read(int id)throws Exception{
		stmt = conect.prepareStatement("SELECT * FROM T_TOEVALU_TELEFONE "
				+ "WHERE ID_FUNCIONARIO = ? ");
		stmt.setInt(1, id);
		result = stmt.executeQuery();
		if (result.next()) {
			return new Telefone(result.getInt("ID_TELEFONE"),
					result.getInt("NR_DDD"),
					result.getInt("NR_NUMERO"));
		}
		return new Telefone();
	}
	public int apagar(int id)throws Exception{
		stmt = conect.prepareStatement("DELETE FROM T_TOEVALU_TELEFONE WHERE ID_FUNCIONARIO = ?");
		stmt.setInt(1, id);
		return stmt.executeUpdate();
	}
	public int inserir(Telefone telefone) throws Exception{		
		String sql = "SELECT SQ_TOEVALU_TELEFONE.NEXTVAL AS ID FROM DUAL";
        stmt = conect.prepareStatement(sql);
        result = stmt.executeQuery();
        int id = 0;
        if (result.next())
            id = result.getInt("ID");
        System.out.println(id);
        
		stmt = conect.prepareStatement("INSERT INTO T_TOEVALU_TELEFONE "
				+ "(ID_TELEFONE, ID_FUNCIONARIO, NR_DDD, NR_NUMERO)  "
				+ "VALUES (?, ?, ?, ?)");
		stmt.setInt(1, id);
		stmt.setInt(2, id);
		stmt.setInt(3, telefone.getDdd());
		stmt.setInt(4, telefone.getNumero());
		return stmt.executeUpdate();
	}
	public int atualizar(Telefone telefone, int idFunc) throws Exception {
		stmt = conect.prepareStatement(
				"UPDATE T_TOEVALU_TELEFONE SET " + "NR_DDD = ?, NR_NUMERO = ? WHERE ID_FUNCIONARIO = ?");
		stmt.setInt(1, telefone.getDdd());
		stmt.setInt(2, telefone.getNumero());
		stmt.setInt(3, idFunc);
		return stmt.executeUpdate();
	}
}
