package com.cakeshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.VideoBean;
import com.cakeshop.dao.VideoDao;
import com.cakeshop.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService{
	@Autowired
	private VideoDao videoDao;
	@Override
	public List<VideoBean> getVideo(int userId) {
		// TODO Auto-generated method stub
		return videoDao.getVideo(userId);
	}
	@Override
	public List<ShoucangBean> getShoucangVideoId(int userId) {
		// TODO Auto-generated method stub
		return videoDao.getShoucangVideoId(userId);
	}
	@Override
	public VideoBean getShoucangVideo(int videoId) {
		// TODO Auto-generated method stub
		return videoDao.getShoucangVideo(videoId);
	}
	@Override
	public List<VideoBean> GetALLVideoList() {
		// TODO Auto-generated method stub
		return videoDao.GetALLVideoList();
	}

	@Override
	public List<VideoBean> GetOrderVideoList() {
		// TODO Auto-generated method stub
		return videoDao.GetOrderVideoList();
	}

	@Override
	public List<VideoBean> GetTypeVideoList(String type) {
		// TODO Auto-generated method stub
		return videoDao.GetTypeVideoList(type);
	}

	@Override
	public List<VideoBean> GetTitleVideoList(String title) {
		// TODO Auto-generated method stub
		return videoDao.GetTitleVideoList(title);
	}

}
