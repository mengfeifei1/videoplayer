package com.cakeshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop.bean.BarrageBean;
import com.cakeshop.dao.BarrageDao;
import com.cakeshop.service.BarrageService;
@Service
public class BarrageServiceImpl implements BarrageService{
	@Autowired
	private BarrageDao barrageDao;
	public List<String> getDanmuByVideoId(int videoId) {
		// TODO Auto-generated method stub
		return barrageDao.getDanmuByVideoId(videoId);
	}
	@Override
	public void addDanmu(BarrageBean barrage) {
		// TODO Auto-generated method stub
		barrageDao.addDanmu(barrage);
	}
	//新增方法
	@Override
	public List<BarrageBean> getAllBarrage() {
		// TODO Auto-generated method stub
		return barrageDao.getAllBarrage();
	}
	@Override
	public void deleteBarrage(int barrageId) {
		// TODO Auto-generated method stub
		barrageDao.deleteBarrage(barrageId);
	}
}
