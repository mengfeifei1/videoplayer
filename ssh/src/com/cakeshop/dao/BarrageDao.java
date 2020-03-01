package com.cakeshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.BarrageBean;

@Repository
public interface BarrageDao {
	public List<String> getDanmuByVideoId(int videoId);
	public void addDanmu(BarrageBean barrage);
}
