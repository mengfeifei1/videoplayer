package com.cakeshop.serviceimpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cakeshop.bean.UserBean;
import com.cakeshop.dao.UserDao;
import com.cakeshop.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 根据手机号判断用户是否存在
	 */
	public boolean isExistUser(String userPhone) {
		UserBean user =userDao.findUserByUserTel(userPhone);
		if(user!= null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	
	
	
	@Override
	public UserBean findPerson(int userid) {
		// TODO Auto-generated method stub
		return userDao.findPerPerson(userid);
	}
	@Override
	public UserBean findUserByUserTel(String userPhone) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserTel(userPhone);
	}
	@Override
	public int insertUser(UserBean user) {
		System.out.print("registerservice");
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
		
	}
	@Override
	public UserBean findUserByUserPhone(String userPhone) {
		// TODO Auto-generated method stub
		
		return userDao.findUserByUserPhone(userPhone);
	}
	@Override
	public void changeUserPswd(UserBean user) 
	{
		// TODO Auto-generated method stub
		userDao.changeUserPswd(user);
		
	}
	@Override
	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
		
	}
	public void updateUserPhoto(UserBean user) {
		userDao.updateUserPhoto(user);
	}



}
