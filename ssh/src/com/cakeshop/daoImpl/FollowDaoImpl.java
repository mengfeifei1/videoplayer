package com.cakeshop.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.FollowBean;
import com.cakeshop.dao.FollowDao;
import com.cakeshop.dao.UserDao;
@Repository
public class FollowDaoImpl extends BaseDaoImpl implements FollowDao{

	@SuppressWarnings("unchecked")
	@Override
	public int findFollowByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql="from FollowBean where followUserId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, userId);
		List<FollowBean> followList=query.list();
		System.out.print(followList.toString());
		int count=followList.size();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findFollowedByUserId(int userId) {
		// TODO Auto-generated method stub
		String hql="from FollowBean where followedUserId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, userId);
		List<FollowBean> followList=query.list();
		int count=followList.size();
		return count;
	}

}
