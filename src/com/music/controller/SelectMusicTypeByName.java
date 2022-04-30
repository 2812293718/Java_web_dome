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
import com.music.po.MusicType;
import com.music.service.MusicService;
import com.music.service.MusicTypeService;

@WebServlet("/selectMusicTypeByName")
public class SelectMusicTypeByName extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicTypeService mts=new MusicTypeService();//创建业务层对象
		MusicService ms=new MusicService();//创建业务层对象
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		String typename=request.getParameter("typename");	
		Object[] param= {typename};
		List<Music> mlist=mts.selectMusicByName(param);
		System.out.println(mlist.size());
		request.setAttribute("musiclist", mlist);
		try {
			request.getRequestDispatcher("hy_list2.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
		
	}
}

