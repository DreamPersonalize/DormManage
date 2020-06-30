package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.RoomDao;

public class ShowRoomDetail extends HttpServlet {


	public ShowRoomDetail() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	/**
		展示货物细节
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//判断用户是否已经登录
		HttpSession session = request.getSession(true);
		if((session == null) || (session.getAttribute("NickName") == null) || (session.getAttribute("NickName").equals(""))){
			response.getWriter().print("您还没有登录账号！   3s后跳转到登录界面...");
			response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
		}else{
			Calendar cale = Calendar.getInstance();
			int CurrentYear = cale.get(Calendar.YEAR);
			int CurrentMonth = cale.get(Calendar.MONTH)+1;
			int CurrentDay = cale.get(Calendar.DATE);
			cale.add(Calendar.MONTH, 1);
			cale.set(Calendar.DAY_OF_MONTH, 0);
			int MonthLastDay = cale.get(Calendar.DATE);
			int MaxDay = MonthLastDay - CurrentDay + 1;//设置居住日期
			String TypeRoom = request.getParameter("TypeRoom");
			String SubclassRoom = request.getParameter("SubclassRoom");
			String IDRoom = RoomDao.Find_Room(SubclassRoom).getIDRoom();
			int Price = RoomDao.Find_Room(SubclassRoom).getPriceRoom();
			TypeRoom += "-"+SubclassRoom;
			request.setAttribute("CurrentYear", CurrentYear);
			request.setAttribute("CurrentMonth", CurrentMonth);
			request.setAttribute("CurrentDay", CurrentDay);
			request.setAttribute("MonthLastDay", MonthLastDay);
			request.setAttribute("MaxDay", MaxDay);
			request.setAttribute("TypeRoom", TypeRoom);
			request.setAttribute("IDRoom", IDRoom);
			request.setAttribute("PriceRoom", Price);
			request.getRequestDispatcher("/RoomDetail.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
