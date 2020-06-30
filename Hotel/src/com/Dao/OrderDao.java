package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Model.Order;
import com.Model.Room;
import com.Model.User;
import com.Utils.JDBCUtils;
import com.Utils.c3p0utils;

public class OrderDao {
	
	//添加新的订单
	/*
	public static boolean AddOrder(Order ord){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "INSERT INTO orderroom(IDRoom, NickName, RealName, IDNumber, TimeHousing, DayHousing, HaveBreakfast, AllPrice, TimeOrder)"+"VALUES('"
					+ord.getIDRoom()+"','"
					+ord.getNickName()+"','"
					+ord.getRealName()+"','"
					+ord.getIDNumber()+"','"
					+ord.getTimeHousing()+"',"
					+ord.getDayHousing()+","
					+ord.getHaveBreakfast()+","
					+ord.getAllPrice()+",'"
					+ord.getTimeOrder()+"')";
			int num = stmt.executeUpdate(sql);
			if(num > 0) return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	*/
	public static boolean AddOrder(Order ord){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "INSERT INTO orderroom(IDRoom, NickName, RealName, IDNumber, TimeHousing, DayHousing, HaveBreakfast, AllPrice, TimeOrder) VALUES(?,?,?,?,?,?,?,?,?)";
		int num=0;
		try {
			num = runner.update(sql, new Object[]{
					ord.getIDRoom(),
					ord.getNickName(),
					ord.getRealName(),
					ord.getIDNumber(),
					ord.getTimeHousing(),
					ord.getDayHousing(),
					ord.getHaveBreakfast(),
					ord.getAllPrice(),
					ord.getTimeOrder()	
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(num > 0) return true;
		return false;
		
	}
	
	//查询订单
	/*
	public static ArrayList<Order> FindAll(String NickName){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<Order>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM orderroom WHERE NickName='"+NickName+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Order ord = new Order();
				ord.setIDOrder(rs.getInt("IDORder"));
				ord.setIDRoom(rs.getString("IDRoom"));
				ord.setNickName(rs.getString("NickName"));
				ord.setRealName(rs.getString("RealName"));
				ord.setIDNumber(rs.getString("IDNumber"));
				ord.setTimeHousing(rs.getDate("TimeHousing"));
				ord.setDayHousing(rs.getInt("DayHousing"));
				ord.setHaveBreakfast(rs.getInt("HaveBreakfast"));
				ord.setAllPrice(rs.getInt("AllPrice"));
				ord.setTimeOrder(rs.getDate("TimeOrder"));
				list.add(ord);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	*/
	
	public static ArrayList<Order> FindAll(String NickName){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "SELECT * FROM orderroom WHERE NickName='"+NickName+"'";
		ArrayList<Order> list = null;
		try {
			list = runner.query(sql, new BeanListHandler(Order.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//删除订单
	/*
	public static boolean delete(String IDOrder){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "DELETE FROM orderroom WHERE IDOrder='"+IDOrder+"'";
			int num = stmt.executeUpdate(sql);
			if(num > 0) return true;
			return false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	*/
	public static boolean delete(String IDOrder){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "DELETE FROM orderroom WHERE IDOrder="+IDOrder+"";
		int num = 0;
		try {
			num = runner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(num > 0) return true;
		return false;
	}
}
