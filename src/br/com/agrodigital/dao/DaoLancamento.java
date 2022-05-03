package br.com.agrodigital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.agrodigital.connection.Connect;
import br.com.agrodigital.model.Despesa;
import br.com.agrodigital.model.Lancamento;
import br.com.agrodigital.model.Receita;

public class DaoLancamento {

	public boolean insert(Lancamento a) {
		Connection connection = null;
		boolean sucesso = true;
		
		try {
			connection = Connect.createConnection();
			
			String query = "insert into lancamento (descricao,data,tipo,valor,natureza) values(?, ?, ?, ?, ?)";
			
			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, a.getDescricao());
			prepare.setString(2, a.getData());
			prepare.setString(3, a.getTipo());
			prepare.setDouble(4, a.getValor());
			prepare.setString(5, a.getNatureza());
			
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
	
	public Lancamento select(int id) {
		
		Lancamento lancamento = null;
		Connection connection = null;
		Statement st = null;
		
		try {
			connection = Connect.createConnection();
			
			String query = "SELECT id, descricao, data, tipo, valor, natureza FROM lancamento where id = " + id ;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				int identifier = rs.getInt("id");
				String descricao = rs.getString("descricao");
				String data = rs.getString("data");
				String tipo = rs.getString("tipo");
				Double valor = rs.getDouble("valor");
				String natureza = rs.getString("natureza");
				
				if(tipo.equals("Despesa")) {
					lancamento = new Despesa(identifier,descricao,data,tipo,valor,natureza);
				}else if (tipo.equals("Receita")) {
					System.out.println("chegou em receita");
					lancamento = new Receita(identifier,descricao,data,tipo,valor,natureza);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return lancamento;
	}
	
	public boolean update(Lancamento a) {
	
		Connection connection = null;
		boolean sucesso = true;
			
		try {
			connection = Connect.createConnection();
			
			String query = "UPDATE lancamento set descricao=?, data=?, tipo=?, valor=?, natureza=? WHERE id = ?";
			
			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, a.getDescricao());
			prepare.setString(2, a.getData());
			prepare.setString(3, a.getTipo());
			prepare.setDouble(4, a.getValor());
			prepare.setString(5, a.getNatureza());
			prepare.setInt(6, a.getId());
			
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
			
			String query = "DELETE FROM lancamento WHERE id = ?";

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
