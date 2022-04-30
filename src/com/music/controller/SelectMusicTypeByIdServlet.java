package com.music.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.po.MusicType;
import com.music.service.MusicTypeService;

@WebServlet("/selectMusicTypeByIdServlet")
public class SelectMusicTypeByIdServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1500279987579934693L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicTypeService mts=new MusicTypeService();//����ҵ������
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
		String mtypeid=request.getParameter("mtypeid");	
		System.out.println(mtypeid);
		Object[] param= {mtypeid};
		MusicType musictype=mts.selectMusicTypeById(param);

		request.setAttribute("musictype", musictype);
		try {
			request.getRequestDispatcher("updatemusictype.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
		
	}
}

