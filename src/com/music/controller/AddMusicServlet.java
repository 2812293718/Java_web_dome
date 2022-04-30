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
import com.music.service.MusicTypeService;
@WebServlet("/addMusicServlet")
public class AddMusicServlet extends HttpServlet{
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
		String musicname=request.getParameter("musicname");
		String musiccountry=request.getParameter("musiccountry"); 
		String musicdate=request.getParameter("musicdate"); 
		String musictype=request.getParameter("musictype");
		//��musictype�а�musictype������Ӧ��mtypeid
		Object[] param1= {musictype};
		int mtypeid=mts.selectMusicType1ByName(param1);
		//��music���в���һ����¼
		Object[] param2= {musicname,musiccountry,musicdate,mtypeid};
		int status=ms.insertMusic(param2);

		if(status>0) {
			Object[] param3= {};
			List<Music> mlist=ms.selectAllMusic(param3);
			request.setAttribute("musiclist", mlist);
			request.setAttribute("msg", "������ӳɹ�");
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
			request.setAttribute("msg", "�������ʧ��");
			try {
				request.getRequestDispatcher("addmusic.jsp").forward(request, response);
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

