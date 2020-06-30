package com.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	/**
	连接与关闭数据库方法
	 */
	
	//创建连接
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hotelreservation?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
		String username = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	//关闭连接(操作，连接)
	public static void release(Statement stmt, Connection conn){
		
		if(stmt != null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			stmt = null;
		}
		
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			conn = null;
		}
		
	}
	
	//关闭连接(结果、操作、连接)
	public static void release(ResultSet rs, Statement stmt, Connection conn){
		
		if(rs != null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			rs = null;
		}
		
		release(stmt, conn);
		
	}

}
