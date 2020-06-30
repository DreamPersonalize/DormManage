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

public class DeletCarOrder extends HttpServlet {

	
	public DeletCarOrder() {
		super();
	}

	
	public void destroy() {
		super.destroy();
	}

	/**
	 删除指定内容
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
			//点击删除进入此页面不必判断购物车是否为空，不必创建空shopcar
			int NumOrder = Integer.valueOf(request.getParameter("NumOrder").trim());
			ArrayList<Order> ShopCar = (ArrayList<Order>) session.getAttribute("ShopCar");
			//删除指定元素
			for(int i=0; i<ShopCar.size(); i++){
				if(ShopCar.get(i).getIDOrder() == NumOrder){
					ShopCar.remove(i);
				}			
			}
			//刷新购物车序号
			for(int i=0; i<ShopCar.size(); i++){
				ShopCar.get(i).setIDOrder(i+1);
			}
			session.setAttribute("ShopCar", ShopCar);
			request.getRequestDispatcher("/servlet/ShowShopCar").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
