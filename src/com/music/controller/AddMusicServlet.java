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
		MusicService ms=new MusicService();//创建设备业务层对象
		MusicTypeService mts=new MusicTypeService();//创建设备类型业务层对象
		try {//post提方式下的乱码处理
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		String musicname=request.getParameter("musicname");
		String musiccountry=request.getParameter("musiccountry"); 
		String musicdate=request.getParameter("musicdate"); 
		String musictype=request.getParameter("musictype");
		//在musictype中按musictype查找相应的mtypeid
		Object[] param1= {musictype};
		int mtypeid=mts.selectMusicType1ByName(param1);
		//在music表中插入一条记录
		Object[] param2= {musicname,musiccountry,musicdate,mtypeid};
		int status=ms.insertMusic(param2);

		if(status>0) {
			Object[] param3= {};
			List<Music> mlist=ms.selectAllMusic(param3);
			request.setAttribute("musiclist", mlist);
			request.setAttribute("msg", "音乐添加成功");
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
			request.setAttribute("msg", "音乐添加失败");
			try {
				request.getRequestDispatcher("addmusic.jsp").forward(request, response);
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

