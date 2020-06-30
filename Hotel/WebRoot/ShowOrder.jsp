<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/about.css" rel="stylesheet" />
  </head>
  
  <body>
  
  <nav class="navbar navbar-expand-md bg-dark navbar-dark">
	  <a class="navbar-brand" href="/Hotel/servlet/IndexMessage">主页</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="/Hotel/servlet/ShowShopCar">查看购物车</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/Hotel/servlet/ShowOrder">查看订单</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="ModifySelfMsg.jsp">修改个人信息</a>
	      </li> 
	      <li class="nav-item">
	        <a class="nav-link" href="Login.jsp">登录</a>
	      </li>   
	      <li class="nav-item">
	        <a class="nav-link" href="Register.jsp">注册</a>
	      </li> 
	      <li class="nav-item">
	        <a class="nav-link" href="/Hotel/servlet/UserLogout">注销</a>
	      </li>  
	    </ul>
	  </div>  
	</nav>
	<br/>
  
    <table border="2" align="center">
   		<tr>
   			<td>订单号</td>
   			<td>房间号</td>
   			<td>房间类型</td>
   			<td>姓名</td>
   			<td>身份证号</td>
   			<td>入住时间</td>
   			<td>入住天数</td>
   			<td>早餐份数</td>
   			<td>订单价格</td>
   			<td>订单时间</td>
   			<td></td>
   		</tr>
   		<c:forEach var="item" items="${HistoryOrder}">
   		<tr>
   			<form action="/Hotel/servlet/DeletHistoryOrder" method="post">
   			<td><input type="text" name="IDOrder" style="border-style:none none none none;" value="${item.getIDOrder()}" readOnly="true" /></td>
   			<td>${item.getIDRoom()}</td>
   			<td>${item.getTypeRoom()}</td>
   			<td>${item.getRealName()}</td>
   			<td>${item.getIDNumber()}</td>
   			<td>${item.getTimeHousing()}</td>
   			<td>${item.getDayHousing()}</td>
   			<td>${item.getHaveBreakfast()}</td>
   			<td>${item.getAllPrice()}</td>
   			<td>${item.getTimeOrder()}</td>
   			<td><input type="submit" value="删除" ></td>
   			</form>
   		</tr>
   		</c:forEach>
   		<tr align="center"><p class="text-danger">${ErrorMsg}</p></tr>
   		
   		
   	<script src="js/jquery-3.3.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/popper.js"></script>
  </body>
</html>
