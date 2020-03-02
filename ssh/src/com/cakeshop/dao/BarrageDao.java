package com.cakeshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.BarrageBean;
import com.cakeshop.bean.CommentBean;

@Repository
public interface BarrageDao {
	public List<String> getDanmuByVideoId(int videoId);
	public void addDanmu(BarrageBean barrage);
	//新增方法
	public List<BarrageBean> getAllBarrage();
	public void deleteBarrage(int barrageId);
}
