package br.com.agrodigital.model;

public class Usuario {
	private int id;
	private String login;
	private String senha;
	
	public Usuario(int id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public String getSenha() {
		return senha;
	}

	public String getLogin() {
		return login;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + "]";
	}
	
}
