package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.VideoBean;

public interface VideoService {
	public List<VideoBean> getVideo(int userId);
	public List<ShoucangBean> getShoucangVideoId(int userId);
	public VideoBean getShoucangVideo(int videoId);
	public List<VideoBean> GetALLVideoList();
	public List<VideoBean> GetOrderVideoList();
	public List<VideoBean> GetTypeVideoList(String type);
	public List<VideoBean> GetTitleVideoList(String title);
	//新增方法
	public List<VideoBean> getVideoById(int videoId);
	public void updateVideo(VideoBean videoBean);
}
