package br.com.toevaluate.beans;

import java.time.LocalDate;

public class Login {
	private String email;
	private String senha;
	private int id;
	private Analista analista;
	private Lider lider;
	private Rh rh;
	private LocalDate dtInicio;
	private LocalDate dtFim;

	public Login() {
		super();
	}

	public Login(String email, String senha, int id, Analista analista, Lider lider, Rh rh, LocalDate dtInicio,
			LocalDate dtFim) {
		super();
		this.email = email;
		this.senha = senha;
		this.id = id;
		this.analista = analista;
		this.lider = lider;
		this.rh = rh;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Rh getRh() {
		return rh;
	}

	public void setRh(Rh rh) {
		this.rh = rh;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDate getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDate dtFim) {
		this.dtFim = dtFim;
	}

}
