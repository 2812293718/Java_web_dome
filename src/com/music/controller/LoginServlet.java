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
public class LoginServlet extends HttpServlet{//�����¼ҵ���servlet
public void doPost(HttpServletRequest request,HttpServletResponse response) {
	UserService us=new UserService();//����ҵ������
	HttpSession session=request.getSession();//��request���� session
//1.��������
	//����post�ύ��ʽ�µ�����
	try {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	} catch (UnsupportedEncodingException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}	
	String uname=request.getParameter("uname");
	String upassword=request.getParameter("upassword");	
//2.����ҵ������ҵ��������ҵ��
	Object[] param= {uname};
	int i=us.login(param, upassword);
	
//3.���ݴ���Ľ��ʵ��ҳ�����ת,��ת��ʽ ��ת�����ض���ת����������request����������
	if(i==1)
	{
		//����������ת��session request(����)
		session.setAttribute("username", uname);
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	if(i==0) {
		request.setAttribute("msg", "�������");
		try {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
		
	if(i==-1) {
		request.setAttribute("msg", "�û�������");
		try {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
}
public void doGet(HttpServletRequest request,HttpServletResponse response) {
	doPost(request,response);
	
}
}
