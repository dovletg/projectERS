package com.ers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static Connection connection = null;

	public static Connection initConnection() {
		String dbUrl = "jdbc:mysql://localhost:3306/ers";
	// our mysql user and password 
		String dbUser = "root";
		String dbPassword = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			if (connection != null) {
				System.out.println("Database Connection Successfull");
			} else {
				System.out.println("Error Connecting to Database");
			}
			return connection;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error Connecting to Database");
			return null;
		}

	}

}
