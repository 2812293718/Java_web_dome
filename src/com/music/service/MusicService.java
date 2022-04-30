package com.music.service;

import java.util.List;

import com.music.po.Music;
import com.music.dao.MusicDao;
import com.music.po.Music;


public class MusicService {
	private MusicDao md=new MusicDao();
	
	public int insertMusic(Object [] param) {
		return md.insertMusic(param);
	} 
	public int deleteMusic(Object [] param) {
		return md.deleteMusic(param);
	}

	public int updateMusic(Object [] param) {
		return md.updateMusic(param);
	}
	public List<Music> selectAllMusic(Object [] param) {
		return md.selectAllMusic(param);
	}
	public List<Music> selectMusicByName(Object [] param) {
		return md.selectMusicByName(param);
	}
	public Music selectMusicById(Object [] param) {
		return md.selectMusicById(param);
	}
}
