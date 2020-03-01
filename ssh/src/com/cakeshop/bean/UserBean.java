package com.cakeshop.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = -5813264827007873950L;
	private int userId;
	private String userName;
	private int userType;
	private String userAddress;
	private String userTelephone;
	private String userPassword;
	private String userSex;
	private String userIntro;
	private String userBirth;
	private String userPhoto;
	

	
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBean(String userName, String userAddress, String userTelephone, String userSex,
			String userIntro, String userBirth, String userPhoto) {
		super();
		this.userName = userName;
		this.userAddress = userAddress;
		this.userTelephone = userTelephone;
		this.userSex = userSex;
		this.userIntro = userIntro;
		this.userBirth = userBirth;
		this.userPhoto = userPhoto;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="user_type")
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Column(name="user_address")
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Column(name="user_telephone")
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	@Column(name="user_password")
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Column(name="user_sex")
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@Column(name="user_intro")
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", userType="
				+ userType + ", userAddress=" + userAddress + ", userTelephone=" + userTelephone + ", userPassword="
				+ userPassword + ", userSex=" + userSex + ", userIntro=" + userIntro + "]";
	}

	
}
