package com.cakeshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.bean.BarrageBean;
import com.cakeshop.bean.CommentBean;
import com.cakeshop.bean.UserBean;
import com.cakeshop.bean.VideoBean;
import com.cakeshop.service.BarrageService;
import com.cakeshop.service.CommentService;
import com.cakeshop.service.UserService;
import com.cakeshop.service.VideoService;

@RequestMapping("/background")
@Controller
public class BackgroundController {
	@Autowired
	@Resource
	private VideoService videoService;
	@Resource
	private CommentService commentService;
	@Resource
	private BarrageService barrageService;
	@Resource
	private UserService userService;
	
	@RequestMapping("/getVideo")
	public String getVideo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<VideoBean> videoList = videoService.GetALLVideoList();
		session.setAttribute("videoList", videoList);
		return "forward:/main_list.jsp";
	}
	@RequestMapping("/searchVideo")
	public String searchVideo(String videoTitle,HttpServletRequest request) {
		System.out.println(videoTitle);
		HttpSession session = request.getSession();
		List<VideoBean> videoList = videoService.GetTitleVideoList(videoTitle);
		session.setAttribute("videoList", videoList);
		return "forward:/main_list.jsp";
	}
	@RequestMapping("/getOrderVideo")
	public String getOrderVideo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<VideoBean> videoList = videoService.GetOrderVideoList();
		session.setAttribute("videoList", videoList);
		return "forward:/main_num.jsp";
	}
	
	@RequestMapping("/getHotVideo")
	public String getHotVideo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<VideoBean> videoList = videoService.GetALLVideoList();
		session.setAttribute("videoList", videoList);
		return "forward:/main_hot.jsp";
	}
	
	@RequestMapping("/getAllComment")
	public String getAllComment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<CommentBean> commentList = commentService.getAllComment();
		for(int i=0;i<commentList.size();i++) {
			int userId = commentList.get(i).getUserId();
			UserBean user = userService.findPerson(userId);
			commentList.get(i).setUser(user);
		}
		session.setAttribute("commentList", commentList);
		return "forward:/main_comment.jsp";
	}
	@RequestMapping("/getAllBarrage")
	public String getBarrageComment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<BarrageBean> barrageList = barrageService.getAllBarrage();
		for(int i=0;i<barrageList.size();i++) {
			int videoId = barrageList.get(i).getBarrageVideoId();
			List<VideoBean> videoList = videoService.getVideoById(videoId);
			barrageList.get(i).setVideo(videoList.get(0));
		}
		session.setAttribute("barrageList", barrageList);
		return "forward:/main_danmu.jsp";
	}
	@RequestMapping("/deleteBarrage")
	public String deleteBarrage(HttpServletRequest request) {
		System.out.println(request.getParameter("barrageId"));
		int barrageId = Integer.parseInt(request.getParameter("barrageId")); 
		HttpSession session = request.getSession();
		barrageService.deleteBarrage(barrageId);
		List<BarrageBean> barrageList = barrageService.getAllBarrage();
		for(int i=0;i<barrageList.size();i++) {
			int videoId = barrageList.get(i).getBarrageVideoId();
			List<VideoBean> videoList = videoService.getVideoById(videoId);
			barrageList.get(i).setVideo(videoList.get(0));
		}
		session.setAttribute("barrageList", barrageList);
		return "forward:/main_danmu.jsp";
	}
	@RequestMapping("/deleteComment")
	public String deleteComment(HttpServletRequest request) {
		int commentId = Integer.parseInt(request.getParameter("commentId")); 
		HttpSession session = request.getSession();
		commentService.deleteComment(commentId);
		List<CommentBean> commentList = commentService.getAllComment();
		for(int i=0;i<commentList.size();i++) {
			int userId = commentList.get(i).getUserId();
			UserBean user = userService.findPerson(userId);
			commentList.get(i).setUser(user);
		}
		session.setAttribute("commentList", commentList);
		return "forward:/main_comment.jsp";
	}
}
