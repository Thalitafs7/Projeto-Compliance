package br.com.toevaluate.beans;

public class Telefone {
	private int id;
	private int numero;
	private int ddd;

	public Telefone() {
		super();
	}

	public Telefone(int id, int ddd, int numero) {
		super();
		this.id = id;
		this.numero = numero;
		this.ddd = ddd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

}
