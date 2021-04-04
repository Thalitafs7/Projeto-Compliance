package br.com.toevaluate.beans;

import java.time.LocalDate;

public class Rh extends Usuario {

	
	public Rh() {
		super();
	}

	public Rh(int id,String nome, String cargo, String departamento, String status, LocalDate dt_nasc, Telefone telefone,
			String situacao) {
		super(id, nome, cargo, departamento, status, dt_nasc, telefone, situacao);
	}

}
