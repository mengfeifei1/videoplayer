package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.BarrageBean;

public interface BarrageService {
	public List<String> getDanmuByVideoId(int videoId);
	public void addDanmu(BarrageBean barrage);
	//新增方法
	public List<BarrageBean> getAllBarrage();
	public void deleteBarrage(int barrageId);
}
