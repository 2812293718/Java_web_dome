package com.music.po;

public class Music {
private int mid;
private String musicname;
private String musiccountry;
private String musicdate;
private String musictype;//πÿ¡™ Ù–‘

public Music() {
	
}
public Music( String musicname, String musiccountry, String musicdate, String musictype) {

	this.musicname = musicname;
	this.musiccountry = musiccountry;
	this.musicdate = musicdate;
	this.musictype = musictype;
}
public Music(int mid, String musicname, String musiccountry, String musicdate, String musictype) {
	
	this.mid = mid;
	this.musicname = musicname;
	this.musiccountry = musiccountry;
	this.musicdate = musicdate;
	this.musictype = musictype;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMusicname() {
	return musicname;
}
public void setMusicname(String musicname) {
	this.musicname = musicname;
}
public String getMusiccountry() {
	return musiccountry;
}
public void setMusiccountry(String musiccountry) {
	this.musiccountry = musiccountry;
}
public String getMusicdate() {
	return musicdate;
}
public void setMusicdate(String musicdate) {
	this.musicdate = musicdate;
}
public String getMusictype() {
	return musictype;
}
public void setMusictype(String musictype) {
	this.musictype = musictype;
}
@Override
public String toString() {
	return "Device [mid=" + mid + ", musicname=" + musicname + ", musiccountry=" + musiccountry + ", musicdate="
			+ musicdate + ", musictype=" + musictype + "]";
}

}
