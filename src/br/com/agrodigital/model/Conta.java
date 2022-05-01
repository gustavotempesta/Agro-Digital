package br.com.agrodigital.model;

public class Conta {
	private int id;
	private String descricao;
	private double saldo;
	
	public Conta(int id, String descricao, float saldo) {
		this.id = id;
		this.descricao = descricao;
		this.saldo = saldo;
	}
	
	public Conta(String descricao, float saldo) {
		this.descricao = descricao;
		this.saldo = saldo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Conta [descricao=" + descricao + ", saldo=" + saldo + "]";
	}
	
}
