package com.music.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil2 {//基于预处理语句，推荐
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public static int executeUpdate(String sql,Object [] param) {
		int i=0;
		con=DBConnection.getCon();
		try {
			ps=con.prepareStatement(sql);//1.生成PreparedStatement对象
			//2.注入参数
			for(int j=0;j<param.length;j++)
				ps.setObject(j+1, param[j]);
			//3.执行sql语句
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		close();
		return i;
	}


	public static ResultSet executeQuery(String sql,Object [] param) {
		con=DBConnection.getCon();
		try {
			ps=con.prepareStatement(sql);//1.生成PreparedStatement对象
			//2.注入参数
			for(int j=0;j<param.length;j++)
				ps.setObject(j+1, param[j]);
			//3.执行sql语句
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//这里的代码没有做好数据的封装 ，需要优化	
		return rs;
	}
	public static void close() {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
