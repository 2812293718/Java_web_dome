package com.music.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.music.service.UserService;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{//处理登录业务的servlet
public void doPost(HttpServletRequest request,HttpServletResponse response) {
	UserService us=new UserService();//创建业务层对象
	HttpSession session=request.getSession();//用request生成 session
//1.接收数据
	//处理post提交方式下的乱码
	try {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	} catch (UnsupportedEncodingException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}	
	String uname=request.getParameter("uname");
	String upassword=request.getParameter("upassword");	
//2.处理业务，利用业务层对象处理业务
	Object[] param= {uname};
	int i=us.login(param, upassword);
	
//3.根据处理的结果实现页面的跳转,跳转方式 ：转发和重定向，转发可以延伸request的生命周期
	if(i==1)
	{
		//带着数据跳转，session request(常用)
		session.setAttribute("username", uname);
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	if(i==0) {
		request.setAttribute("msg", "密码错误");
		try {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
		
	if(i==-1) {
		request.setAttribute("msg", "用户不存在");
		try {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
public void doGet(HttpServletRequest request,HttpServletResponse response) {
	doPost(request,response);
	
}
}
