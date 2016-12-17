package com.csu.bean;

public class Comment {
	private int commentId;
    private String commentContent;
    private String commentDate;
    private String fromUser;
    private String toUser;
    private int commentSupport;
    private int answerId;
    
     public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public int getCommentSupport() {
		return commentSupport;
	}
	public void setCommentSupport(int commentSupport) {
		this.commentSupport = commentSupport;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", fromUser=" + fromUser + ", toUser=" + toUser + ", commentSupport=" + commentSupport + ", answerId="
				+ answerId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + answerId;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((commentDate == null) ? 0 : commentDate.hashCode());
		result = prime * result + commentId;
		result = prime * result + commentSupport;
		result = prime * result + ((fromUser == null) ? 0 : fromUser.hashCode());
		result = prime * result + ((toUser == null) ? 0 : toUser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (answerId != other.answerId)
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentDate == null) {
			if (other.commentDate != null)
				return false;
		} else if (!commentDate.equals(other.commentDate))
			return false;
		if (commentId != other.commentId)
			return false;
		if (commentSupport != other.commentSupport)
			return false;
		if (fromUser == null) {
			if (other.fromUser != null)
				return false;
		} else if (!fromUser.equals(other.fromUser))
			return false;
		if (toUser == null) {
			if (other.toUser != null)
				return false;
		} else if (!toUser.equals(other.toUser))
			return false;
		return true;
	}
	
}
