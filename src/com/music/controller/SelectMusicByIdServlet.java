package com.music.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.po.Music;
import com.music.service.MusicService;
@WebServlet("/selectMusicByIdServlet")
public class SelectMusicByIdServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1500279987579934693L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicService ms=new MusicService();//����ҵ������
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
		String mid=request.getParameter("mid");	
		System.out.println(mid);
		Object[] param= {mid};
		Music music=ms.selectMusicById(param);

		request.setAttribute("music", music);
		try {
			request.getRequestDispatcher("updatemusic.jsp").forward(request, response);
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


