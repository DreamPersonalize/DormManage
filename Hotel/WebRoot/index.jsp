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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
  
	  <ul class="nav nav-pills" role="tablist">
	    <li class="nav-item">
	      <a class="nav-link active" data-toggle="pill" href="#home">单人房</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" data-toggle="pill" href="#menu1">大床房</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" data-toggle="pill" href="#menu2">双床房</a>
	    </li>
	  </ul>
	
	  <!-- Tab panes -->
	  <div class="tab-content">
	    <div id="home" class="container tab-pane active"><br>
      		<div class="container mt-3">			 
			  <div class="d-flex justify-content-around bg-secondary mb-3">
				  	<c:forEach var="item" items="${SinglePerson}">
						<div class="p-2 bg-info">
							<div  onclick="window.location.href='/Hotel/servlet/ShowRoomDetail?TypeRoom=单人房&SubclassRoom=${item.getSubclassRoom()}'"><p class="text-warning">${item.getSubclassRoom()}</p></div>
							
						</div>
	    			</c:forEach>
			  </div>
			</div>
	    </div>
	    <div id="menu1" class="container tab-pane fade"><br>
			<div class="container mt-3">			 
			  <div class="d-flex justify-content-around bg-secondary mb-3">
				  	<c:forEach var="item" items="${BigBed}">
						<div class="p-2 bg-info">
	 								<div onclick="window.location.href='/Hotel/servlet/ShowRoomDetail?TypeRoom=大床房&SubclassRoom=${item.getSubclassRoom()}'"><p class="text-warning">${item.getSubclassRoom()}</p></div>
						</div>
					</c:forEach>
			  </div>
			</div>
	    </div>
	    <div id="menu2" class="container tab-pane fade"><br>
	    	<div class="container mt-3">	
	    	<div class="d-flex justify-content-around bg-secondary mb-3">
				<c:forEach var="item" items="${DoublePerson}">
							<div class="p-2 bg-info">
	  								<div  onclick="window.location.href='/Hotel/servlet/ShowRoomDetail?TypeRoom=双人房&SubclassRoom=${item.getSubclassRoom()}'"><p class="text-warning">${item.getSubclassRoom()}</p></div>
								
							</div>
	   			</c:forEach>
   			</div>
   			</div>
	    </div>
	  </div>

	<script src="js/jquery-3.3.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/popper.js"></script>
  </body>
</html>
