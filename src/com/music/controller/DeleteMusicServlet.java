package com.music.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.po.Music;
import com.music.service.MusicService;
@WebServlet("/deleteMusicServlet")
public class DeleteMusicServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8431462879873719388L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicService ms=new MusicService();//�����豸ҵ������		
		try {//post�᷽ʽ�µ����봦��
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
		
		String mid=request.getParameter("mid");
		Object[] param= {mid};
		int status=ms.deleteMusic(param);
		if(status>0) {
			Object[] param2= {};
			List<Music> mlist=ms.selectAllMusic(param2);
			request.setAttribute("musiclist", mlist);
			request.setAttribute("msg", "����ɾ���ɹ�");
		try {
			
			request.getRequestDispatcher("hy_list.jsp").forward(request, response);
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
			request.setAttribute("msg", "����ɾ��ʧ��");
			try {
				request.getRequestDispatcher("hy_list.jsp").forward(request, response);
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


