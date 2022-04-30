package com.music.po;

public class MusicType {
private int mtypeid;
private String typename;

public MusicType() {

}
public MusicType(String typename) {
	
	this.typename = typename;
}
public MusicType(int mtypeid, String typename) {
	this.mtypeid = mtypeid;
	this.typename = typename;
}
public int getMtypeid() {
	return mtypeid;
}
public void setMtypeid(int mtypeid) {
	this.mtypeid = mtypeid;
}
public String getTypename() {
	return typename;
}
public void setTypename(String typename) {
	this.typename = typename;
}
@Override
public String toString() {
	return "MusicType [mtypeid=" + mtypeid + ", typename=" + typename + "]";
}

}
