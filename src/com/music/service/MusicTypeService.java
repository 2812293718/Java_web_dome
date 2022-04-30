package com.music.service;

import java.util.List;

import com.music.dao.MusicDao;
import com.music.dao.MusicTypeDao;
import com.music.po.MusicType;
import com.music.po.Music;

public class MusicTypeService {
private MusicTypeDao mt=new MusicTypeDao();
private MusicDao m=new MusicDao();
	
	public int insertMusicType(Object [] param) {
		return mt.insertMusicType(param);
	} 
	public int deleteMusicType(Object [] param) {
		return mt.deleteMusicType(param);
	}

	public int updateMusicType(Object [] param) {
		return mt.updateMusicType(param);
	}
	public List<MusicType> selectAllMusicType(Object [] param) {
		return mt.selectAllMusicType(param);
	}
	public List<Music> selectMusicByName(Object [] param) {
		return m.selectMusicByName(param);
	}
	public int selectMusicType1ByName(Object [] param) {
		return mt.selectMusicType1ByName(param);
	}
	public MusicType selectMusicTypeById(Object [] param) {
		return mt.selectMusicTypeById(param);
	}
}