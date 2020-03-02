package com.cakeshop.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="barrage")
public class BarrageBean implements Serializable{
	private int barrageId;
	private int barrageVideoId;
	private String barrageDetail;
	
	@OneToOne
    @JoinColumn(name = "barrage_video_id")
	private VideoBean video;	

	public VideoBean getVideo() {
		return video;
	}
	public void setVideo(VideoBean video) {
		this.video = video;
	}
	public BarrageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="barrage_id")
	public int getBarrageId() {
		return barrageId;
	}
	public void setBarrageId(int barrageId) {
		this.barrageId = barrageId;
	}
	@Column(name="barrage_video_id")
	public int getBarrageVideoId() {
		return barrageVideoId;
	}
	public void setBarrageVideoId(int barrageVideoId) {
		this.barrageVideoId = barrageVideoId;
	}
	@Column(name="barrage_detail")
	public String getBarrageDetail() {
		return barrageDetail;
	}
	public void setBarrageDetail(String barrageDetail) {
		this.barrageDetail = barrageDetail;
	}
	@Override
	public String toString() {
		return "BarrageBean [barrageId=" + barrageId + ", barrageVideoId=" + barrageVideoId + ", barrageDetail="
				+ barrageDetail + "]";
	}
}
