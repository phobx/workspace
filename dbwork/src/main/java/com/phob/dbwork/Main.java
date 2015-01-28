package com.phob.dbwork;

import java.io.FileInputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;


public class Main {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("src/main/resources/dbconnection.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		Class.forName(driver).newInstance();
		Connection connection = DriverManager.getConnection (url, properties);
		
		connection.setAutoCommit(true);
		
		PreparedStatement ps = connection.prepareStatement("select avg(weight) from tnt.tnt_players");
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		double avgWeight = rs.getDouble(1);
		System.out.println(avgWeight);
		
		ps = connection.prepareStatement("select avg(height) from tnt.tnt_players");
		rs = ps.executeQuery();
		

		rs.next();
		double avgHeight = rs.getDouble(1);
		System.out.println(avgHeight);
	}

}
