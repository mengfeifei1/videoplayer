package com.cakeshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakeshop.bean.UserBean;



public interface UserService {
	public void addUser(UserBean user);
	public UserBean findPerson(int userid);
	public boolean isExistUser(String userPhone);
	public UserBean findUserByUserTel(String userPhone);
	public int insertUser(UserBean user);
	public UserBean findUserByUserPhone(String userPhone);
	public void changeUserPswd(UserBean user);
	public void updateUser(UserBean user);
	public void updateUserPhoto(UserBean user);
}
