package br.com.toevaluate.beans;

import java.time.LocalDate;

public class Avaliacao {
	private int id;
	private double notaLider;
	private double notaAnalista;
	private LocalDate dataLimite;
	private LocalDate dataResposta;
	private Analista analista;
	private Lider lider;
	private Skill skill;

	public Avaliacao() {
		super();

	}

	public Avaliacao(int id, double notaLider, double notaAnalista, LocalDate dataLimite, LocalDate dataResposta,
			Analista analista, Lider lider, Skill skill) {
		super();
		this.id = id;
		this.notaLider = notaLider;
		this.notaAnalista = notaAnalista;
		this.dataLimite = dataLimite;
		this.dataResposta = dataResposta;
		this.analista = analista;
		this.lider = lider;
		this.skill = skill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNotaLider() {
		return notaLider;
	}

	public void setNotaLider(double notaLider) {
		this.notaLider = notaLider;
	}

	public double getNotaAnalista() {
		return notaAnalista;
	}

	public void setNotaAnalista(double notaAnalista) {
		this.notaAnalista = notaAnalista;
	}

	public LocalDate getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(LocalDate dataLimite) {
		this.dataLimite = dataLimite;
	}

	public LocalDate getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDate dataResposta) {
		this.dataResposta = dataResposta;
	}

	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Lider getLider() {
		return lider;
	}

	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
