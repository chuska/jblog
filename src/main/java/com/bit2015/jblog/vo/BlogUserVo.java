package com.bit2015.jblog.vo;
//
public class BlogUserVo {
	private Long userNo;
	private String userId;
	private String userName;
	private String role;
	private String password;
	private String createdDate;
	private String modifiedDate;

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "BlogUserVo [userNo=" + userNo + ", userId=" + userId
				+ ", userName=" + userName + ", role=" + role + ", password="
				+ password + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

}
