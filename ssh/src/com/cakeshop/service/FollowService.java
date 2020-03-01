package com.cakeshop.service;

import com.cakeshop.dao.FollowDao;

public interface FollowService {
	public int findFollowByUserId(int userId);
	public int findFollowedByUserId(int userId);
}
