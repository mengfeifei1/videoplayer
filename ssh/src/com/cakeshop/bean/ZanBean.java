package com.cakeshop.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zan")
public class ZanBean {
	private static final long serialVersionUID = -5813264827007873950L;
	private int zanId;
	private int zanVideoId;
	private int zanUserId;
	
	public ZanBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="zan_id")     
	public int getZanId() {
		return zanId;
	}
	public void setZanId(int zanId) {
		this.zanId = zanId;
	}
	@Column(name="zan_video_id")  
	public int getZanVideoId() {
		return zanVideoId;
	}
	public void setZanVideoId(int zanVideoId) {
		this.zanVideoId = zanVideoId;
	}
	@Column(name="zan_user_id")  
	public int getZanUserId() {
		return zanUserId;
	}
	public void setZanUserId(int zanUserId) {
		this.zanUserId = zanUserId;
	}
	@Override
	public String toString() {
		return "ZanBean [zanId=" + zanId + ", zanVideoId=" + zanVideoId + ", zanUserId=" + zanUserId + "]";
	}
	

}
