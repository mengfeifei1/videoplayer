package com.cakeshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop.bean.ReplyBean;
import com.cakeshop.dao.ReplyDao;
import com.cakeshop.service.ReplyService;
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyDao replyDao;
	@Override
	public List<ReplyBean> getReplyByCommentId(int commentId) {
		// TODO Auto-generated method stub
		return replyDao.getReplyByCommentId(commentId);
	}

	@Override
	public void addReply(ReplyBean reply) {
		// TODO Auto-generated method stub
		replyDao.addReply(reply);
		
	}

}
