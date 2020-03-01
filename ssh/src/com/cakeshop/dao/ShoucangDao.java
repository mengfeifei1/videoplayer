package com.cakeshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ShoucangBean;

@Repository
public interface ShoucangDao {
	public List<ShoucangBean> GetShouList(int videoId,int userId);
}
