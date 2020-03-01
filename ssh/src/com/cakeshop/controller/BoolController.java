package com.cakeshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cakeshop.bean.BoolBean;
import com.cakeshop.bean.ShoucangBean;
import com.cakeshop.bean.ZanBean;
import com.cakeshop.service.ShoucangService;
import com.cakeshop.service.ZanService;


@RequestMapping("/bool")
@Controller
public class BoolController {
	@Autowired
	@Resource
	private ShoucangService shoucangService ;
	@Resource
	private ZanService zanService ;
	
	@RequestMapping("/heart")
	public void GetBoolList(int videoId, int userId, HttpServletRequest re,HttpServletResponse req) throws IOException {
		List<ShoucangBean> shouList = new ArrayList();
		List<ZanBean> zanList = new ArrayList();
		List<BoolBean> boolList = new ArrayList();
		BoolBean boolBean = new BoolBean();
		shouList = shoucangService.GetShouList(videoId, userId);
		zanList = zanService.getZanList(videoId, userId);
		if(shouList.size() == 0) {
			boolBean.setShou(false);
		}else {
			boolBean.setShou(true);
		}
		if(zanList.size() == 0) {
			boolBean.setZan(false);
		}else {
			boolBean.setZan(true);
		}
		JSONObject videoObject = new JSONObject();
		boolList.add(boolBean);
		videoObject.put("boolList", boolList);
		req.getWriter().append(videoObject.toString());	
	}	
}
