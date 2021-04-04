package br.com.toevaluate.bo;
import br.com.toevaluate.beans.Analista;
import br.com.toevaluate.beans.Telefone;
import br.com.toevaluate.dao.TelefoneDAO;

public class TelefoneBO {

	public static Telefone lerDado(int id)throws Exception {
		if(id <= 0) {
			return new Telefone();
		}
		TelefoneDAO dao = new TelefoneDAO();
		Telefone res = dao.read(id);
		dao.fecharBanco();
		return res;
	}
	public static String excluirDado(int id)throws Exception{
		if (id <= 0) {
			return "ID Inv�lido";
		}
		TelefoneDAO dao = new TelefoneDAO();
		Telefone res = dao.read(id);
		if (res.getId() == 0) {
			dao.fecharBanco();
			return "ID n�o existe";
		}
		dao.apagar(id);
		dao.fecharBanco();
		return "Telefone Apagado com sucesso";
	}
	public static String inserirDado(Telefone tel)throws Exception{
		int indice = 0;
		if(tel.getDdd() < 11 || tel.getDdd() > 99  ) {
			return "DDD Inv�lido";
		}
		String num = Integer.toString(tel.getNumero());
		for( int i = 0; i < num.length(); i++) {
			indice = i;
		}
		if(indice != 8) {
			return "N�mero Inv�lido";
		}

		TelefoneDAO dao = new TelefoneDAO();
		dao.inserir(tel);
		dao.fecharBanco();
		return "Dados adicionados com sucesso!";
	}
	public static String atualizarDado(Telefone tel, int idFunc)throws Exception{
		int indice = 0;
		if(tel.getDdd() < 11 || tel.getDdd() > 99  ) {
			return "DDD Inv�lido";
		}
		String num = Integer.toString(tel.getNumero());
		for( int i = 0; i < num.length(); i++) {
			indice = i;
		}
		if(indice != 8) {
			return "N�mero Inv�lido";
		}
		
		if(idFunc <= 0) {
			return "ID do Funcion�rio Inv�lido";
		}
		TelefoneDAO dao = new TelefoneDAO();
		dao.atualizar(tel, idFunc);
		return "Dados atualizados com sucesso!";
	}

}
