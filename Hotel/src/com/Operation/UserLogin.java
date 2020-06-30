package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Model.Order;
import com.Model.User;

public class UserLogin extends HttpServlet {


	public UserLogin() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 用户登录判断
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String NickName = request.getParameter("NickName");
		String Password = request.getParameter("Password");
		String AutomaticLogon = request.getParameter("AutomaticLogon");
		ArrayList<Order> ShopCar = new ArrayList<Order>();
		HttpSession session = request.getSession(true);
		User user = new User();
		String errMsg;
		
		//实现用户自动登录Cookie
		
		user = UserDao.Find_name(NickName);
		if(user == null){
			errMsg = "用户不存在";
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}else if((!Password.trim().equals("")) &&( Password.equals(user.getPassword())) ){
			//如果勾选了自动登录，就执行以下命令
			if(AutomaticLogon != null && AutomaticLogon.equals("yes")){
				Cookie cookie = new Cookie("autologin",NickName+"-"+Password);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
			
			session.setAttribute("NickName", user.getNickName());
			session.setAttribute("ShopCar", ShopCar);
			session.setMaxInactiveInterval(60*30);
			request.getRequestDispatcher( "/servlet/IndexMessage").forward(request,response);//用户正确转到主页面
		}else{		
			errMsg = "用户名或密码错误";
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		this.doGet(request, response);
	}


	public void init() throws ServletException {
		
	}

}
