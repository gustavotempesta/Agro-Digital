package br.com.agrodigital.model;

public class Propriedade {
	private int id;
	private String inscEst;
	private String nome;
	private String municipio;
	private String contato;
	
	public Propriedade(int id, String inscEst, String nome, String municipio, String contato) {
		this.id = id;
		this.inscEst = inscEst;
		this.nome = nome;
		this.municipio = municipio;
		this.contato = contato;
	}
	
	public Propriedade(String inscEst, String nome, String municipio, String contato) {
		this.inscEst = inscEst;
		this.nome = nome;
		this.municipio = municipio;
		this.contato = contato;
	}

	public String getInscEst() {
		return inscEst;
	}

	public void setInscEst(String inscEst) {
		this.inscEst = inscEst;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Propriedade [inscEst=" + inscEst + ", nome=" + nome + ", municipio=" + municipio + ", contato="
				+ contato + "]";
	}
	
}
