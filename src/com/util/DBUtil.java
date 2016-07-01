package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:mysql:///he?characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "1994";
	private static Connection conn;
	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动出错");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("链接数据库出错");
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		return conn;
	}
}
