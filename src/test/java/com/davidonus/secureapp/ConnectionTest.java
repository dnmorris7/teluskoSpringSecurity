package com.davidonus.secureapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

//import org.junit.Test;

public class ConnectionTest {
	static Connection con;
	private static String name;

	public static Connection getConnection() {
		try {
			String URL = "jdbc:mysql://localhost/teluskosecapp";
			String UserId = "root";
			String Password = "abcd1234";

			con = DriverManager.getConnection(URL, "root", "abcd1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		try {
			// String driverSource =
			// "C:/Users/David/Desktop/DevOps2019/2019/JavaBootCamp_AFS/JavaBootCamp_AFS/Week1n2Codebase_participant/src/mysql-connector-java-5.1.16-bin.jar";
			// Class.forName(driverSource);
			Class.forName("com.mysql.jdbc.Driver"); // make sure your CLASSPATH includes the .jar for your driver.
		} catch (Exception e) {
			System.out.println(e);
		}
		getConnection();
		System.out.println("Connection obtained - " + con);

		Statement stmt = null;

		ArrayList<String> users = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM teluskosecapp.users;");

			System.out.println(rs.toString());
			System.out.println(rs.getMetaData());

			while (rs.next()) {
				String test = rs.getString("user_id");

				User user = new User(Integer.parseInt(rs.getString("user_id")), rs.getString("user_name"),
						rs.getString("user_pwd"));
				System.out.println(user.toString());
			}

			/*
			 * while (rs.next()) { String id = rs.getString("user_id"); String name =
			 * rs.getString("user_name"); String pwd = rs.getString("user_pwd");
			 * 
			 * 
			 * }
			 */ // System.out.println(rs.getInt("user_id")); ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
