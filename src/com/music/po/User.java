package com.music.po;

public class User {//databean，数据存储层
private int uid;
private String uname;
private String upassword;

public User() {
	
}

public User(int uid) {
	this.uid = uid;
}

public User( String uname, String upassword) {
	
	this.uname = uname;
	this.upassword = upassword;
}


public User(int uid, String uname, String upassword) {
	
	this.uid = uid;
	this.uname = uname;
	this.upassword = upassword;
}

public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUpassword() {
	return upassword;
}
public void setUpassword(String upassword) {
	this.upassword = upassword;
}

@Override
public String toString() {
	return "用户 [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + "]";
}

}
