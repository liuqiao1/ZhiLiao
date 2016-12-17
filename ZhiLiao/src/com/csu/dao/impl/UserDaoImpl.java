package com.csu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.csu.bean.User;
import com.csu.dao.UserDao;
import com.csu.util.DBUtil;

public class UserDaoImpl implements UserDao{
	private Connection conn;
	private PreparedStatement ps;  
	private ResultSet rs;
	@Override
	public User login(User user) {
		String username = user.getUserName();
		String password= user.getPassWord();
		String sql = "select * from user where userName=? " +
			          	"and passWord=?";
		
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);//1代表你sql语句中的第一个问号，name是你要传得参数比如你要删除 id为1的信息ps.setString(1, “1”);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassWord("passWord");
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex"));
				user.setUserIntro(rs.getString("userIntro"));
				user.setAddress(rs.getString("address"));
				user.setIndustry(rs.getString("industry"));
				user.setCareerEx(rs.getString("careerEx"));
				user.setEducationEx(rs.getString("educationEx"));
				user.setSimpleIntro(rs.getString("simpleIntro"));
				user.setImage(rs.getString("image"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public boolean add(User user) {
        String sql="insert into user values(default,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassWord());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getSex());
			ps.setString(5,user.getUserIntro());
			ps.setString(6,user.getAddress());	
			ps.setString(7,user.getIndustry());
			ps.setString(8,user.getCareerEx());
			ps.setString(9,user.getEducationEx());
			ps.setString(10,user.getSimpleIntro());	
			ps.setString(11,user.getImage());	
			int i=ps.executeUpdate();
			if(i>0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User QueryById(User userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserName(User user) {
		boolean b=false;
		String username = user.getUserName();
		String sql = "select * from user where userName=?";
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);//1代表你sql语句中的第一个问号，name是你要传得参数比如你要删除 id为1的信息ps.setString(1, “1”);
			rs = ps.executeQuery();
			while(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;	
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isEmail(User user) {
		boolean b=false;
		String email= user.getEmail();
		String sql = "select * from user where email=?";
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);//1代表你sql语句中的第一个问号，name是你要传得参数比如你要删除 id为1的信息ps.setString(1, “1”);
			rs = ps.executeQuery();
			while(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean isCheckEmail(User user) {
		boolean b=false;
		String username = user.getUserName();
		String email = user.getEmail();
		String sql = "select * from user where userName=? " +
			          	"and email=?";
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);//1代表你sql语句中的第一个问号，name是你要传得参数比如你要删除 id为1的信息ps.setString(1, “1”);
			ps.setString(2, email);
			rs = ps.executeQuery();
			while(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;	
	}

	@Override
	public boolean modifyPwd(User user) {
		String sql="update user set passWord=? where userName=?";
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getPassWord());
			ps.setString(2,user.getUserName());
			int i=ps.executeUpdate();
			if(i>0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
