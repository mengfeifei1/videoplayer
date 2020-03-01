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
	//���ȫ����Ƶ
	public List<VideoBean> GetALLVideoList();
		
	//���յ���������ȫ����Ƶ
	public List<VideoBean> GetOrderVideoList();
		
	//������Ƶ���ͻ����Ƶ
	public List<VideoBean> GetTypeVideoList(String type);
		
	//������Ƶ��������Ƶ
	public List<VideoBean> GetTitleVideoList(String title);
}
