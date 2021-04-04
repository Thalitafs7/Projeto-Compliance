package br.com.toevaluate.beans;

import java.time.LocalDate;

public class Analista extends Usuario {
	private Skill skill;
	private Lider lider;
	private Avaliacao avaliacao;

	public Analista() {
		super();

	}

	public Analista(int id, String nome, String cargo, String departamento, String status, LocalDate dt_nasc,
			Telefone telefone, String situacao) {
		super(id, nome, cargo, departamento, status, dt_nasc, telefone, situacao);
	}

	public Analista(int id, String nome, String cargo, String departamento, String status, LocalDate dt_nasc,
			Telefone telefone, String situacao, Skill skill, Lider lider, Avaliacao avaliacao) {
		super(id, nome, cargo, departamento, status, dt_nasc, telefone, situacao);
		this.skill = skill;
		this.lider = lider;
		this.avaliacao = avaliacao;
	}
	public Analista(int id, String nome, String cargo) {
		this.setId(id);
		this.setNome(nome);
		this.setCargo(cargo);
	}

	@Override
	public String toString() {
	    return "Nome: " + this.getNome() + " Cargo: "+ this.getCargo() + "\n";
	}
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Lider getLider() {
		return lider;
	}

	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

}
