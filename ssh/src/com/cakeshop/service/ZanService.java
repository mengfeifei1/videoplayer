package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.ZanBean;

public interface ZanService {
	public void addZan(ZanBean zan);
	public void deleteZan(ZanBean zan);
	public List<ZanBean> getZanList(int videoId,int userId); 
}
