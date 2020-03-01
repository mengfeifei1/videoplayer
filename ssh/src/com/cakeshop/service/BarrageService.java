package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.BarrageBean;

public interface BarrageService {
	public List<String> getDanmuByVideoId(int videoId);
	public void addDanmu(BarrageBean barrage);
}
