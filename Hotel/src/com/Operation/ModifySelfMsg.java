package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Model.User;

public class ModifySelfMsg extends HttpServlet {

	
	public ModifySelfMsg() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	/**
	 * 修改个人信息
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//判断用户是否已经登录
		HttpSession session = request.getSession(true);
		response.setContentType("text/html;charset=utf-8");
		if((session == null) || (session.getAttribute("NickName") == null) || (session.getAttribute("NickName").equals(""))){
			response.getWriter().print("您还没有登录账号！   3s后跳转到登录界面...");
			response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
		}else{
			
			//获取注册表单内容
			String NickName = (String) session.getAttribute("NickName");
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
			if(!user.Modify_validate()){
				request.setAttribute("user", user);
				request.getRequestDispatcher("/ModifySelfMsg.jsp").forward(request, response);
				return;
			}else{
				//符合要求修改数据库中数据
				boolean userFlag=UserDao.Update(user);
				
				if(userFlag == true){
					request.setAttribute("Msg", "修改成功");
					request.getRequestDispatcher("/ModifySelfMsg.jsp").forward(request, response);
					return;
				}else{
					request.setAttribute("Msg", "修改失败");
					request.getRequestDispatcher("/ModifySelfMsg.jsp").forward(request, response);
					return;
				}
			}
			
		}
	}

	
	public void init() throws ServletException {
		
	}

}
