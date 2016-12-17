package com.csu.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author 唐嘉良
 * @time 创建时间：2016-12-9
 * 		 修改时间：2016-12-10  ①修改了变量名：questionDes---->questionContent
 * 							②新增了变量 questionDate 和questionLastUpdateTime，并修改了对应的方法
 *							③修改了questionDate和questionLastUpdateTime的类型，Date---->Timestamp
 */
public class Question {
	
	private int questionId;
	private String questionTitle;
	private String questionContent;
	private boolean qIsAno;
	private Timestamp questionDate;
	private Timestamp questionLastUpdateTime;
	private User user;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	public Question(int questionId, String questionTitle, String questionContent, boolean qIsAno,
			Timestamp questionDate, Timestamp questionLastUpdateTime, User user) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.qIsAno = qIsAno;
		this.questionDate = questionDate;
		this.questionLastUpdateTime = questionLastUpdateTime;
		this.user = user;
	}


	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", qIsAno=" + qIsAno + ", questionDate=" + questionDate
				+ ", questionLastUpdateTime=" + questionLastUpdateTime + ", user=" + user + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (qIsAno ? 1231 : 1237);
		result = prime * result + ((questionContent == null) ? 0 : questionContent.hashCode());
		result = prime * result + ((questionDate == null) ? 0 : questionDate.hashCode());
		result = prime * result + questionId;
		result = prime * result + ((questionLastUpdateTime == null) ? 0 : questionLastUpdateTime.hashCode());
		result = prime * result + ((questionTitle == null) ? 0 : questionTitle.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Question other = (Question) obj;
		if (qIsAno != other.qIsAno)
			return false;
		if (questionContent == null) {
			if (other.questionContent != null)
				return false;
		} else if (!questionContent.equals(other.questionContent))
			return false;
		if (questionDate == null) {
			if (other.questionDate != null)
				return false;
		} else if (!questionDate.equals(other.questionDate))
			return false;
		if (questionId != other.questionId)
			return false;
		if (questionLastUpdateTime == null) {
			if (other.questionLastUpdateTime != null)
				return false;
		} else if (!questionLastUpdateTime.equals(other.questionLastUpdateTime))
			return false;
		if (questionTitle == null) {
			if (other.questionTitle != null)
				return false;
		} else if (!questionTitle.equals(other.questionTitle))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public boolean isqIsAno() {
		return qIsAno;
	}
	public void setqIsAno(boolean qIsAno) {
		this.qIsAno = qIsAno;
	}
	public Timestamp getQuestionDate() {
		return questionDate;
	}
	public void setQuestionDate(Timestamp questionDate) {
		this.questionDate = questionDate;
	}
	public Timestamp getQuestionLastUpdateTime() {
		return questionLastUpdateTime;
	}
	public void setQuestionLastUpdateTime(Timestamp questionLastUpdateTime) {
		this.questionLastUpdateTime = questionLastUpdateTime;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
}
