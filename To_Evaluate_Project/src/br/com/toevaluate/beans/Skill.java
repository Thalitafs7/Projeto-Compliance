package br.com.toevaluate.beans;

public class Skill {
	private int id;
	private String nome;
	private String descricao;
	private Analista analista;
	
	
	public Analista getAnalista() {
		return analista;
	}

	public void setAnalista(Analista analista) {
		this.analista = analista;
	}

	public Skill(int id, String descricao, String nome, Analista analista) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.id = id;
		this.analista = analista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Skill() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}