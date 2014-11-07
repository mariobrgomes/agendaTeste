package main.resources.model.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {

	private final String connection = "jdbc:mysql://localhost/AGENDA";
	private final String user = "root";
	private final String pwd = "dcst";

	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					connection, user, pwd);
		} catch(ClassNotFoundException e){  
			throw new SQLException(e.getMessage()); 
		}
	}
}