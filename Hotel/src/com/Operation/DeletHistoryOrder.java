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
import com.Model.Order;

public class DeletHistoryOrder extends HttpServlet {

	
	public DeletHistoryOrder() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	/**
	 删除数据库中的历史订单
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断用户是否已经登录
		String ErrorMsg = "";
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(true);
		if((session == null) || (session.getAttribute("NickName") == null) || (session.getAttribute("NickName").equals(""))){
			response.getWriter().print("您还没有登录账号！   3s后跳转到登录界面...");
			response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
		}else{
			
			String IDOrder = request.getParameter("IDOrder").trim();
			if(IDOrder != null){
				if(OrderDao.delete(IDOrder)){//删除指定元素
					ErrorMsg = "订单删除成功！";
				}else{
					ErrorMsg = "订单删除失败！";
				}
			}else{
				ErrorMsg = "订单为空,无可删除项！";
			}
			
			response.getWriter().print(ErrorMsg+"3s后跳转到历史订单界面");
			response.setHeader("refresh", "3;url=/Hotel/servlet/ShowOrder");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
