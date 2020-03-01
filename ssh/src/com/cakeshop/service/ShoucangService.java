package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.ShoucangBean;

public interface ShoucangService {
	public List<ShoucangBean> GetShouList(int videoId,int userId);
}
