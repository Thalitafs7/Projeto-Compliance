package br.com.toevaluate.bo;

import java.time.LocalDate;

import br.com.toevaluate.beans.Avaliacao;
import br.com.toevaluate.dao.AvaliacaoDAO;
import br.com.toevaluate.util.Magic;

/**
 * Classe de Valida��o dos dados de Avalia��o que ir� para o Banco de Dados
 * 
 * @author Gabriel Lucas
 * @version 2.0
 */
public class AvaliacaoBO {

	/**
	 * M�tod que valida os dados para Adicionar uma Avalia��o
	 * 
	 * @param avaliacao a ser instanciada
	 * @return Retorna uma String "Avalia��o adicionada"
	 * @author Gabriel Lucas
	 */
	public static String adicionarAvaliacao(Avaliacao avaliacao) throws Exception {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate dataHoje = LocalDate.now();
		Magic.validacaoData(avaliacao.getDataLimite());

//		LocalDate data = analista.getDt_nasc();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");
//		String formattedString = data.format(formatter);
		AvaliacaoDAO dao = new AvaliacaoDAO();
		if (avaliacao.getAnalista().getId() == 0) {
			dao.fechar();
			return "ID n�o existe";
		}
		dao.add(avaliacao);
		dao.fechar();
		return "Avalia��o adicionada";

	}

	/**
	 * M�todo que valida os dados para Deletar uma Avalia��o
	 * 
	 * @param id ID da Avalia��o a ser Deletada
	 * @return Retorna um String "Avalia��o apagada!"
	 * @author Gabriel Lucas
	 */
	public static String deletarAvaliacao(int id) throws Exception {
		if (id < 1) {
			return "ID inv�lido";
		}

		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao aval = dao.read(id);
		if (aval.getId() == 0) {
			dao.fechar();
			return "ID n�o existe";
		}
		dao.delete(id);
		dao.fechar();
		return "Avalia��o apagada!";
	}

	/**
	 * M�todo que valida os dados pra Atualizar uma Avalia��o
	 * 
	 * @param avaliacao a ser instanciada
	 * @return Retorna uma String "Valores alterados"
	 * @author Gabriel Lucas
	 */
	public static String atualizarAvaliacao(int id, LocalDate data) throws Exception {
		LocalDate now = LocalDate.now();
		Magic.validacaoData(data);

		if (id < 1) {
			return "ID inv�lido";
		}

		if (data.isBefore(now)) {
			return "Data inv�lida";
		}

		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao aval = dao.read(id);
		if (aval.getId() == 0) {
			dao.fechar();
			return "ID n�o existe";
		}
		if (aval.getDataLimite() == data) {
			return "Data inv�lida";
		}
		dao.update(id, data);
		dao.fechar();
		return "Valores alterados";
	}

	/**
	 * M�todo que valida os dados para Consultar uma Avalia��o
	 * 
	 * @param id ID da Avalia��o a ser consultada
	 * @return Retorna uma Avalia��o e seus dados
	 * @author Gabriel Lucas
	 */
	public static Avaliacao consultar(int id) throws Exception {

		if (id < 1) {
			return new Avaliacao();
		}
		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao aval = dao.read(id);
		if (aval.getId() == 0) {
			dao.fechar();
			return new Avaliacao();
		}

		dao.fechar();
		return aval;

	}

}