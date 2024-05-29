package com.funfit.resource;

//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DbResource {
//
//	public static Connection getDbConnection () {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/funfit", "admin", "admin");
//			return con;
//		} catch (Exception e) {
//			System.err.println(e);
//			return null;
//		}
//	}
//}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbResource {

	private static DbResource instance;
	private Connection con;

	private DbResource() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/funfit", "admin", "admin");
		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	public Connection getDbConnection() {
		return this.con;
	}

	public static DbResource GetResource() throws SQLException {
		return (instance == null || instance.getDbConnection().isClosed()) ? new DbResource() : instance;
	}
}