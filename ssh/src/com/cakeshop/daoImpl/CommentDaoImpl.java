package com.cakeshop.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.cakeshop.bean.CommentBean;
import com.cakeshop.bean.VideoBean;
import com.cakeshop.dao.CommentDao;
@Repository
public class CommentDaoImpl extends BaseDaoImpl implements CommentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentBean> getCommentById(int videoId) {
		// TODO Auto-generated method stub
		List<CommentBean> commentList=new ArrayList<>();
		String sql="from CommentBean where videoId=?";
		Query query=getSession().createQuery(sql);
		query.setParameter(0,videoId);
		commentList=query.list();
		return commentList;
	}  

	@Override
	public void addCommentById(CommentBean comment) {
		// TODO Auto-generated method stub
		Query query = getSession()
				.createQuery("update CommentBean comment set "
						+ "commentDetail=?"
						+ ", commentDate=?"
						+ ",userId=?"
						+ ",videoId=?"
						+ "likeCount=?");
		query.setString(0, comment.getCommentDetail());
		query.setString(1, comment.getCommentDate());
		query.setInteger(2, comment.getUserId());
		query.setInteger(3, comment.getVideoId());
		query.setInteger(4, comment.getLikeCount());
		query.executeUpdate();
		return;
		
	}

	//新增方法
	@Override
	public List<CommentBean> getAllComment() {
		List<CommentBean> commentList = new ArrayList<>();
		String sql="select * from comment";
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(CommentBean.class);
		commentList = query.list();
		return commentList;
	}

	@Override
	public void deleteComment(int CommentId) {
		// TODO Auto-generated method stub
		String sql="delete * from comment where comment_id = ?";
		SQLQuery query = getSession().createSQLQuery(sql).addEntity(CommentBean.class);
		query.setParameter(0, CommentId);
		query.list();
	}


}
