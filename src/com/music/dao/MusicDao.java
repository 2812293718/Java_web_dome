package com.music.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.music.po.Music;
import com.music.po.User;
import com.music.util.DBUtil2;

public class MusicDao {
	public int deleteMusic(Object [] param) {//参数通过形参列表传入
		String sql="delete from music where mid=?";
		return DBUtil2.executeUpdate(sql,param);
	}
	public int updateMusic(Object [] param) {
		String sql="update music set musicname=?,musiccountry=?,musicdate=?,mtypeid=?  where mid=?";
		return DBUtil2.executeUpdate(sql,param);
	}
	public int insertMusic(Object [] param) {
		
		String sql="insert into music(musicname,musiccountry,musicdate,mtypeid) values(?,?,?,?)";
		return DBUtil2.executeUpdate(sql,param);
	}
	public List<Music> selectAllMusic(Object [] param){
		List<Music> mlist=new ArrayList();
		String sql="select m.mid,m.musicname,m.musiccountry,m.musicdate,mt.typename from music m inner join musictype mt on m.mtypeid=mt.mtypeid";
		ResultSet rs=DBUtil2.executeQuery(sql,param);
	 try {
		while(rs.next())
		{
			Music m=new Music(rs.getInt("mid"),rs.getString("musicname"),rs.getString("musiccountry"),rs.getString("musicdate"),rs.getString("typename"));
			mlist.add(m);
			
		}
		rs.close();
		System.out.println(mlist.size());
	 }catch(SQLException se) {
		 se.printStackTrace();
	 }
		DBUtil2.close();
		return mlist;		
			
	}

	public List<Music> selectMusicByName(Object [] param) {
		List<Music> mlist=new ArrayList();
		String sql="select m.mid,m.musicname,m.musiccountry,m.musicdate,mt.typename from music m inner join musictype mt on m.mtypeid=mt.mtypeid where m.musicname=?";
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
	public Music selectMusicById(Object [] param) {
		Music music=null;
		String sql="select m.mid,m.musicname,m.musiccountry,m.musicdate,mt.typename from music m inner join musictype mt on m.mtypeid=mt.mtypeid where m.mid=?";
		ResultSet rs=DBUtil2.executeQuery(sql,param);
	 try {
		if(rs.next())
		{
			music=new Music(rs.getInt("mid"),rs.getString("musicname"),rs.getString("musiccountry"),rs.getString("musicdate"),rs.getString("typename"));
		}
		rs.close();
	 }catch(SQLException se) {
		 se.printStackTrace();
	 }
		DBUtil2.close();
		return music;	
		
	}
}
