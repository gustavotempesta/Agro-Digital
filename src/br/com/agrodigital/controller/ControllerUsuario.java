package br.com.agrodigital.controller;

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
		// UsuarioDao dao = new UsuarioDao(a);
		// boolean resposta = dao.insert(a);
		// return resposta;
		return true;
	}
	
	public Usuario listar(int id) {
		// UsuarioDao dao = new UsuarioDao(a);
		// boolean resposta = dao.select(id);
		// return resposta;
		Usuario c = new Usuario("teste", "senha");
		return c;
	}
	
	public boolean atualizar(Usuario a) {
		// UsuarioDao dao = new UsuarioDao(a);
		// boolean resposta = dao.update(a);
		// return resposta;
		return true;
		}
	
	public boolean deletar(int id) {
		// UsuarioDao dao = new UsuarioDao(a);
		// boolean resposta = dao.delete(id);
		// return resposta;
		return true;
	}		

}

