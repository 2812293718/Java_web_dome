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
@WebServlet("/selectAllMusicTypeServlet")
public class SelectAllMusicTypeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5865590127819354042L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicTypeService mts=new MusicTypeService();//创建业务层对象
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		Object[] param= {};
		List<MusicType> mtlist=mts.selectAllMusicType(param);
		System.out.println(mtlist.size());
		System.out.println("11111111111");
		request.setAttribute("musictypelist", mtlist);
		try {
			request.getRequestDispatcher("hy_list3.jsp").forward(request, response);
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

