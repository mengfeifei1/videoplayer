package com.cakeshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.UserBean;
import com.cakeshop.bean.VideoBean;
import com.cakeshop.service.UserService;
import com.cakeshop.service.VideoService;


@RequestMapping("/video")
@Controller
public class VideoController {
	@Autowired
	@Resource
	private VideoService videoService;
	
	
	@RequestMapping("/all")
	public  void GetAllVideoList(HttpServletRequest re,HttpServletResponse req) throws IOException {
		List<VideoBean> videoList = new ArrayList<>();
		videoList = videoService.GetALLVideoList();
		JSONObject videoObject = new JSONObject();
		videoObject.put("videoList", videoList);
		req.getWriter().append(videoObject.toString()).append("123");	
	}
	

	@RequestMapping("/order")
	public void GetOrderVideoList(HttpServletRequest re,HttpServletResponse req) throws IOException{
		List<VideoBean> videoList = new ArrayList<>();
		videoList = videoService.GetOrderVideoList();
		JSONObject videoObject = new JSONObject();
		videoObject.put("videoList", videoList);
		for(int i=0;i<videoList.size();i++) {
			System.out.println(videoList.get(i).getVideoTitle());
		}
		req.getWriter().append(videoObject.toString()).append("123");
	}
	

	@RequestMapping("/type")
	public void GetTypeVideoList(HttpServletRequest re,HttpServletResponse req) throws IOException{
		String type = re.getParameter("videoType");
		System.out.println(type);
		List<VideoBean> videoList = new ArrayList<>();
		videoList = videoService.GetTypeVideoList(type);
		JSONObject videoObject = new JSONObject();
		videoObject.put("videoList", videoList);
		req.getWriter().append(videoObject.toString()).append("123");
	}
	

	@RequestMapping("/title")
	public void GetTitleVideoList(HttpServletRequest re,HttpServletResponse req) throws IOException{
		String title = re.getParameter("videoTitle");
		System.out.println(title);
		List<VideoBean> videoList = new ArrayList<>();
		videoList = videoService.GetTitleVideoList(title);
		if(videoList.size()==0) {
			VideoBean videoBean = new VideoBean();
			videoBean.setVideoTitle("无与此相关内容");
			videoList.add(videoBean);
		}
		JSONObject videoObject = new JSONObject();
		videoObject.put("videoList", videoList);
		for(int i=0;i<videoList.size();i++) {
			System.out.println(videoList.get(i).getVideoTitle());
		}
		req.getWriter().append(videoObject.toString()).append("123");
	}
	@RequestMapping("/upVideo")
	public void getVideo(int userId,HttpServletRequest req,HttpServletResponse rep) throws IOException {
		System.out.println("123");
		List<VideoBean> videoList=videoService.getVideo(userId);
		JSONObject object1 = new JSONObject();
		object1.put("videoList", videoList);
		rep.getWriter().append(object1.toString());
		
	}
	@RequestMapping("/shoucangVideo")
	public void getShoucangVideo(int userId,HttpServletRequest req,HttpServletResponse rep) throws IOException {
		List<VideoBean> videoList=new ArrayList<>();
		List<ShoucangBean> videoIdList=new ArrayList<>();
		VideoBean  video=new VideoBean();
		videoIdList=videoService.getShoucangVideoId(userId);
		int i=videoIdList.size();
		int k=0;
		for(k=0;k<i;k++) {
			int idnum=videoIdList.get(k).getVideoId();
			video=videoService.getShoucangVideo(idnum);
			videoList.add(video);
		}
		JSONObject object=new JSONObject();
		object.put("videoList", videoList);
		rep.getWriter().append(object.toString());
	}
	@RequestMapping("/zan")
	public void getZanCountByUserId(int userId,HttpServletRequest req,HttpServletResponse rep) throws IOException
	{
		int zancount=0;
		List<VideoBean> videoList=videoService.getVideo(userId);
		for(VideoBean video:videoList) {
			zancount=zancount+video.getVideoZanNum();
		}
		JSONObject object=new JSONObject();
		object.put("zan", zancount);
		rep.getWriter().append(object.toString());
	}
	
}
