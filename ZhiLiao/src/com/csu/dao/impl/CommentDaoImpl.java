package com.csu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csu.bean.Comment;
import com.csu.bean.User;
import com.csu.dao.CommentDao;
import com.csu.util.DBUtil;
import com.mysql.jdbc.PreparedStatement;

/**
 * 2016年12月16日 AdministratorCommentDaoImpl.java
 * @author Administrator
 *
 */
public class CommentDaoImpl implements CommentDao{
	PreparedStatement ps;
	ResultSet rs;
	Connection connection;
	int result;
	
	@Override
	public boolean insertComment(Comment comment) {
		// TODO Auto-generated method stub
		String sql="insert into "
				+ "comment(commentContent,commentDate,fromUser,toUser,commentSupport,answerId) "
				+ "values(?,?,?,?,?,?)";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, comment.getCommentContent());
			ps.setString(2, comment.getCommentDate());
			ps.setString(3, comment.getFromUser());//fromUser
			ps.setString(4, comment.getToUser());//toUser
			ps.setInt(5, comment.getCommentSupport());//赞
			ps.setInt(6, comment.getAnswerId());
		
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result==0) {
			return false;
		}
		else return true;
	}

	@Override
	public boolean deleteComment(int commentId) {
		// TODO Auto-generated method stub
		String sql="delete from comment WHERE commentId=?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, commentId);			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		if (result==0) {
			return false;
		}
		else return true;
	}

	@Override
	public boolean updateComment(Comment comment) {
		// TODO Auto-generated method stub
		//System.out.println("new answer:"+answer);
		String sql="update comment SET commentContent=? WHERE commentId=?";
				
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, comment.getCommentContent());		
			ps.setInt(2, comment.getCommentId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result==0) {
			return false;
		}
		else return true;
	}

	@Override
	public List<Comment> getCommentByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getCommentByAnswerId(int answerId) {
		// TODO Auto-generated method stub
		String sql="SELECT * from comment where answerId=?";
		
		List<Comment> comments=new ArrayList<>();
		Comment comment=null;
		//用户
		
		connection = DBUtil.getConnection();
		
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, answerId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				comment=new Comment();
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentDate(rs.getString("commentDate"));
				comment.setCommentId(rs.getInt("commentId"));
				comment.setCommentSupport(rs.getInt("commentSupport"));
				comment.setFromUser(rs.getString("fromUser"));
				comment.setToUser(rs.getString("toUser"));
				comment.setAnswerId(rs.getInt("answerId"));

				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}

	@Override
	public Comment getCommentById(int commentId) {
		// TODO Auto-generated method stub
		Comment comment=null;
		User user=null;
		
		String sql="SELECT * from comment where commentId=?";
				
		connection = DBUtil.getConnection();
		
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);			
			ps.setInt(1, commentId);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				comment=new Comment();
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentDate(rs.getString("commentDate"));
				comment.setCommentId(rs.getInt("commentId"));
				comment.setCommentSupport(rs.getInt("commentSupport"));
				comment.setFromUser(rs.getString("fromUser"));
				comment.setToUser(rs.getString("toUser"));
				comment.setAnswerId(rs.getInt("answerId"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return comment;
	}

}
