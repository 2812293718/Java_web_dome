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
@WebServlet("/updateMusicServlet")
public class UpdateMusicServlet extends HttpServlet{
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
		String smid=request.getParameter("mid");
		String musicname=request.getParameter("musicname");
		String musiccountry=request.getParameter("musiccountry"); 
		String musicdate=request.getParameter("musicdate"); 
		String musictype=request.getParameter("musictype");
		
		//在musictype中按musictype查找相应的mtypeid
		Object[] param1= {musictype};
		int mtypeid=mts.selectMusicType1ByName(param1);
		int mid=Integer.parseInt(smid);
		//在music表中插入一条记录
		Object[] param= {musicname,musiccountry,musicdate,mtypeid,mid};
		int status=ms.updateMusic(param);

		if(status>0) {
			Object[] param2= {};
			List<Music> mlist=ms.selectAllMusic(param2);
			request.setAttribute("musiclist", mlist);
			request.setAttribute("msg", "音乐信息修改成功");
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
			request.setAttribute("msg", "音乐信息修改失败");

			try {
				request.getRequestDispatcher("updatemusic.jsp").forward(request, response);
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

