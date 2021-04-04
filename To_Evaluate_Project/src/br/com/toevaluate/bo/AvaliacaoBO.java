package br.com.toevaluate.bo;

import java.time.LocalDate;

import br.com.toevaluate.beans.Avaliacao;
import br.com.toevaluate.dao.AvaliacaoDAO;
import br.com.toevaluate.util.Magic;

/**
 * Classe de Validação dos dados de Avaliação que irá para o Banco de Dados
 * 
 * @author Gabriel Lucas
 * @version 2.0
 */
public class AvaliacaoBO {

	/**
	 * Métod que valida os dados para Adicionar uma Avaliação
	 * 
	 * @param avaliacao a ser instanciada
	 * @return Retorna uma String "Avaliação adicionada"
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
			return "ID não existe";
		}
		dao.add(avaliacao);
		dao.fechar();
		return "Avaliação adicionada";

	}

	/**
	 * Método que valida os dados para Deletar uma Avaliação
	 * 
	 * @param id ID da Avaliação a ser Deletada
	 * @return Retorna um String "Avaliação apagada!"
	 * @author Gabriel Lucas
	 */
	public static String deletarAvaliacao(int id) throws Exception {
		if (id < 1) {
			return "ID inválido";
		}

		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao aval = dao.read(id);
		if (aval.getId() == 0) {
			dao.fechar();
			return "ID não existe";
		}
		dao.delete(id);
		dao.fechar();
		return "Avaliação apagada!";
	}

	/**
	 * Método que valida os dados pra Atualizar uma Avaliação
	 * 
	 * @param avaliacao a ser instanciada
	 * @return Retorna uma String "Valores alterados"
	 * @author Gabriel Lucas
	 */
	public static String atualizarAvaliacao(int id, LocalDate data) throws Exception {
		LocalDate now = LocalDate.now();
		Magic.validacaoData(data);

		if (id < 1) {
			return "ID inválido";
		}

		if (data.isBefore(now)) {
			return "Data inválida";
		}

		AvaliacaoDAO dao = new AvaliacaoDAO();
		Avaliacao aval = dao.read(id);
		if (aval.getId() == 0) {
			dao.fechar();
			return "ID não existe";
		}
		if (aval.getDataLimite() == data) {
			return "Data inválida";
		}
		dao.update(id, data);
		dao.fechar();
		return "Valores alterados";
	}

	/**
	 * Método que valida os dados para Consultar uma Avaliação
	 * 
	 * @param id ID da Avaliação a ser consultada
	 * @return Retorna uma Avaliação e seus dados
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