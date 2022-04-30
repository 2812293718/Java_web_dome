package com.music.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.music.po.User;
import com.music.util.DBUtil2;

public class UserDao {//���ݲ�����

public int deleteUser(Object [] param) {//����ͨ���β��б���
	String sql="delete from userinfo where uid=?";
	return DBUtil2.executeUpdate(sql,param);
}
public int updateUser(Object [] param) {
	String sql="update userinfo set uname=?,upassword=?  where uid=?";
	return DBUtil2.executeUpdate(sql,param);
}
public int insertUser(Object [] param) {
	
	String sql="insert into userinfo values(?,?,?)";
	return DBUtil2.executeUpdate(sql,param);
}
public List<User> selectAllUser(Object [] param){
	List<User> ulist=new ArrayList();
	String sql="select * from userinfo";
	ResultSet rs=DBUtil2.executeQuery(sql,param);
 try {
	while(rs.next())
	{
		User u=new User(rs.getInt("uid"),rs.getString("uname"),rs.getString("upassword"));
		ulist.add(u);
	}
	rs.close();
 }catch(SQLException se) {
	 se.printStackTrace();
 }
	DBUtil2.close();
	return ulist;
	
		
}
public int selectByUser(Object [] param,String upassword) {//�����¼��һ����
	int i=-1;
	String sql="select * from userinfo where uname=?";
	ResultSet rs=DBUtil2.executeQuery(sql,param);
	 try {
	if(rs.next())
	{
		if(rs.getString("upassword").equals(upassword))
			i=1;//��֤�ɹ�
		else
			i=0;//�������			
	}else
		i=-1;//�û�������
	    rs.close();
	 }catch(SQLException se) {
		 se.printStackTrace();
	 }
	DBUtil2.close();
	return i;
}
public User selectByName(Object [] param) {
	User u=null;
	String sql="select * from userinfo where uname=?";
	ResultSet rs=DBUtil2.executeQuery(sql,param);
 try {
	if(rs.next())
	{
		u=new User(rs.getInt("uid"),rs.getString("uname"),rs.getString("upassword"));
	}
	rs.close();
 }catch(SQLException se) {
	 se.printStackTrace();
 }
	DBUtil2.close();
	return u;
	
}
}
