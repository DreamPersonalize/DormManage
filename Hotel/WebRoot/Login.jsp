<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
  
    	<form action="/Hotel/servlet/UserLogin" method="post" >
    	<table align="center" border="2" >
    		<tr><td colspan="2" align="center"><p class="text-primary">用户登录</p></td></tr>
    		<tr>
    			<td>用户名</td>
    			<td><input type="text" name="NickName" value="${user.getNickName()}" /></td>
    		</tr><br/>
    		<tr>
    			<td>密码</td>
    			<td><input type="password" name="Password" value="${user.getPassword()}" /></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="right"><input type="checkbox" name="AutomaticLogon" value="yes" checked="checked" />下次自动登录</td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><span class="text-danger">${errMsg}</span></td>
    		</tr>
    		<tr>
    			<td align="center"><input type="submit" value="登录"/></td>
    			<td align="center" ><input type="button" value="注册" onClick="window.location.href='Register.jsp'"/></td>
    		</tr>
    	</table>
    	</form>
    <script src="js/jquery-3.3.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/popper.js"></script>
  </body>
</html>
