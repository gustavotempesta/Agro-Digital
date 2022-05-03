package br.com.agrodigital.model;

public class Receita extends Lancamento {

	public Receita(int id, String descricao, String data, String tipo, double valor, String natureza) {
		super(id, descricao, data, tipo, valor, natureza);
	}
	
	public Receita(String descricao, String data, String tipo, double valor, String natureza) {
		super(descricao, data, tipo, valor, natureza);
	}

	public void credita(double valor, Conta conta) {
		double saldoAnterior = conta.getSaldo();
		double saldoAtual = saldoAnterior + valor;
		conta.setSaldo(saldoAtual);
	}

	@Override
	public String toString() {
		return "Receita [descricao=" + descricao + ", data=" + data + ", tipo=" + tipo + ", valor="
				+ valor + ", natureza=" + natureza + "]";
	}
	
}
