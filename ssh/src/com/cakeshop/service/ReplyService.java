package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.ReplyBean;

public interface ReplyService {
	public List<ReplyBean> getReplyByCommentId(int commentId);
	public void addReply(ReplyBean reply);
}
