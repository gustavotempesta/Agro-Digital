package br.com.agrodigital.model;

public class Receita extends Lancamento {

	public Receita(int id, String descricao, String data, String tipo, double valor) {
		super(id, descricao, data, tipo, valor);
	}
	
	public Receita(String descricao, String data, String tipo, double valor) {
		super(descricao, data, tipo, valor);
	}

	public void credita(double valor, Conta conta) {
		double saldoAnterior = conta.getSaldo();
		double saldoAtual = saldoAnterior + valor;
		conta.setSaldo(saldoAtual);
	}

	@Override
	public String toString() {
		return "Receita [id=" + id + ", descricao=" + descricao + ", data=" + data + ", tipo=" + tipo + ", valor="
				+ valor + "]";
	}
	
}
