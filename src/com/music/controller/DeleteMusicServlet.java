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
		MusicService ms=new MusicService();//创建设备业务层对象		
		try {//post提方式下的乱码处理
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		
		String mid=request.getParameter("mid");
		Object[] param= {mid};
		int status=ms.deleteMusic(param);
		if(status>0) {
			Object[] param2= {};
			List<Music> mlist=ms.selectAllMusic(param2);
			request.setAttribute("musiclist", mlist);
			request.setAttribute("msg", "音乐删除成功");
		try {
			
			request.getRequestDispatcher("hy_list.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}
		else
		{
			request.setAttribute("msg", "音乐删除失败");
			try {
				request.getRequestDispatcher("hy_list.jsp").forward(request, response);
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


