package com.cakeshop.service;

import java.util.List;

import com.cakeshop.bean.CommentBean;

public interface CommentService {
	public List<CommentBean> getCommentById(int videoId);
	public void  addCommentById(CommentBean comment);
	//新增方法
	public List<CommentBean> getAllComment();
	public void deleteComment(int commentId);
}
