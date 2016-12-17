package com.csu.bean;

import java.sql.Date;

/**
 * @author KING
 *
 */
public class Save {
	
	private int foldId;//收藏夹编号
	private String foldName;//收藏夹标题
	private String foldDes;//收藏夹的描述
	private int isPublic;//收藏夹是否公开
	private User user;//回答者：王俊强的user POJO写出来后引用
	//private ? answer;//回答：王俊强的user POJO写出来后引用
	//private ? question;//问题：老司机的question POJO写出来后引用
		
		
	
	public int getFoldId() {
		return foldId;
	}
	public void setFoldId(int foldId) {
		this.foldId = foldId;
	}
	public String getFoldName() {
		return foldName;
	}
	public void setFoldName(String foldName) {
		this.foldName = foldName;
	}
	public String getFoldDes() {
		return foldDes;
	}
	public void setFoldDes(String foldDes) {
		this.foldDes = foldDes;
	}
	public int getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Save() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Save [foldId=" + foldId + ", foldName=" + foldName + ", foldDes=" + foldDes + ", isPublic=" + isPublic
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foldDes == null) ? 0 : foldDes.hashCode());
		result = prime * result + foldId;
		result = prime * result + ((foldName == null) ? 0 : foldName.hashCode());
		result = prime * result + isPublic;
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
		Save other = (Save) obj;
		if (foldDes == null) {
			if (other.foldDes != null)
				return false;
		} else if (!foldDes.equals(other.foldDes))
			return false;
		if (foldId != other.foldId)
			return false;
		if (foldName == null) {
			if (other.foldName != null)
				return false;
		} else if (!foldName.equals(other.foldName))
			return false;
		if (isPublic != other.isPublic)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
