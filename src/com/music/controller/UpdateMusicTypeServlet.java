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
import com.music.service.MusicTypeService;
@WebServlet("/updateMusicTypeServlet")
public class UpdateMusicTypeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6558109470194053575L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicTypeService mts=new MusicTypeService();//�����豸����ҵ������
		try {//post�᷽ʽ�µ����봦��
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		String smtypeid=request.getParameter("mtypeid");
		String typename=request.getParameter("typename");
		
		//��music���в���һ����¼
		Object[] param= {typename,smtypeid};
		int status=mts.updateMusicType(param);

		if(status>0) {
			Object[] param2= {};
			List<MusicType> mtlist=mts.selectAllMusicType(param2);
			request.setAttribute("musictypelist", mtlist);
			request.setAttribute("msg", "����������Ϣ�޸ĳɹ�");
		try {
			
			request.getRequestDispatcher("hy_list3.jsp").forward(request, response);
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
			request.setAttribute("msg", "����������Ϣ�޸�ʧ��");

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
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
		
	}
}

