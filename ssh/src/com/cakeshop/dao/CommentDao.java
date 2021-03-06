package com.cakeshop.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakeshop.bean.CommentBean;

@Repository
public interface CommentDao {
	public List<CommentBean> getCommentById(int videoId);
	public void  addCommentById(CommentBean comment);
	//新增方法
	public List<CommentBean> getAllComment();
	public void deleteComment(int commentId);
}
