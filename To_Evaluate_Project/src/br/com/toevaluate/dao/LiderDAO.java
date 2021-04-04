package br.com.toevaluate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Avaliacao;
import br.com.toevaluate.beans.Lider;
import br.com.toevaluate.beans.Login;
import br.com.toevaluate.beans.Skill;
import br.com.toevaluate.conexao.Conexao;


/**
 * Classe respons�vel pelos CRUD de Avalia��o do projeto
 * 
 * @author Thalita Feitosa
 * @version 2.0
 */
public class LiderDAO {
	private Connection conect;
	private PreparedStatement stmt;
	private ResultSet result;

	/**
	 * Conecta ao banco de dados
	 * 
	 * @author Thalita Feitosa
	 */
	public LiderDAO() throws Exception {
		conect = Conexao.conectar();
	}

	/**
	 * M�todo que finaliza a conex�o com o banco de dados
	 * 
	 * @author Thalita Feitosa
	 */
	public void fecharBanco() throws Exception {
		conect.close();
	}

	/**
	 * M�todo CREATE para Adicionar um L�der
	 * 
	 * @param lider a ser criado
	 * @return A quantidade de L�der(es) adicionados
	 * @author Thalita Feitosa
	 */
	public void addEmLider(Lider lider, Login login) throws Exception {
		String sql = "SELECT SQ_TOEVALU_FUNC.NEXTVAL AS ID FROM DUAL";
		stmt = conect.prepareStatement(sql);
		result = stmt.executeQuery();
		int id = 0;
		if (result.next())
			id = result.getInt("ID");
		lider.setIdFuncLider(id);

		stmt = conect
				.prepareStatement("INSERT INTO T_TOEVALU_FUNCIONARIO (ID_FUNCIONARIO,NM_FUNCIONARIO,DT_NASCIMENTO,"
						+ "NM_DEPARTAMENTO,NM_CARGO,ST_FUNCIONARIO,ST_LIDER) " + "VALUES (?,?,?,?,?,'ATIVO','SIM')");
		stmt.setInt(1, lider.getIdFuncLider());
		stmt.setString(2, lider.getNome());
		stmt.setDate(3, Date.valueOf(lider.getDt_nasc()));
		stmt.setString(4, lider.getDepartamento());
		stmt.setString(5, lider.getCargo());

		stmt.executeUpdate();

		stmt = conect.prepareStatement("SELECT SQ_TOEVALU_FUNC.CURRVAL AS ID FROM DUAL");
		result = stmt.executeQuery();
		int idLogin = 0;
		if (result.next())
			idLogin = result.getInt("ID");
		login.setId(idLogin);
		new LoginDAO().add(null, lider, null, login);
	}

	/**
	 * M�todo READ para pesquisar um L�der e retorna seus dados
	 * 
	 * @param id ID do L�der a ser pesquisado
	 * @return Retorna um L�der e seus dados
	 * @author Thalita Feitosa
	 */
	public Lider lerLider(int id) throws Exception {
		stmt = conect.prepareStatement("SELECT * FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO = ?");
		stmt.setInt(1, id);
		result = stmt.executeQuery();
		if (result.next()) {
			return new Lider(result.getInt("ID_FUNCIONARIO"), result.getString("NM_FUNCIONARIO"),
					result.getNString("NM_CARGO"), result.getNString("NM_DEPARTAMENTO"),
					result.getNString("ST_FUNCIONARIO"), result.getDate("DT_NASCIMENTO").toLocalDate(), null,
					result.getString("ST_LIDER"));
		}
		return new Lider();
	}

	/**
	 * M�todo UPDATE para modifica��o dos dados relacionados ao L�der
	 * 
	 * @param id    ID do L�der a ser pesquisado
	 * @param nome  do L�der a ser modificado
	 * @param subor Quantidade de subordinados a ser modificada
	 * @author Thalita Feitosa
	 * @param subor
	 */
	public int updateLider(int id, String situacao) throws Exception {
		stmt = conect.prepareStatement("UPDATE T_TOEVALU_FUNCIONARIO SET ST_FUNCIONARIO = ? WHERE ID_FUNCIONARIO = ?");
		stmt.setString(1, situacao);
		stmt.setInt(2, id);
		return stmt.executeUpdate();

	}

