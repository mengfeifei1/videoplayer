package com.cakeshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop.bean.CommentBean;
import com.cakeshop.dao.CommentDao;
import com.cakeshop.dao.UserDao;
import com.cakeshop.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;
	@Override
	public List<CommentBean> getCommentById(int videoId) {
		// TODO Auto-generated method stub
		return commentDao.getCommentById(videoId);
	}

	@Override
	public void addCommentById(CommentBean comment) {
		// TODO Auto-generated method stub
		commentDao.addCommentById(comment);
	}

}
