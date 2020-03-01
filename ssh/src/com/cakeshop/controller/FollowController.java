package com.cakeshop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeshop.service.FollowService;

import net.sf.json.JSONObject;

@RequestMapping("/follow")
@Controller
public class FollowController {
	@Autowired
	@Resource
	private FollowService followService;
	@RequestMapping("/guanzhu")
	public void findGuanzhuCount(int userId,HttpServletRequest req,HttpServletResponse rep) throws IOException {
		int count=followService.findFollowByUserId(userId);
		System.out.print(count);
		JSONObject object1 = new JSONObject();
		object1.put("guanzhu", count);
		rep.getWriter().append(object1.toString());
	}
	@RequestMapping("/fans")
	public void findFansCount(int userId,HttpServletRequest req,HttpServletResponse rep) throws IOException {
		int count=followService.findFollowedByUserId(userId);
		System.out.print(count);
		JSONObject object1 = new JSONObject();
		object1.put("fans", count);
		rep.getWriter().append(object1.toString());
	}

}
