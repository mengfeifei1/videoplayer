package com.cakeshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeshop.bean.ReplyBean;
import com.cakeshop.service.ReplyService;

import net.sf.json.JSONObject;

@RequestMapping("/comment")
@Controller
public class ReplyController {
	@Autowired
	@Resource
	private ReplyService replyService;
	@RequestMapping("/getReply")
	public void getReplyByCommentId(int commentId,HttpServletRequest req,HttpServletResponse rep) throws IOException {
		List<ReplyBean> replyList=replyService.getReplyByCommentId(commentId);
		System.out.println(replyList.toString());
		JSONObject object=new JSONObject();
		object.put("replyList", replyList);
		rep.getWriter().append(object.toString());
	}

	@RequestMapping("/addReply")
	public void addReply(HttpServletRequest req,HttpServletResponse rep) throws IOException, ParseException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register---"+json);
		JSONObject object = JSONObject.fromObject(json);
		System.out.println("json");
		ReplyBean reply =new ReplyBean();
		String  reReplyName=object.getString("reReplyName");
		int commentId=object.getInt("commentId");
		String userName=object.getString("userName");
		String replyDetail=object.getString("replyDetail");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date()); 
		reply.setCommentId(commentId);
		reply.setReplyDetail(replyDetail);
		reply.setReplyTime(date);
		reply.setReReplyName(reReplyName);
		reply.setUserName(userName);
		replyService.addReply(reply);
		
		
	}
	
}
