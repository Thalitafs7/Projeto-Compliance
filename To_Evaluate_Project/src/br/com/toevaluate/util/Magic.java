package br.com.toevaluate.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Magic {
	public static String s(String msg) {
		return JOptionPane.showInputDialog(msg).toUpperCase();

	}

	public static int i(String msg) {
		return Integer.parseInt(s(msg));
	}

	public static double d(String msg) {
		return Double.parseDouble(s(msg));
	}

	public static String validacaoData(LocalDate data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedString = data.format(formatter);

		String[] dataFormat = formattedString.split("/");

		int dia = Integer.parseInt(dataFormat[0]);
		int mes = Integer.parseInt(dataFormat[1]);
		int ano = Integer.parseInt(dataFormat[2]);

		Calendar anoAtual = Calendar.getInstance();

		if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1900 || ano > anoAtual.get(Calendar.YEAR)) {
			return "Data Inválida";
		} else if ((dia >= 1 && dia <= 31) && mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10
				|| mes == 12) {
			

		} else if ((dia >= 1 && dia <= 30) && mes == 4 || mes == 6 || mes == 9 || mes == 11) {

		} else if ((dia >= 1 && dia <= 28) && mes == 2) {

		} else {
			JOptionPane.showMessageDialog(null, "Essa Data de Nascimento esta incorreta", "AVISO",
					JOptionPane.WARNING_MESSAGE);
			return "Essa data não é valida";
		}
		return "Ok";
	}
}
