package br.com.agrodigital.model;

public class Despesa extends Lancamento {
	
	public Despesa(int id, String descricao, String data, String tipo, double valor, String natureza) {
		super(id, descricao, data, tipo, valor, natureza);
	}
	
	public Despesa(String descricao, String data, String tipo, double valor, String natureza) {
		super(descricao, data, tipo, valor, natureza);
	}
	
	public void debita(double valor, Conta conta) {
		double saldoAnterior = conta.getSaldo();
		double saldoAtual = saldoAnterior - valor;
		conta.setSaldo(saldoAtual);
	}

	@Override
	public String toString() {
		return "Despesa [descricao=" + descricao + ", data=" + data
				+ ", tipo=" + tipo + ", valor=" + valor + ", natureza=" + natureza + "]";
	}

}
