package com.cakeshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.ZanBean;
import com.cakeshop.dao.ZanDao;
@Repository
public class ZanDaoImpl extends BaseDaoImpl implements ZanDao{

	@Override
	public void addZan(ZanBean zan) {
		// TODO Auto-generated method stub
		getSession().save(zan);
		
	}

	@Override
	public void deleteZan(ZanBean zan) {
		String hql="delete from ZanBean where zanUserId=? and zanVideoId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, zan.getZanUserId());
		query.setParameter(1, zan.getZanVideoId());
		query.executeUpdate();
		getSession().beginTransaction().commit();
		
		
	}

	@Override
	public List<ZanBean> getZanList(int videoId, int userId) {
		// TODO Auto-generated method stub
		List<ZanBean> zanList = new ArrayList<>();
		String sql = "select * from zan where zan_video_id = ? and zan_user_id = ?";
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(ZanBean.class);
		query.setParameter(0, videoId);
		query.setParameter(1, userId);
		zanList = query.list();
		return zanList;
	}

}
