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
    
    <title>My JSP 'RoomDetail.jsp' starting page</title>
    
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
  
    <form action="/Hotel/servlet/PutToShopCar" method="post">
    	<table align="center" border="2">
    		<tr><td colspan="2" align="center"><p class="text-primary">房间详情</p></td></tr>
    		<tr>
    			<td>房间类型</td>
    			<td>${TypeRoom}</td>
    		</tr>
    		<tr>
    			<td>房间号</td>
    			<td><input type="text" name="IDRoom" readOnly="true" value="${IDRoom}" /></td>
    		</tr>
    		<tr>
    			<td>入住时间</td>
    			<td>
    			<select name="Year">			 
    				<c:forEach var="year" begin="${CurrentYear}" end="${CurrentYear}">
    					<option value="${year}">${year}</option>
    				</c:forEach>
    			</select>年
   				<select name="Month">			
	   				<c:forEach var="month" begin="${CurrentMonth}" end="${CurrentMonth}">
	   					<option value="${month}">${month}</option>
	   				</c:forEach>
   				</select>月
   				<select name="Day">			
    				<c:forEach var="day" begin="${CurrentDay}" end="${MonthLastDay}">
    					<option value="${day}">${day}</option>
    				</c:forEach>  			
    			</select>日
    			</td>
    		</tr>
    		<tr>
    			<td>入住天数</td>
    			<td>
    			<select name="DayHousing">			
    				<c:forEach var="day" begin="1" end="${MaxDay}">
    					<option value="${day}">${day}</option>
    				</c:forEach>
    			</select>
    			</td>
    		</tr>
    		<tr>
    			<td>入住人姓名</td>
    			<td><input type="text" name="RealName"/></td>
    		</tr>
    		<tr>
    			<td>入住人身份证号</td>
    			<td><input type="text" name="IDNumber"/></td>
    		</tr>
    		<tr>
    			<td>早餐份数</td>
    			<td>
					<select name="HavaBreakfast">			
    				<c:forEach var="num" begin="0" end="9">
    					<option value="${num}">${num}</option>
    				</c:forEach>
    			</select>
				</td>
    		</tr>
    		<tr>
    			<td>价格</td>
    			<td><input type="text" name="PriceRoom" readOnly="true" value="${PriceRoom}" /></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="添加至购物车" /></td>
    		</tr>
    	</table>
    </form>
    
    <script src="js/jquery-3.3.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/popper.js"></script>
  </body>
</html>
