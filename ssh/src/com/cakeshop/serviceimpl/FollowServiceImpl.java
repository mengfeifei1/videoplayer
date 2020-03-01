package com.cakeshop.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop.dao.FollowDao;
import com.cakeshop.service.FollowService;
@Service
public class FollowServiceImpl implements FollowService{
	@Autowired
	private FollowDao followDao;
	@Override
	public int findFollowByUserId(int userId) {
		// TODO Auto-generated method stub
		
		return followDao.findFollowByUserId(userId);
	}
	@Override
	public int findFollowedByUserId(int userId) {
		// TODO Auto-generated method stub
		return followDao.findFollowedByUserId(userId);
	}

}
