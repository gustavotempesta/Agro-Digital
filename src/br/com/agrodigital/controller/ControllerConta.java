package br.com.agrodigital.controller;

import br.com.agrodigital.dao.DaoConta;
import br.com.agrodigital.model.Conta;

public class ControllerConta {
	
	private static ControllerConta instance = null;
	
	private ControllerConta () {};
	
	public static ControllerConta getInstance() {
		if(instance == null) {
			instance = new ControllerConta();
		}
		return instance;
	}
	
	public boolean adicionar(Conta a) {
		DaoConta dao = new DaoConta();
		boolean resposta = dao.insert(a);
		return resposta;
	}
	
	public Conta listar(int id) {
		DaoConta dao = new DaoConta();
		Conta resposta = dao.select(id);
		return resposta;
	}
	
	public boolean atualizar(Conta a) {
		DaoConta dao = new DaoConta();
		boolean resposta = dao.update(a);
		return resposta;
		}
	
	public boolean deletar(int id) {
		DaoConta dao = new DaoConta();
		boolean resposta = dao.delete(id);
		return resposta;
	}		

}
