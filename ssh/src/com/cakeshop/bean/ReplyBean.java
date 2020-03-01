package com.cakeshop.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reply")
public class ReplyBean implements Serializable{
	
	private static final long serialVersionUID = -5813264827007873950L;
	private int replyId;
	private int commentId;
	private String reReplyName;
	private String userName;
	private String replyDetail;
	private String replyTime;
//	private CommentBean commentBean;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
//	public CommentBean getCommentBean() {
//		return commentBean;
//	}
//	public void setCommentBean(CommentBean commentBean) {
//		this.commentBean = commentBean;
//	}
	public ReplyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	@Column(name="re_reply_name")
	public String getReReplyName() {
		return reReplyName;
	}
	public void setReReplyName(String reReplyName) {
		this.reReplyName = reReplyName;
	}
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="comment_id")
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	@Column(name="reply_detail")
	public String getReplyDetail() {
		return replyDetail;
	}
	public void setReplyDetail(String replyDetail) {
		this.replyDetail = replyDetail;
	}
	@Column(name="reply_time")
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	
	@Override
	public String toString() {
		return "ReplyBean [replyId=" + replyId + ", commentId=" + commentId + ", reReplyName=" + reReplyName
				+ ", userName=" + userName + ", replyDetail=" + replyDetail + ", replyTime=" + replyTime + "]";
	}

	
}
