package com.music.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.music.po.Music;
import com.music.po.MusicType;
import com.music.util.DBUtil2;

public class MusicTypeDao {
	public int deleteMusicType(Object [] param) {//参数通过形参列表传入
		String sql="delete from musictype where mtypeid=?";
		return DBUtil2.executeUpdate(sql,param);
	}
	public int updateMusicType(Object [] param) {
		String sql="update musictype set typename=?  where mtypeid=?";
		return DBUtil2.executeUpdate(sql,param);
	}
	public int insertMusicType(Object [] param) {
		
		String sql="insert into musictype(typename) values(?)";
		return DBUtil2.executeUpdate(sql,param);
	}
	public List<MusicType> selectAllMusicType(Object [] param){
		List<MusicType> mtlist=new ArrayList();
		String sql="select * from musictype";
		ResultSet rs=DBUtil2.executeQuery(sql,param);
	 try {
		while(rs.next())
		{
			MusicType mt=new MusicType(rs.getInt("mtypeid"),rs.getString("typename"));
			mtlist.add(mt);		
		}
		rs.close();
	 }catch(SQLException se) {
		 se.printStackTrace();
	 }
		DBUtil2.close();
		return mtlist;		
			
	}
	public List<Music> selectMusicByName(Object [] param) {
		List<Music> mlist=new ArrayList();
		String sql="select * from music where mtypeid in (select musictype from musictype where typename=?)";
		ResultSet rs=DBUtil2.executeQuery(sql,param);
	 try {
		while(rs.next())
		{
			Music m=new Music(rs.getInt("mid"),rs.getString("musicname"),rs.getString("musiccountry"),rs.getString("musicdate"),rs.getString("typename"));
			mlist.add(m);
		}
		rs.close();
	 }catch(SQLException se) {
		 se.printStackTrace();
	 }
		DBUtil2.close();
		return mlist;	
		
	}
	public int selectMusicType1ByName(Object [] param) {
		int mtypeid=0;
		String sql="select mtypeid from musictype where typename=?";
		ResultSet rs=DBUtil2.executeQuery(sql,param);
	 try {
		if(rs.next())
			mtypeid=rs.getInt("mtypeid");
		rs.close();
	 }catch(SQLException se) {
		 se.printStackTrace();
	 }
		DBUtil2.close();
		return mtypeid;	
		
	}
	public MusicType selectMusicTypeById(Object [] param) {
		MusicType musictype=null;
		String sql="select * from musictype where mtypeid=?";
		ResultSet rs=DBUtil2.executeQuery(sql,param);
	 try {
		if(rs.next())
		{
			musictype=new MusicType(rs.getInt("mtypeid"),rs.getString("typename"));
		}
		rs.close();
	 }catch(SQLException se) {
		 se.printStackTrace();
	 }
		DBUtil2.close();
		return musictype;	
		
	}
}