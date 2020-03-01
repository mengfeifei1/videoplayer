package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.VideoBean;

public interface VideoService {
	public List<VideoBean> getVideo(int userId);
	public List<ShoucangBean> getShoucangVideoId(int userId);
	public VideoBean getShoucangVideo(int videoId);
	//���ȫ����Ƶ
	public List<VideoBean> GetALLVideoList();
				
	//���յ���������ȫ����Ƶ
	public List<VideoBean> GetOrderVideoList();
				
	//������Ƶ���ͻ����Ƶ
	public List<VideoBean> GetTypeVideoList(String type);
				
	//������Ƶ��������Ƶ
	public List<VideoBean> GetTitleVideoList(String title);
}
