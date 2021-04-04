package br.com.toevaluate.beans;

import java.time.LocalDate;

public class Lider extends Usuario {
	private int idFuncLider;
	private LocalDate dataInicio;

	public Lider() {
		super();

	}

	public Lider(int id, String nome, String cargo, String departamento, String status, LocalDate dt_nasc,
			Telefone telefone, String situacao) {
		super(id, nome, cargo, departamento, status, dt_nasc, telefone, situacao);

	}

	public Lider(int id, String nome, String cargo, String departamento, String status, LocalDate dt_nasc,
			Telefone telefone, String situacao, int idFuncLider, LocalDate dataInicio) {
		super(id, nome, cargo, departamento, status, dt_nasc, telefone, situacao);
		this.idFuncLider = idFuncLider;
		this.dataInicio = dataInicio;
	}

	public int getIdFuncLider() {
		return idFuncLider;
	}

	public void setIdFuncLider(int idFuncLider) {
		this.idFuncLider = idFuncLider;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

}
