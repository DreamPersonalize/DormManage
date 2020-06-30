package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.Model.User;

/*登录过滤*/
public class AutoLoginFilter implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request= (HttpServletRequest) req;
		Cookie[] cookies = request.getCookies();	//获取cookie
		String autologin = null;
		for(int i=0; cookies != null && i < cookies.length; i++){
			if(cookies[i].getName().equals("autologin")){
				autologin = cookies[i].getValue(); break;
			}
		}
		
		if(autologin != null){
			String[] parts = autologin.split("-");
			String username = parts[0];
			String password = parts[1];
			User user = new User();
			user.setNickName(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}
	
}
