package com.music.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {//������bean,�������ݿ�����
private static Connection con;

public static Connection getCon() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("�������سɹ� ");
	} catch (ClassNotFoundException e) {
		// TODO �Զ����ɵ� catch ��
		System.out.println("��������ʧ�� ");
	}
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music?characterEncoding=utf-8", "root", "0000");
		System.out.println("���ݿ����ӳɹ� ");
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		System.out.println("���ݿ�����ʧ�� ");
	}
	return con;
}

public static void closeCon() {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
}
}
