package com.gn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBConnection {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public JDBConnection() {
		String url ="jdbc:mysql://127.0.0.1:3306/library_project";
		String id = "root";
		String pw = "1234";
		
		try {
			conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
