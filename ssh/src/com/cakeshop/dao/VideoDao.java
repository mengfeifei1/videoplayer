package com.cakeshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.VideoBean;

@Repository
public interface VideoDao {
	public List<VideoBean> getVideo(int userId);
	public List<ShoucangBean> getShoucangVideoId(int userId);
	public VideoBean getShoucangVideo(int videoId);
	//获得全部视频
	public List<VideoBean> GetALLVideoList();
		
	//按照点赞升序获得全部视频
	public List<VideoBean> GetOrderVideoList();
		
	//按照视频类型获得视频
	public List<VideoBean> GetTypeVideoList(String type);
		
	//按照视频标题获得视频
	public List<VideoBean> GetTitleVideoList(String title);
}
