package br.com.agrodigital.model;

public abstract class Lancamento {
	protected int id;
	protected String descricao;
	protected String data;
	protected String tipo;
	protected double valor;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String desricao) {
		this.descricao = desricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}
	
}