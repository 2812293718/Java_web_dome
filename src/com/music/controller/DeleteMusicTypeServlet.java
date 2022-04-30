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

@WebServlet("/deleteMusicTypeServlet")
public class DeleteMusicTypeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8431462879873719388L;
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		MusicTypeService mts=new MusicTypeService();//创建设备业务层对象		
		try {//post提方式下的乱码处理
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		
		String mtypeid=request.getParameter("mtypeid");
		System.out.println(mtypeid);
		Object[] param= {mtypeid};
		int status=mts.deleteMusicType(param);
		System.out.println(status);
		if(status>0) {
			Object[] param2= {};
			List<MusicType> mtlist=mts.selectAllMusicType(param2);
			request.setAttribute("musictypelist", mtlist);
			request.setAttribute("msg", "音乐类型删除成功");
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
		else
		{
			request.setAttribute("msg", "音乐类型删除失败");
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
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response);
		
	}
}



