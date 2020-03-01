package com.cakeshop.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bool")
public class BoolBean implements Serializable{
	private static final long serialVersionUID = -5813264827007873950L;
	private Boolean zan;
	private Boolean shou;
	private int id;
	public BoolBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Column(name="zan")
	public Boolean getZan() {
		return zan;
	}
	public void setZan(Boolean zan) {
		this.zan = zan;
	}
	
	@Column(name="shou")
	public Boolean getShou() {
		return shou;
	}
	public void setShou(Boolean shou) {
		this.shou = shou;
	}

	@Override
	public String toString() {
		return "BoolBean [zan=" + zan + ", shou=" + shou + "]";
	}
	
}
