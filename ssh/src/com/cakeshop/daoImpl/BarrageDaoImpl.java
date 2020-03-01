package com.cakeshop.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.BarrageBean;
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

}
