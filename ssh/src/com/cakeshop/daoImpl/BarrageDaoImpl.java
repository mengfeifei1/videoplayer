package com.cakeshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.BarrageBean;
import com.cakeshop.bean.CommentBean;
import com.cakeshop.bean.VideoBean;
import com.cakeshop.dao.BarrageDao;
@Repository
public class BarrageDaoImpl extends BaseDaoImpl implements BarrageDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDanmuByVideoId(int videoId) {
		// TODO Auto-generated method stub
		String hql="from BarrageBean where barrageVideoId=?";
		Query query=getSession().createQuery(hql);
		query.setParameter(0, videoId);
		List<String> barrageList=query.list();
		System.out.println("barrragelist"+barrageList.toString());
		return barrageList;
	}

	@Override
	public void addDanmu(BarrageBean barrage) {
		// TODO Auto-generated method stub
		getSession().save(barrage);
		
	}

	@Override
	public List<BarrageBean> getAllBarrage() {
		// TODO Auto-generated method stub
		List<BarrageBean>  barrageList = new ArrayList<>();
		String sql = "select * from barrage";
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(BarrageBean.class);
		barrageList = query.list();
		return barrageList;
	}

	@Override
	public void deleteBarrage(int barrageId) {
		// TODO Auto-generated method stub
		String sql="delete * from barrage where barrage_id = ?";
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(BarrageBean.class);
		query.setParameter(0, barrageId);
		int a = query.executeUpdate();
		System.out.print(a);
	}

}
