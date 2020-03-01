package com.cakeshop.dao;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.UserBean;


@Repository
public interface UserDao {
	public UserBean findPerPerson(int userid);
	public UserBean findUserByUserTel(String  userTelephone);
	public int insertUser(UserBean user);
	public UserBean findUserByUserPhone(String userTelephone);
	public void changeUserPswd(UserBean user);
	public  void updateUser(UserBean user);
	public void updateUserPhoto(UserBean user);
	
}
