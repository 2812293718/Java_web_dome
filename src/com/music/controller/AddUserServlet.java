package com.music.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.music.po.User;
import com.music.service.UserService;
import com.music.dao.UserDao;
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		UserService us=new UserService();//����ҵ������
		HttpSession session=request.getSession();//��request���� session
		try {//post�᷽ʽ�µ����봦��
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
		String uid=request.getParameter("uid");
		String uname=request.getParameter("uname");
		String upassword=request.getParameter("upassword"); 
		//��userinfo���в���һ����¼
		Object[] param1= {uid,uname,upassword};
		int status=us.insertUser(param1);
		System.out.println(1222222222);
		if(status>0) {
			Object[] param3= {};
			List<User> ulist=us.selectAllUser(param3);
			request.setAttribute("ulist", ulist);
			request.setAttribute("msg", "�û���ӳɹ�");
			System.out.println(11111111);
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
		else
		{
			request.setAttribute("msg", "�û����ʧ��");
			System.out.println(3333333);
			try {
				request.getRequestDispatcher("register.jsp").forward(request, response);
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


