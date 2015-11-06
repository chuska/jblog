package com.bit2015.jblog.vo;

public class CategoryVo {
	private Long blogNo;
	private String categoryNo;
	private String categoryName;
	private String displayType;
	private Long cntDisplayPost;
	private String description;
	private String createdDate;
	private String modifiedDate;

	public Long getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(Long blogNo) {
		this.blogNo = blogNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public Long getCntDisplayPost() {
		return cntDisplayPost;
	}

	public void setCntDisplayPost(Long cntDisplayPost) {
		this.cntDisplayPost = cntDisplayPost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Category [blogNo=" + blogNo + ", categoryNo=" + categoryNo
				+ ", categoryName=" + categoryName + ", displayType="
				+ displayType + ", cntDisplayPost=" + cntDisplayPost
				+ ", description=" + description + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
