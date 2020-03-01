package com.cakeshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.ReplyBean;
import com.cakeshop.dao.ReplyDao;
@Repository
public class ReplyDaoImpl extends BaseDaoImpl implements ReplyDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ReplyBean> getReplyByCommentId(int commentId) {
		// TODO Auto-generated method stub
		List<ReplyBean> replyList=new ArrayList<>();
		String sql="from ReplyBean where commentId=?";
		Query query=getSession().createQuery(sql);
		query.setParameter(0, commentId);
		replyList=query.list();
		return replyList;
	}

	@Override
	public void addReply(ReplyBean reply) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("update ReplyBean reply set"
				+ "reReplyName=?"
				+ "commentId=?"
				+ "userName=?"
				+ "replyDetail=?"
				+ "replyTime=?");
		query.setString(0, reply.getReReplyName());
		query.setInteger(1, reply.getCommentId());
		query.setString(2, reply.getUserName());
		query.setString(3, reply.getReplyDetail());
		query.setString(4,reply.getReplyTime());
		query.executeUpdate();
		return;
		
	}

}
