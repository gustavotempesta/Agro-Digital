package br.com.agrodigital.controller;

import br.com.agrodigital.dao.DaoUsuario;
import br.com.agrodigital.model.Usuario;

public class ControllerUsuario {

	private static ControllerUsuario instance = null;
	
	private ControllerUsuario () {};
	
	public static ControllerUsuario getInstance() {
		if(instance == null) {
			instance = new ControllerUsuario();
		}
		return instance;
	}
	
	public boolean adicionar(Usuario a) {
		DaoUsuario dao = new DaoUsuario();
		boolean resposta = dao.insert(a);
		return resposta;
	}
	
	public Usuario listar(int id) {
		DaoUsuario dao = new DaoUsuario();
		Usuario resposta = dao.select(id);
		return resposta;
	}
	
	public boolean atualizar(Usuario a) {
		DaoUsuario dao = new DaoUsuario();
		boolean resposta = dao.update(a);
		return resposta;
		}
	
	public boolean deletar(int id) {
		DaoUsuario dao = new DaoUsuario();
		boolean resposta = dao.delete(id);
		return resposta;
		}		
}

