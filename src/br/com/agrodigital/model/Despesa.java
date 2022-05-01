package br.com.agrodigital.model;

public class Despesa extends Lancamento {
	
	private String natureza;

	public Despesa(int id, String descricao, String data, String tipo, double valor, String natureza) {
		super();
		this.setNatureza(natureza);
		
	}
	
	public Despesa(String descricao, String data, String tipo, double valor, String natureza) {
		super();
		this.setNatureza(natureza);
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}
	
	public void debita(double valor, Conta conta) {
		double saldoAnterior = conta.getSaldo();
		double saldoAtual = saldoAnterior - valor;
		conta.setSaldo(saldoAtual);
	}

	@Override
	public String toString() {
		return "Despesa [natureza=" + natureza + ", id=" + id + ", descricao=" + descricao + ", data=" + data
				+ ", tipo=" + tipo + ", valor=" + valor + "]";
	}

}
