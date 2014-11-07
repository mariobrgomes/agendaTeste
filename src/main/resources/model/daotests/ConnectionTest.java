package main.resources.model.daotests;

import java.sql.Connection;
import java.sql.SQLException;

import main.resources.model.dao.ConnectionFactory;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException w) {
			w.printStackTrace();
		}
		System.out.println("Conexão aberta!");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
