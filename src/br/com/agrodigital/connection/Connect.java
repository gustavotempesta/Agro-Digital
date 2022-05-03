package br.com.agrodigital.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	public static Connection createConnection() throws SQLException {
		
		String servidor = "localhost";
		String porta = "3306";
		String nomeBanco = "agrodigital";
		String user = "root";
		String password = "root";
		String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC", servidor,porta,nomeBanco);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(url, user, password);
		
	}
	
	public static void main(String[] args) throws SQLException {
		Connection c = createConnection();
		c.close();
	}

}
