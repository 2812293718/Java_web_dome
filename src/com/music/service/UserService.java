package com.music.service;

import java.util.List;

import com.music.dao.UserDao;
import com.music.po.User;
import com.music.util.DBUtil2;

public class UserService {//业务层，服务层,基于dao来实现
private UserDao ud=new UserDao();
public int register(Object [] param) {
	 return ud.insertUser(param);
}

public int login(Object [] param,String upassword) {
	return ud.selectByUser(param,upassword);
}

public int insertUser(Object [] param) {
	
	return ud.insertUser(param);
}
public int deleteUser(Object [] param) {
	return ud.deleteUser(param);
}

public int updateUser(Object [] param) {
	return ud.updateUser(param);
}
public List<User> selectAllUser(Object [] param) {
	return ud.selectAllUser(param);
}
public User selectByName(Object [] param) {
	return ud.selectByName(param);
}

}
