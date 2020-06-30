package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.RoomDao;
import com.Model.Room;

public class IndexMessage extends HttpServlet {

	
	public IndexMessage() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 将数据库中的内容显示在前端
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		         
		//判断用户是否已经登录
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(true);
		if((session == null) || (session.getAttribute("NickName") == null) || (session.getAttribute("NickName").equals(""))){
			response.getWriter().print("您还没有登录账号!   3s后跳转到登录界面...");
			response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
		}else{
			ArrayList<Room> SinglePerson = RoomDao.FindAll("单人房");	//房间类型为单人房集合
			ArrayList<Room> BigBed = RoomDao.FindAll("大床房");			//房间类型为大床房集合
			ArrayList<Room> DoublePerson = RoomDao.FindAll("双床房");	//房间类型为双人房集合
			request.setAttribute("SinglePerson", SinglePerson);
			request.setAttribute("BigBed", BigBed);
			request.setAttribute( "DoublePerson",DoublePerson); 
			request.getRequestDispatcher( "/index.jsp").forward(request,response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