	/**
	 * M�todo DELETE para deletar um L�der cadastrada
	 * 
	 * @param id_func ID do l�der a ser deletada
	 * @author Thalita Feitosa
	 */
	public int delLider(int id_func) throws Exception {
		stmt = conect.prepareStatement("DELETE FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO = ?");
		stmt.setInt(1, id_func);
		return stmt.executeUpdate();
	}

	/**
	 * M�todo do Analista Avaliar um Funcion�rio
	 * 
	 * @param id a ser pesquisado
	 * @return A quantidade de Notas e seus valores respectivamente
	 * @author Thalita Feitosa
	 */
	public int cadastrarAvaliacao(Avaliacao avaliacao, Lider lider) throws Exception {
		stmt = conect.prepareStatement(
				"INSERT INTO T_TOEVALU_AVALIACAO " + "(ID_AVALIACAO, ID_FUNC_LIDER, DT_AVALIACAO, DT_ATUAL)"
						+ " values (SQ_TOEVALU_AVALIACAO.NEXTVAL,?, ?,?)");
		this.stmt.setInt(1, lider.getIdFuncLider());
		this.stmt.setDate(2, Date.valueOf(avaliacao.getDataLimite()));
		this.stmt.setDate(3, Date.valueOf(avaliacao.getDataResposta()));
		return stmt.executeUpdate();
	}
	
	public List<Analista> listaSubordinados(Lider lider)throws Exception{
		ArrayList<Analista> lista = new ArrayList();
		stmt = conect.prepareStatement("SELECT F.ID_FUNCIONARIO, F.NM_FUNCIONARIO, F.NM_CARGO FROM "
				+ "T_TOEVALU_FUNCIONARIO F INNER JOIN T_TOEVALU_FUNC_LIDER L ON "
				+ "L.ID_FUNCIONARIO = F.ID_FUNCIONARIO where l.id_func_lider = ? ORDER BY"
				+ " ID_FUNCIONARIO");
		stmt.setInt(1, lider.getId());
		result = stmt.executeQuery();
		if(result.next()) {
			while (result.next()) {	
				lista.add(new Analista(result.getInt("ID_FUNCIONARIO"),
						result.getString("NM_FUNCIONARIO"),
						result.getNString("NM_CARGO")));
			}
		}
		return lista;
	}
	
	
	public int criarSkill(Skill skill) throws Exception {
		stmt = conect.prepareStatement("INSERT INTO T_TOEVALU_SKILLS values"
				+ " (SQ_TOEVALU_ANALIST_SKILL.NEXTVAL, ?, ?)");
		stmt.setString(1, skill.getNome());
		stmt.setNString(2, skill.getDescricao());
		return this.stmt.executeUpdate();
	}
	//Met�do envia a avalia��o do lider 
	public int enviarNota(Lider lider, int idFunc, int idSkill,int nota)throws Exception{
		stmt = conect.prepareStatement("UPDATE T_TOEVALU_AVAL_FUNC SET NR_NOTA_LIDER = ?"
				+ " WHERE ID_FUNC_LIDER = ? AND ID_FUNC_SKILL = ? AND ID_ANALIST_SKILL = ?");	
		stmt.setInt(1, nota);
		stmt.setInt(2, lider.getIdFuncLider());
		stmt.setInt(3, idFunc);
		stmt.setInt(4, idSkill);
		return stmt.executeUpdate();
	}
	
	//LISTA DE IDS DOS SUBORDIDADOS 
	public List<Integer> idSubordinados(Lider lider)throws Exception{
		List<Analista> lista = new ArrayList<Analista>();
		List<Integer> ids = new ArrayList();
		stmt = conect.prepareStatement("SELECT F.ID_FUNCIONARIO, "
				+ "F.NM_FUNCIONARIO, F.NM_CARGO FROM T_TOEVALU_FUNCIONARIO "
				+ "F INNER JOIN T_TOEVALU_FUNC_LIDER L ON  L.ID_FUNCIONARIO = "
				+ "F.ID_FUNCIONARIO where l.id_func_lider = ? ORDER BY "
				+ "ID_FUNCIONARIO");
		stmt.setInt(1, lider.getIdFuncLider());
		result = stmt.executeQuery();
		while (result.next()) {
			lista.add(new Analista(
					result.getInt("ID_FUNCIONARIO"), 
					null, 
					null));	
		}
		for(Analista d : lista) {
			ids.add(d.getId());
		}
		return ids;
	}
	
