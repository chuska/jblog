package com.bit2015.jblog.vo;

public class BlogVo {
	private Long blogNo;
	private String title;
	private String tag;
	private Long cntDisplayPost;
	private String status;
	private String fileName;

	public Long getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(Long blogNo) {
		this.blogNo = blogNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getCntDisplayPost() {
		return cntDisplayPost;
	}

	public void setCntDisplayPost(Long cntDisplayPost) {
		this.cntDisplayPost = cntDisplayPost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "BlogVo [blogNo=" + blogNo + ", title=" + title + ", tag=" + tag
				+ ", cntDisplayPost=" + cntDisplayPost + ", status=" + status
				+ ", fileName=" + fileName + "]";
	}

}
