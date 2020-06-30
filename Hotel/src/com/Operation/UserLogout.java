package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogout extends HttpServlet {

	
	public UserLogout() {
		super();
	}

	
	public void destroy() {
		super.destroy();
	}

	/**
	 用户注销
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("NickName");
		request.getSession().removeAttribute("ShopCar");
		response.sendRedirect("/Hotel/Login.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
