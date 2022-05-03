package br.com.agrodigital.controller;

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
		// ContaDao dao = new ContaDao(a);
		// boolean resposta = dao.insert(a);
		// return resposta;
		return true;
	}
	
	public Conta listar(int id) {
		// ContaDao dao = new ContaDao(a);
		// boolean resposta = dao.select(id);
		// return resposta;
		Conta c = new Conta("teste", 0);
		return c;
	}
	
	public boolean atualizar(Conta a) {
		// ContaDao dao = new ContaDao(a);
		// boolean resposta = dao.update(a);
		// return resposta;
		return true;
		}
	
	public boolean deletar(int id) {
		// ContaDao dao = new ContaDao(a);
		// boolean resposta = dao.delete(id);
		// return resposta;
		return true;
	}		

}
