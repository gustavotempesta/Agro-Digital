package br.com.agrodigital.model;

public abstract class Lancamento {
	protected int id;
	protected String descricao;
	protected String data;
	protected String tipo;
	protected double valor;
	protected String natureza;
	protected int idConta = 1;
		
	public Lancamento(int id, String descricao, String data, String tipo, double valor, String natureza) {
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
		this.natureza = natureza;
	}
	
	public Lancamento(String descricao, String data, String tipo, double valor, String natureza) {
		this.descricao = descricao;
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
		this.natureza = natureza;
	}

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

	public int getIdConta() {
		return idConta;
	}

	public int getId() {
		return id;
	}
	
	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	
}
