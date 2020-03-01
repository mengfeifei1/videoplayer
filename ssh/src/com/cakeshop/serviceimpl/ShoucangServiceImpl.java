package com.cakeshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.dao.ShoucangDao;
import com.cakeshop.service.ShoucangService;


@Service
public class ShoucangServiceImpl implements ShoucangService {

	@Autowired
	private ShoucangDao shouDao;
	
	@Override
	public List<ShoucangBean> GetShouList(int videoId, int userId) {
		// TODO Auto-generated method stub
		return shouDao.GetShouList(videoId, userId);
	}

}
