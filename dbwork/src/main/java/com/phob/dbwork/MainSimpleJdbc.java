package com.phob.dbwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainSimpleJdbc {
	public static void main1(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost/testdb";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url, "root", "");

		conn.setAutoCommit(false);

		Statement st = conn.createStatement();
		st.execute("insert into t2 values(1, 'abcde', 'long or even longer string')");

		conn.commit();
		conn.close();
		System.out.println("done");
	}

	public static void main2(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost/testdb";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url, "root", "");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn
				.prepareStatement("insert into t2 values(?, ?, ?)");

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			ps.setInt(1, i);
			ps.setString(2, String.valueOf(i));
			ps.setString(3, "this is very long string number " + i);
			ps.execute();
			conn.commit();
			// ps.addBatch();
		}
		// ps.executeBatch();
		conn.close();

		long endTime = System.currentTimeMillis();

		System.out.println("Time " + (endTime - startTime) / 1000.0);
		System.out.println("done");
	}

	public static void main3(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost/testdb";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url, "root", "");

		conn.setAutoCommit(true);

		PreparedStatement ps = conn
				.prepareStatement("select col1 as c1, name from t2 where col1 > ?");
		ps.setInt(1, 99900);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int col1 = rs.getInt("c1");
			String name = rs.getString(2);
			System.out.println(col1 + " - " + name);
		}
	}

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost/kievchamp";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(url, "root", "");

		conn.setAutoCommit(true);

		PreparedStatement ps = conn
				.prepareStatement("select p.first_name, p.last_name, t.name from tnt_players p, tnt_teams t where p.team_id=t.id order by last_name");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String firstName = rs.getString(1);
			String lastName = rs.getString(2);
			String teamName = rs.getString(3);
			System.out.println(lastName + " " + firstName + " - " + teamName);
		}
	}
}