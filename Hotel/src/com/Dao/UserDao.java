package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Model.Order;
import com.Model.User;
import com.Utils.JDBCUtils;
import com.Utils.c3p0utils;

public class UserDao {

	//添加用户
	/*
	public static boolean InsertUser(User user){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "INSERT INTO users(NickName, Password, RealName, Age, Sex, IDNumber, Phone)"+"VALUES('"
						+user.getNickName()+"','"
						+user.getPassword()+"','"
						+user.getRealName()+"',"
						+user.getAge()+",'"
						+user.getSex()+"','"
						+user.getIDNumber()+"','"
						+user.getPhone()+"')";
			
			int num = stmt.executeUpdate(sql);
			if(num > 0) return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
		
		return false;
	}
	*/
	
	public static boolean InsertUser(User user){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "INSERT INTO users(NickName, Password, RealName, Age, Sex, IDNumber, Phone) VALUES(?,?,?,?,?,?,?)";
		int num=0;
		try {
			num = runner.update(sql, new Object[]{
					user.getNickName(),
					user.getPassword(),
					user.getRealName(),
					user.getAge(),
					user.getSex(),
					user.getIDNumber(),
					user.getPhone()
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(num > 0) return true;
		return false;
	}
	
	//根据用户名查找指定用户
	/*
	public static User Find_name(String NickName){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM users WHERE NickName='"+NickName+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setNickName(rs.getString("NickName"));
				user.setPassword(rs.getString("Password"));
				user.setRealName(rs.getString("RealName"));
				user.setAge(rs.getInt("Age"));
				user.setSex(rs.getString("Sex"));
				user.setIDNumber(rs.getString("IDNumber"));
				user.setPhone(rs.getString("Phone"));
				return user;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		
		return null;
	}
	*/
	
	public static User Find_name(String NickName){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "SELECT * FROM users WHERE NickName='"+NickName+"'";
		User user =null;
		try {
			user = runner.query(sql, new BeanHandler(User.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	//根据身份证号查找指定用户
	/*
	public static User Find_id(String IDNumber){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM users WHERE IDNumber="+IDNumber;
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setNickName(rs.getString("NickName"));
				user.setPassword(rs.getString("Password"));
				user.setRealName(rs.getString("RealName"));
				user.setAge(rs.getInt("Age"));
				user.setSex(rs.getString("Sex"));
				user.setIDNumber(rs.getString("IDNumber"));
				user.setPhone(rs.getString("Phone"));
				return user;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		
		return null;
	}
	*/
	
	public static User Find_id(String IDNumber){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "SELECT * FROM users WHERE IDNumber='"+IDNumber+"'";
		User user =null;
		try {
			user = runner.query(sql, new BeanHandler(User.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	//修改指定用户数据
	/*
	public static boolean Update(User user){
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "UPDATE users set Password='"+user.getPassword()
						+"',RealName='"+user.getRealName()
						+"',Age="+user.getAge()
						+",Sex='"+user.getSex()
						+"',IDNumber='"+user.getIDNumber()
						+"',Phone='"+user.getPhone()
						+"' WHERE NickName='"+user.getNickName()+"'";
			int num = stmt.executeUpdate(sql);
			if (num > 0) return true;
			return false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(stmt, conn);
		}
		
		return false;
	}
	*/
	
	public static boolean Update(User user){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "UPDATE users set Password=?, RealName=?, Age=?, Sex=?, IDNumber=?, Phone=?  WHERE NickName=?";
		int num=0;
		try {
			num = runner.update(sql, new Object[]{				
					user.getPassword(),
					user.getRealName(),
					user.getAge(),
					user.getSex(),
					user.getIDNumber(),
					user.getPhone(),
					user.getNickName()
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(num > 0) return true;
		return false;
		
	}
	
}
