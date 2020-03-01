package com.cakeshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop.bean.ZanBean;
import com.cakeshop.dao.ZanDao;
import com.cakeshop.service.ZanService;
@Service
public class ZanServiceImpl implements ZanService{
	@Autowired
	private ZanDao zanDao;
	@Override
	public void addZan(ZanBean zan) {
		// TODO Auto-generated method stub
		zanDao.addZan(zan);
	}

	@Override
	public void deleteZan(ZanBean zan) {
		// TODO Auto-generated method stub
		zanDao.deleteZan(zan);
	}

	@Override
	public List<ZanBean> getZanList(int videoId, int userId) {
		// TODO Auto-generated method stub
		return zanDao.getZanList(videoId, userId);
	}

}
