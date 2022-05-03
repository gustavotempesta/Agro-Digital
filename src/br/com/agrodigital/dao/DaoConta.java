package br.com.agrodigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.agrodigital.connection.Connect;
import br.com.agrodigital.model.Conta;

public class DaoConta {

	public boolean insert(Conta a) {
		Connection connection = null;
		boolean sucesso = true;
		
		try {
			connection = Connect.createConnection();
			
			String query = "insert into conta (descricao,saldo) values(?, ?)";

			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, a.getDescricao());
			prepare.setString(2, String.valueOf(a.getSaldo()));

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
	
	public Conta select(int id) {
		
		Conta conta = null;
		Connection connection = null;
		Statement st = null;
		
		try {
			connection = Connect.createConnection();
			
			String query = "SELECT id, descricao, saldo FROM conta where id = " + id ;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				int identifier = rs.getInt("id");
				String descricao = rs.getString("descricao");
				double saldo = rs.getDouble("saldo");
			
				conta = new Conta(identifier, descricao, saldo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return conta;
	}
	
	public boolean update(Conta a) {
	
		Connection connection = null;
		boolean sucesso = true;
			
		try {
			connection = Connect.createConnection();
			
			String query = "UPDATE conta set descricao=?, saldo=? WHERE id = ?";

			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, a.getDescricao());
			prepare.setDouble(2, a.getSaldo());
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
			
			String query = "DELETE FROM conta WHERE id = ?";

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
