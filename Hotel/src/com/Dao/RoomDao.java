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
import com.Model.Room;
import com.Model.User;
import com.Utils.JDBCUtils;
import com.Utils.c3p0utils;

public class RoomDao {

	//根据房间类型获取房间信息
	/*
	public static ArrayList<Room> FindAll(String TypeRoom){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Room> list = new ArrayList<Room>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelroom WHERE TypeRoom='"+TypeRoom+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Room room = new Room();
				room.setIDRoom(rs.getString("IDRoom"));
				room.setTypeRoom(rs.getString("TypeRoom"));
				room.setSubclassRoom(rs.getString("SubclassRoom"));
				room.setPriceRoom(rs.getInt("PriceRoom"));
				list.add(room);
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
	
	public static ArrayList<Room> FindAll(String TypeRoom){

		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "SELECT * FROM hotelroom WHERE TypeRoom='"+TypeRoom+"'";
		ArrayList<Room> list = null;
		try {
			list = runner.query(sql, new BeanListHandler(Room.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//根据房间子类查找房间
	/*
	public static Room Find_Room(String SubclassRoom){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelroom WHERE SubclassRoom='"+SubclassRoom+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Room room = new Room();
				room.setIDRoom(rs.getString("IDRoom"));
				room.setTypeRoom(rs.getString("TypeRoom"));
				room.setSubclassRoom(rs.getString("SubclassRoom"));
				room.setPriceRoom(rs.getInt("PriceRoom"));
				return room;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		
		return null;
	}
	*/
	
	public static Room Find_Room(String SubclassRoom){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "SELECT * FROM hotelroom WHERE SubclassRoom='"+SubclassRoom+"'";
		Room room = null;
		try {
			room = runner.query(sql, new BeanHandler(Room.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
		
	}
	
	//根据房间号查找房间
	
	/*
	public static Room Find_IDRoom(String IDRoom){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM hotelroom WHERE IDRoom='"+IDRoom+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Room room = new Room();
				room.setIDRoom(rs.getString("IDRoom"));
				room.setTypeRoom(rs.getString("TypeRoom"));
				room.setSubclassRoom(rs.getString("SubclassRoom"));
				room.setPriceRoom(rs.getInt("PriceRoom"));
				return room;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		
		return null;
	}
	*/
	
	public static Room Find_IDRoom(String IDRoom){
		QueryRunner runner = new QueryRunner(c3p0utils.getDataSource());
		String sql = "SELECT * FROM hotelroom WHERE IDRoom='"+IDRoom+"'";
		Room room = null;
		try {
			room = runner.query(sql, new BeanHandler(Room.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}
	
}
