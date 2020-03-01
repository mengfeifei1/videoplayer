package com.cakeshop.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface FollowDao {
	public int findFollowByUserId(int userId);
	public int findFollowedByUserId(int userId);
	

}
