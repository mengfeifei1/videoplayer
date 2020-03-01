package com.cakeshop.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class CommentBean implements Serializable{
	private static final long serialVersionUID = -5813264827007873950L;
	private int commentId;
	private String commentDetail;
	private String commentDate;
	private int userId;
	private int videoId;
	private int likeCount;
	private List<ReplyBean> replyList;
	
	@OneToOne
    @JoinColumn(name = "user_id")
	private UserBean user;
	
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public CommentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@OneToMany(fetch = FetchType.LAZY,targetEntity = ReplyBean.class,cascade =CascadeType.ALL)     //鍗曢」涓�瀵瑰閰嶇疆
	@JoinColumn(name="comment_id")		
	public List<ReplyBean> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyBean> replyList) {
		this.replyList = replyList;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="comment_id")
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	@Column(name="comment_detail")
	public String getCommentDetail() {
		return commentDetail;
	}
	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}
	@Column(name="comment_date")
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="video_id")
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	@Column(name="like_count")
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	@Override
	public String toString() {
		return "CommentBean [commentId=" + commentId + ", commentDetail=" + commentDetail + ", commentDate="
				+ commentDate + ", userId=" + userId + ", videoId=" + videoId
				+ "]";
	}
	
	
}
