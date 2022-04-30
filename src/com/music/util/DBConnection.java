package com.music.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {//工具类bean,管理数据库连接
private static Connection con;

public static Connection getCon() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("驱动加载成功 ");
	} catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		System.out.println("驱动加载失败 ");
	}
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music?characterEncoding=utf-8", "root", "0000");
		System.out.println("数据库连接成功 ");
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		System.out.println("数据库连接失败 ");
	}
	return con;
}

public static void closeCon() {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}
}
