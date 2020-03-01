package com.cakeshop.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoucang")
public class ShoucangBean implements Serializable{

	private static final long serialVersionUID = -5813264827007873950L;
	private int userId;
	private int videoId;
	
	public ShoucangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoucangBean(int userId, int videoId) {
		super();
		this.userId = userId;
		this.videoId = videoId;
	}
	@Id
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Id
	@Column(name="video_id")
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
}
