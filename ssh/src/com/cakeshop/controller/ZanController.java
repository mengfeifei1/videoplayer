package com.cakeshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeshop.bean.BarrageBean;
import com.cakeshop.bean.ZanBean;
import com.cakeshop.service.ZanService;

import net.sf.json.JSONObject;

@RequestMapping("/zan")
@Controller
public class ZanController {
	@Autowired
	@Resource
	private ZanService zanService;
	@RequestMapping("/add")
	public void addZan(HttpServletRequest req,HttpServletResponse rep) throws IOException 
	{
		System.out.println("zan+add");
		InputStream is=req.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String json=br.readLine();
		System.out.println("数据"+json);
		JSONObject object = JSONObject.fromObject(json);
		int zanVideoId=object.getInt("zanVideoId");
		int zanUserId=object.getInt("zanUserId");
		ZanBean zan=new ZanBean();
		zan.setZanUserId(zanUserId);
		zan.setZanVideoId(zanVideoId);
		zanService.addZan(zan);
		

	}
	
	@RequestMapping("/delete")
	public void deleteZan(HttpServletRequest req,HttpServletResponse rep) throws IOException {
		System.out.println("delete+add");
		InputStream is=req.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String json=br.readLine();
		System.out.println("数据"+json);
		JSONObject object = JSONObject.fromObject(json);
		int zanVideoId=object.getInt("zanVideoId");
		int zanUserId=object.getInt("zanUserId");
		ZanBean zan=new ZanBean();
		zan.setZanUserId(zanUserId);
		zan.setZanVideoId(zanVideoId);
		zanService.deleteZan(zan);
	}
}
