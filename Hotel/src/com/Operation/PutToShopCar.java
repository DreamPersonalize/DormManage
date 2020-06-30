package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Order;


public class PutToShopCar extends HttpServlet {

	
	public PutToShopCar() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	/**
	 将物品放入购物车中
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//判断用户是否已经登录
		HttpSession session = request.getSession(true);
		if((session == null) || (session.getAttribute("NickName") == null) || (session.getAttribute("NickName").equals(""))){
			response.getWriter().print("您还没有登录账号！   3s后跳转到登录界面...");
			response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
		}else{
			//获取session购物车内容
			ArrayList<Order> ShopCar = (ArrayList<Order>) session.getAttribute("ShopCar");
			if(ShopCar == null){
				ShopCar = new ArrayList<Order>();
			}
			
			Order order = new Order();
			//获取jsp表单内容
			String IDRoom = request.getParameter("IDRoom");
			String RealName = request.getParameter("RealName");
			int PriceRoom = Integer.valueOf(request.getParameter("PriceRoom").trim());
			String IDNumber = request.getParameter("IDNumber");
			String TimeHousing = request.getParameter("Year").trim()+"-"+request.getParameter("Month").trim()+"-"+request.getParameter("Day").trim();
			int DayHousing = Integer.valueOf(request.getParameter("DayHousing").trim());
			int HaveBreakfast = Integer.valueOf(request.getParameter("HavaBreakfast").trim());
			int AllPrice = (PriceRoom + 10 * HaveBreakfast) * DayHousing;			
			
			//创建一个新的Order类
			order.setIDOrder(ShopCar.size()+1);
			order.setIDRoom(IDRoom);
			order.setRealName(RealName);
			order.setIDNumber(IDNumber);
			order.setTimeHousing(java.sql.Date.valueOf(TimeHousing));			
			order.setDayHousing(DayHousing);
			order.setHaveBreakfast(HaveBreakfast);
			order.setAllPrice(AllPrice);
			
			ShopCar.add(order);
			session.setAttribute("ShopCar", ShopCar);
			request.getRequestDispatcher("/servlet/IndexMessage").forward(request, response);
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		
	}

}
