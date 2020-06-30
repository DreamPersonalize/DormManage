package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Order;


public class ShowShopCar extends HttpServlet {

	
	public ShowShopCar() {
		super();
	}

	
	public void destroy() {
		super.destroy();
	}

	/**
	 展示购物车内容
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
			ArrayList<Order> ShopCar = (ArrayList<Order>) session.getAttribute("ShopCar");
			String CarResult = "";
			if(ShopCar == null){
				ShopCar = new ArrayList<Order>();
				CarResult = "购物车为空！";
			}
			request.setAttribute("ShopCar", ShopCar);
			request.setAttribute("CarResult", CarResult);
			request.getRequestDispatcher("/ShowShopCar.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
