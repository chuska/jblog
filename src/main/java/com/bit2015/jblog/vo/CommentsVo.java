package com.bit2015.jblog.vo;

public class CommentsVo {
	private Long commentsNo;
	private String commentUserName;
	private Long postNo;
	private String content;
	private String createdDate;

	
	
	public String getCommentUserName() {
		return commentUserName;
	}

	public void setCommentUserName(String commentUserName) {
		this.commentUserName = commentUserName;
	}

	public Long getCommentsNo() {
		return commentsNo;
	}

	public void setCommentsNo(Long commentsNo) {
		this.commentsNo = commentsNo;
	}

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
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

	@Override
	public String toString() {
		return "CommentsVo [commentsNo=" + commentsNo + ", postNo=" + postNo
				+ ", content=" + content + ", createdDate=" + createdDate + "]";
	}

}
