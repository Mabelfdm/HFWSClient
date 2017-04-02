package com.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {

	static Connection newConnection = null;

	public static Connection getDBConnection() throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:hsqldb:file:src/main/java/testdb", "SA", "");
			newConnection = con;

		
		
//		try (Connection con = DriverManager.getConnection("jdbc:hsqldb:file:src/main/java/testdb", "SA", "")) {
//			newConnection = con;
//
//		}
		return newConnection;
	}

	public static void main(String[] args) throws SQLException {
		getDBConnection();
		try {
			
			Statement st = newConnection.createStatement();

			// st.execute("create table t_user (id int,name varchar(100),pwd
			// varchar(100));");
			st.executeUpdate("INSERT INTO t_user VALUES(14,'mabel','123456') ");

			String sql = "SELECT * FROM t_user";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
