package com.cakeshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ReplyBean;
@Repository
public interface ReplyDao {
	public List<ReplyBean> getReplyByCommentId(int commentId);
	public void addReply(ReplyBean reply);
}
