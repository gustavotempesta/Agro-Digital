package br.com.agrodigital.controller;

import br.com.agrodigital.model.Propriedade;

public class ControllerPropriedade {

	private static ControllerPropriedade instance = null;
	
	private ControllerPropriedade () {};
	
	public static ControllerPropriedade getInstance() {
		if(instance == null) {
			instance = new ControllerPropriedade();
		}
		return instance;
	}
	
	public boolean adicionar(Propriedade a) {
		// PropriedadeDao dao = new PropriedadeDao(a);
		// boolean resposta = dao.insert(a);
		// return resposta;
		return true;
	}
	
	public Propriedade listar(int id) {
		// PropriedadeDao dao = new PropriedadeDao(a);
		// boolean resposta = dao.select(id);
		// return resposta;
		Propriedade c = new Propriedade("teste", "teste", "teste", "teste");
		return c;
	}
	
	public boolean atualizar(Propriedade a) {
		// PropriedadeDao dao = new PropriedadeDao(a);
		// boolean resposta = dao.update(a);
		// return resposta;
		return true;
		}
	
	public boolean deletar(int id) {
		// PropriedadeDao dao = new PropriedadeDao(a);
		// boolean resposta = dao.delete(id);
		// return resposta;
		return true;
	}		


}