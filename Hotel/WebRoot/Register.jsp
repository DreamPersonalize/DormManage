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
    
    <title>用户注册</title>
    
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
  
  		<form action="/Hotel/servlet/UserRegister" method="post">
    	<table align="center" border="2" >
    		<tr><td colspan="2" align="center"><p class="text-primary">用户注册</p></td></tr>
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" name="NickName"/>
    				<span class="text-warning">${user.errors.NickName}</span></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="password" name="Password" />
    				<span class="text-warning">${user.errors.Password}</span></td>
    		</tr>
    		<tr>
    			<td>确认密码</td>
    			<td><input type="password" name="RePassword" />
    				<span class="text-warning">${user.errors.RePassword}</span></td>
    		</tr>
    		<tr>
    			<td>真实姓名</td>
    			<td><input type="text" name="RealName" />
    				<span class="text-warning">${user.errors.RealName}</span></td>
    		</tr>
    		<tr>
    			<td>年龄</td>
    			<td>
    			<select name="Age">			
    				<c:forEach var="age" begin="7" end="100">
    					<option value="${age}">${age}</option>
    				</c:forEach>
    			</select>
    				<span class="text-danger">${user.errors.Age}</span></td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td>
    				<input type="radio" name="Sex" value="man" checked />man<br/>
    				<input type="radio" name="Sex" value="woman"/>woman
    				<span class="text-danger">${user.errors.Sex}</span><br/>
    			</td>
    		</tr>
    		<tr>
    			<td>身份证号</td>
    			<td><input type="text" name="IDNumber" />
    				<span class="text-danger">${user.errors.IDNumber}</span></td>
    		</tr>
    		<tr>
    			<td>电话号码</td>
    			<td><input type="text" name="Phone" />
    				<span class="text-danger">${user.errors.Phone}</span></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="注册" /></td>
    			<td><input type="reset" value="重置" /></td>
    		</tr>
    	</table>
    <script src="js/jquery-3.3.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/popper.js"></script>
  </body>
  </form>
</html>
