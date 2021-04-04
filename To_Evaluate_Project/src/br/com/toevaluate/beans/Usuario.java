package br.com.toevaluate.beans;

import java.time.LocalDate;

public class Usuario {
	private int id;
	private String nome;
	private String cargo;
	private String departamento;
	private String status;
	private LocalDate dt_nasc;
	private Telefone telefone;
	private String situacao;

	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, String cargo, String departamento, String status, LocalDate dt_nasc,
			Telefone telefone, String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.departamento = departamento;
		this.status = status;
		this.dt_nasc = dt_nasc;
		this.telefone = telefone;
		this.situacao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(LocalDate dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
