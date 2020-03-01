package com.cakeshop.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="follow")
public class FollowBean implements Serializable{

	private static final long serialVersionUID = -5813264827007873950L;
	private int followUserId;
	private int followedUserId;
	
	
	public FollowBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FollowBean(int followUserId, int followedUserId) {
		super();
		this.followUserId = followUserId;
		this.followedUserId = followedUserId;
	}
	@Id
	@Column(name="follow_user_id")
	public int getFollowUserId() {
		return followUserId;
	}
	public void setFollowUserId(int followUserId) {
		this.followUserId = followUserId;
	}
	@Id
	@Column(name="followed_user_id")
	public int getFollowedUserId() {
		return followedUserId;
	}
	public void setFollowedUserId(int followedUserId) {
		this.followedUserId = followedUserId;
	}
	@Override
	public String toString() {
		return "FollowBean [followUserId=" + followUserId + ", followedUserId=" + followedUserId + "]";
	}
	

}
