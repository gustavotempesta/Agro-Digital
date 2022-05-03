package br.com.agrodigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.agrodigital.connection.Connect;
import br.com.agrodigital.model.Usuario;

public class DaoUsuario {

	public boolean insert(Usuario a) {
		Connection connection = null;
		boolean sucesso = true;
		
		try {
			connection = Connect.createConnection();
			
			String query = "insert into usuario (login,senha) values(?, ?)";

			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, a.getLogin());
			prepare.setString(2, a.getSenha());

			prepare.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sucesso;
	}
	
	public Usuario select(int id) {
		
		Usuario usuario = null;
		Connection connection = null;
		Statement st = null;
		
		try {
			connection = Connect.createConnection();
			
			String query = "SELECT id, login, senha FROM usuario where id = " + id ;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				int identifier = rs.getInt("id");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
			
				usuario = new Usuario(identifier, login, senha);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return usuario;
	}
	
	public boolean update(Usuario a) {
	
		Connection connection = null;
		boolean sucesso = true;
			
		try {
			connection = Connect.createConnection();
			
			String query = "UPDATE usuario set login=?, senha=? WHERE id = ?";

			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, a.getLogin());
			prepare.setString(2, a.getSenha());
			prepare.setInt(3, a.getId());
			
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sucesso;
	}

	public boolean delete(int id) {

		Connection connection = null;
		boolean sucesso = true;
		
		try {
			connection = Connect.createConnection();
			
			String query = "DELETE FROM usuario WHERE id = ?";

			PreparedStatement prepare = connection.prepareStatement(query);
			prepare.setInt(1,id);
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sucesso;
	}
	
}
