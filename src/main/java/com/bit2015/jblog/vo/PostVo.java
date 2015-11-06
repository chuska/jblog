package com.bit2015.jblog.vo;

public class PostVo {
	private Long postNo;
	private String categoryNo;
	private String title;
	private String content;
	private String createdDate;
	private String modifiedDate;

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "PostVo [postNo=" + postNo + ", categoryNo=" + categoryNo
				+ ", title=" + title + ", content=" + content
				+ ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

}