	//RETORNA A LISTA DE SUBORDINADOS - USA OS METODOS LER E IDSUBORDINADOS
	public List<Analista> listaDeAnalistas(Lider lider)throws Exception{
		List<Analista> analist = new ArrayList();
		List<Integer> lista = idSubordinados(lider);
		for(int i=0; i<lista.size(); i++) {
			int idSubordinados = lista.get(i);
			analist.add(ler(idSubordinados));
		}
		return analist;
	}
	
	//FAZ O SELECT DE CADA SUBORDINADO 
	public Analista ler(int id)throws Exception{
		stmt = conect.prepareStatement("select ID_FUNCIONARIO, NM_FUNCIONARIO, "
				+ "NM_CARGO FROM T_TOEVALU_FUNCIONARIO WHERE ID_FUNCIONARIO = ?");
		stmt.setInt(1, id);
		result = stmt.executeQuery();
		while (result.next()) {
			return new Analista(
					result.getInt("ID_FUNCIONARIO"), 
					result.getString("NM_FUNCIONARIO"), 
					result.getNString("NM_CARGO"));	
		}
		return new Analista();
	}
	
	//PESQUISAR OS IDS SKILL DE CADA SUBORDINADOS
	public List<Skill> idSkills(Lider lider)throws Exception{
		List<Skill> lista = new ArrayList<Skill>();
		List<Integer> idFunc = idSubordinados(lider);
		Skill _skill = new Skill();
		for(int c=0; c< idFunc.size(); c++) {
			int skill = idFunc.get(c);
			_skill.setId(skill);
			stmt = conect.prepareStatement("SELECT T_TOEVALU_SKILLS.ID_SKILL, T_TOEVALU_SKILLS.NM_SKILL, T_TOEVALU_SKILLS.NM_DESCRICAO\r\n" + 
					"FROM T_TOEVALU_SKILLS\r\n" + 
					"INNER JOIN T_TOEVALU_ANALISTA_SKILL ON T_TOEVALU_ANALISTA_SKILL.ID_SKILL = T_TOEVALU_SKILLS.ID_SKILL\r\n" + 
					"WHERE T_TOEVALU_ANALISTA_SKILL.ID_FUNC_SKILL = ?");
			stmt.setInt(1, skill);
			result = stmt.executeQuery();
			while (result.next()) {
				lista.add(new Skill(skill,
						result.getNString("NM_SKILL"),
						result.getNString("NM_DESCRICAO"),null));
			}
		}
		return lista;
	}
	
	//Retorna as skills de cada subordinado 
	public List<Skill> skillAnalista(int id)throws Exception{
        List<Skill> lista = new ArrayList<Skill>();
            stmt = conect.prepareStatement("SELECT T_TOEVALU_SKILLS.ID_SKILL, T_TOEVALU_SKILLS.NM_SKILL, T_TOEVALU_SKILLS.NM_DESCRICAO\r\n" + 
                    "FROM T_TOEVALU_SKILLS\r\n" + 
                    "INNER JOIN T_TOEVALU_ANALISTA_SKILL ON T_TOEVALU_ANALISTA_SKILL.ID_SKILL = T_TOEVALU_SKILLS.ID_SKILL\r\n" + 
                    "WHERE T_TOEVALU_ANALISTA_SKILL.ID_FUNC_SKILL = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            while (result.next()) {
                lista.add(new Skill(result.getInt("ID_SKILL"),
                        result.getNString("NM_SKILL"),
                        result.getNString("NM_DESCRICAO"),null));
            }       
        return lista;
    }
	
	//Retorna o id do Analista Skill
	public String idSequence(int id, String nomeSkill) throws Exception {
		int idSequence;
		String sequence = "";
        stmt = conect.prepareStatement("SELECT T_TOEVALU_ANALISTA_SKILL.ID_ANALIST_SKILL AS ID "
                + "FROM T_TOEVALU_ANALISTA_SKILL INNER JOIN T_TOEVALU_SKILLS "
                + "ON T_TOEVALU_SKILLS.ID_SKILL = T_TOEVALU_ANALISTA_SKILL.ID_SKILL "
                + "WHERE T_TOEVALU_SKILLS.NM_SKILL = ? AND T_TOEVALU_ANALISTA_SKILL.ID_FUNC_SKILL = ?");
        stmt.setString(1, nomeSkill);
        stmt.setInt(2, id);
        result = stmt.executeQuery();
        while(result.next()) {
        	idSequence = result.getInt("id");
        	sequence = Integer.toString(idSequence);
        	return sequence;
        }
        return sequence;
    }
	
}
