package com.cg.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
//		TODO	Load JDBC Driver into Main Memory
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		Class.forName(jdbcDriver);
		
		
//		TODO	Get Database connection using JDBC URL
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
		String userName = "System";
		String password = "Capgemini123";
		
		Connection dbConnection;
		
		dbConnection = DriverManager.getConnection(jdbcURL, userName, password);
		
		System.out.println("Actual type of dbConnection "+ 
				dbConnection.getClass());
		
		return dbConnection;
	}
}
