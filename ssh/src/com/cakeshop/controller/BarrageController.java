package com.cakeshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeshop.bean.BarrageBean;
import com.cakeshop.bean.UserBean;
import com.cakeshop.service.BarrageService;

import net.sf.json.JSONObject;

@RequestMapping("/barrage")
@Controller
public class BarrageController {
	@Autowired
	@Resource
	private BarrageService barrageService;
	@RequestMapping("/getDanmu")
	public void getDanmuByVideoId(int videoId,HttpServletRequest req,HttpServletResponse rep) throws IOException
	{
		
		List<String> danmuList=barrageService.getDanmuByVideoId(videoId);
		System.out.println(danmuList.toString());
		JSONObject object1 = new JSONObject();
		object1.put("danmuList", danmuList);
		rep.getWriter().append(object1.toString());
	}
	@RequestMapping("/add")
	public void addDanmu(HttpServletRequest req,HttpServletResponse rep) throws IOException 
	{
		System.out.println("123");
		InputStream is=req.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String json=br.readLine();
		System.out.println("数据"+json);
		JSONObject object = JSONObject.fromObject(json);
		int barrageVideoId=object.getInt("videoId");
		String barrageDetail = object.getString("barrageDetail");
		BarrageBean barrage=new BarrageBean();
		barrage.setBarrageVideoId(barrageVideoId);
		barrage.setBarrageDetail(barrageDetail);
		System.out.println(barrage.toString());
		barrageService.addDanmu(barrage);
		

	}
}
