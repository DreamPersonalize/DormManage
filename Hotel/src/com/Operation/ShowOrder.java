package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.OrderDao;
import com.Dao.RoomDao;
import com.Model.Order;
import com.Model.Room;

public class ShowOrder extends HttpServlet {

	
	public ShowOrder() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	/**
	 显示历史订单
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断用户是否已经登录
		HttpSession session = request.getSession(true);
		response.setContentType("text/html;charset=utf-8");
		if((session == null) || (session.getAttribute("NickName") == null) || (session.getAttribute("NickName").equals(""))){
			response.getWriter().print("您还没有登录账号！   3s后跳转到登录界面...");
			response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
		}else{
			String NickName = (String) session.getAttribute("NickName");
			String ErrorMsg = "";
			ArrayList<Order> HistoryOrder = OrderDao.FindAll(NickName.trim());
			if(HistoryOrder == null){
				ErrorMsg = "无历史订单！";
				request.getRequestDispatcher("/ShowOrder.jsp").forward(request, response);
			}else{
				//根据房间号获取房间类型信息
				for(Order tmp : HistoryOrder){
					String TypeRoom = RoomDao.Find_IDRoom(tmp.getIDRoom()).getTypeRoom()+"-"+RoomDao.Find_IDRoom(tmp.getIDRoom()).getSubclassRoom();
					tmp.setTypeRoom(TypeRoom);
				}
			}
			
			
			request.setAttribute("ErrorMsg", ErrorMsg);
			request.setAttribute("HistoryOrder", HistoryOrder);
			request.getRequestDispatcher("/ShowOrder.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		
	}

}
