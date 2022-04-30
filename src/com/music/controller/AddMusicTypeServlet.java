package com.music.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.po.MusicType;
import com.music.po.Music;
import com.music.service.MusicService;
import com.music.service.MusicTypeService;
@WebServlet("/addMusicTypeServlet")
public class AddMusicTypeServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicService ms=new MusicService();//�����豸ҵ������
		MusicTypeService mts=new MusicTypeService();//�����豸����ҵ������
		try {//post�᷽ʽ�µ����봦��
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
		String typename=request.getParameter("typename");
		//��music���в���һ����¼
		Object[] param2= {typename};
		int status=mts.insertMusicType(param2);

		if(status>0) {
			Object[] param3= {};
			List<MusicType> mtlist=mts.selectAllMusicType(param3);
			request.setAttribute("musictypelist", mtlist);
			request.setAttribute("msg", "����������ӳɹ�");
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
			request.setAttribute("msg", "�����������ʧ��");
			try {
				request.getRequestDispatcher("addmusictype.jsp").forward(request, response);
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


