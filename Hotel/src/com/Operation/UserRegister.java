package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.Model.User;
import com.google.common.collect.Maps;

public class UserRegister extends HttpServlet {

	
	public UserRegister() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	/**
	 获取用户注册表单，在数据库中添加该用户
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Content-type", "text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取注册表单内容
		String NickName = request.getParameter("NickName");
		String Password = request.getParameter("Password");
		String RePassword = request.getParameter("RePassword");
		String RealName = request.getParameter("RealName");
		
	    int Age = Integer.parseInt(request.getParameter("Age"));
		String Sex = request.getParameter("Sex");
		String IDNumber = request.getParameter("IDNumber");
		String Phone = request.getParameter("Phone");
		
		//创建新用户
		User user =new User();
		user.setNickName(NickName);
		user.setPassword(Password);
		user.setRePassword(RePassword);
		user.setRealName(RealName);
		user.setAge(Age);
		user.setSex(Sex);
		user.setIDNumber(IDNumber);
		user.setPhone(Phone);
		
		//判断注册内容是否符合要求
		if(!user.validate()){
			request.setAttribute("user", user);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
			return;
		}else{
			//符合要求插入到数据库中
			boolean userFlag=UserDao.InsertUser(user);
			
			if(userFlag == true){
				response.getWriter().print("恭喜你！注册成功，3s后跳转登录...");
				response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
			}else{
				response.getWriter().print("抱歉！注册失败，3s后跳转注册...");
				response.setHeader("refresh", "3;url=/Hotel/Register.jsp");
			}
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
