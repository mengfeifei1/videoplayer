package com.cakeshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeshop.bean.CommentBean;
import com.cakeshop.bean.ReplyBean;
import com.cakeshop.bean.UserBean;
import com.cakeshop.service.CommentService;
import com.cakeshop.service.ReplyService;
import com.cakeshop.service.UserService;

import net.sf.json.JSONObject;

@RequestMapping("/comment")
@Controller
public class CommentControllet {
	@Autowired
	@Resource
	private CommentService commentService;
	@Resource
	private ReplyService replyService;
	@Resource
	private UserService userService;
	@RequestMapping("/getComment")
	public void getCommentByVideoId(int videoId,HttpServletRequest req,HttpServletResponse rep) throws IOException
	{
		List<CommentBean> commentList=commentService.getCommentById(videoId);
		List<ReplyBean> replyList=new ArrayList<>();
		System.out.println(commentList.toString());
		for(int i=0;i<commentList.size();i++) {
			System.out.println(commentList.get(i).getCommentId());
			replyList=replyService.getReplyByCommentId(commentList.get(i).getCommentId());
			UserBean user=userService.findPerson(commentList.get(i).getUserId());
			commentList.get(i).setReplyList(replyList);
			commentList.get(i).setUser(user);
			System.out.println(commentList.get(i).toString());
		}
		JSONObject object1 = new JSONObject();
		object1.put("commentList", commentList);
		rep.getWriter().append(object1.toString());
	}
	@RequestMapping("/addComment")
	public void addComment(HttpServletRequest req,HttpServletResponse rep) throws IOException, ParseException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register---"+json);
		JSONObject object = JSONObject.fromObject(json);
		System.out.println("json");
		CommentBean comment=new CommentBean();
		String commentDetail=object.getString("commentDetail");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date()); 
		// new Date()为获取当前系统时间
		int userId=object.getInt("userId");
		int videoId=object.getInt("videoId");
		comment.setUserId(userId);
		comment.setVideoId(videoId);
		comment.setCommentDate(date);
		comment.setCommentDetail(commentDetail);
		comment.setLikeCount(0);
		commentService.addCommentById(comment);
		
	} 
}
