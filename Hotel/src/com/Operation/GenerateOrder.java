package com.Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.OrderDao;
import com.Model.Order;

public class GenerateOrder extends HttpServlet {

	
	public GenerateOrder() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	/**
	 * 生成表单
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//判断用户是否已经登录
		HttpSession session = request.getSession(true);
		response.setContentType("text/html;charset=utf-8");
		
		if((session == null) || (session.getAttribute("NickName") == null) || (session.getAttribute("NickName").equals(""))){
			response.getWriter().print("您还没有登录账号，3s后跳转到登录界面");
			response.setHeader("refresh", "3;url=/Hotel/Login.jsp");
		}else{
			ArrayList<Order> ShopCar = (ArrayList<Order>) session.getAttribute("ShopCar");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String NickName = (String) session.getAttribute("NickName");
			String ErrorMsg = "";
			Date TimeOrder = new Date();
			if(ShopCar == null){
				ErrorMsg = "购物车为空！";
			}else{
				//为购物车内容添加当前用户名及当前时间
				for(Order car : ShopCar){
					car.setNickName(NickName);
					car.setTimeOrder(new java.sql.Date(TimeOrder.getTime()));
				}
				
				
				//判断订单是否符合规范
				if(ShopCar.size() >= 2){
					for(int i = 0; i<ShopCar.size(); i++){
						for(int j=i+1; j<ShopCar.size(); j++){
							if(ShopCar.get(i).getIDNumber().equals(ShopCar.get(j).getIDNumber())){
								ErrorMsg = "同一身份证号只可预订一次！";
							}
						}
					}
				}
				
				if(ErrorMsg.equals("")){
					
				//通过数据库查询近期是否已经预订过了
				Calendar ca = null;
				boolean flag = false;//判断数据库日期是否大于要预订的日期
				ArrayList<Order> DBOrderList = OrderDao.FindAll(NickName);
				if(DBOrderList == null){	
					for(Order car : ShopCar){
						if(!OrderDao.AddOrder(car)){
							ErrorMsg = "生成订单错误！";
						}
					}
				}else{
					for(Order car : ShopCar){
						for(Order db : DBOrderList){
							try {
								java.util.Date dbdate = db.getTimeHousing();
								ca = Calendar.getInstance();
								ca.add(Calendar.DATE,db.getDayHousing());//数据库订单截止日期
								dbdate = ca.getTime();
								Date cardate = car.getTimeHousing();
								if( (dbdate.compareTo(cardate) == 1) && (car.getIDNumber() == db.getIDNumber()) ){
									flag = true;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					
					if(flag){
						ErrorMsg = "近期已有订单，请勿重复预订！";
					}else{
						for(Order car : ShopCar){
							if(!OrderDao.AddOrder(car)){
								ErrorMsg = "订单生成错误！";
							}
						}
					}
				}
			}
				
			}
			
			if(ErrorMsg.equals("")){
				ErrorMsg = "订单生成成功！";
			}
			
			response.getWriter().print(ErrorMsg+"   3s后跳转到主界面...");
			response.setHeader("refresh", "3;url=/Hotel/servlet/IndexMessage");

		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
