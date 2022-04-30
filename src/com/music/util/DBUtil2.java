package com.music.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil2 {//����Ԥ������䣬�Ƽ�
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;

	public static int executeUpdate(String sql,Object [] param) {
		int i=0;
		con=DBConnection.getCon();
		try {
			ps=con.prepareStatement(sql);//1.����PreparedStatement����
			//2.ע�����
			for(int j=0;j<param.length;j++)
				ps.setObject(j+1, param[j]);
			//3.ִ��sql���
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		close();
		return i;
	}


	public static ResultSet executeQuery(String sql,Object [] param) {
		con=DBConnection.getCon();
		try {
			ps=con.prepareStatement(sql);//1.����PreparedStatement����
			//2.ע�����
			for(int j=0;j<param.length;j++)
				ps.setObject(j+1, param[j]);
			//3.ִ��sql���
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//����Ĵ���û���������ݵķ�װ ����Ҫ�Ż�	
		return rs;
	}
	public static void close() {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
}
