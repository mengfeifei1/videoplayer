package com.cakeshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.VideoBean;
import com.cakeshop.dao.ShoucangDao;

@Repository
public class ShoucangDaoImpl extends BaseDaoImpl implements ShoucangDao {

	@Override
	public List<ShoucangBean> GetShouList(int videoId,int userId) {
		// TODO Auto-generated method stub
		List<ShoucangBean> shouList = new ArrayList<>();
		String sql = "select * from shoucang where video_id = ? and user_id = ?";
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(ShoucangBean.class);
		query.setParameter(0, videoId);
		query.setParameter(1, userId);
		shouList = query.list();
		return shouList;
	}

}
