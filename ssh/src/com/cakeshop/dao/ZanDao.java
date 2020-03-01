package com.cakeshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ZanBean;

@Repository
public interface ZanDao {
	public void addZan(ZanBean zan);
	public void deleteZan(ZanBean zan);
	public List<ZanBean> getZanList(int videoId,int userId);
}
