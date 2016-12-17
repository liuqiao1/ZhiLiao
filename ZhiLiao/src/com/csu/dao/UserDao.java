package com.csu.dao;
import com.csu.bean.User;
public interface UserDao {
	    public User login(User user);
		public boolean add(User user);
		public boolean update(User user);
		public boolean isUserName(User user);
		public boolean isEmail(User user);
		public boolean isCheckEmail(User user);
		public boolean modifyPwd(User user);
		public User QueryById(User userId);
		
}
