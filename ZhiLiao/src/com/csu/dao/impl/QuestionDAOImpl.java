package com.csu.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csu.bean.Question;
import com.csu.bean.User;
import com.csu.dao.QuestionDAO;
import com.csu.util.DBUtil;
import com.mysql.jdbc.PreparedStatement;

/**
 * 问题接口实现类
 * @author 唐嘉良
 * @time 创建时间 2016-12-9 
 * 		修改时间：2016-12-11  add/update/delete
 * 				2016-12-13 search/list
 *
 */
public class QuestionDAOImpl implements QuestionDAO{

	PreparedStatement ps;
	ResultSet rs;
	Connection connection;
	int result;
	
	
	/**
	 * 新增一个问题到question表
	 * @param question 待增加的问题
	 * @return 是否插入：true 成功；false 失败
	 * 
	 */
	
	@Override
	public boolean addQuestion(Question question) {
		String sql="insert into "
				+ "question(questionId,questionTitle,questionContent,userId,qIsAno,questionDate) "
				+ "values(default,?,?,?,?,?)";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1,question.getQuestionTitle());
			ps.setString(2,question.getQuestionContent());
			ps.setInt(3,question.getUser().getUserId());
			ps.setBoolean(4,question.isqIsAno());
			ps.setTimestamp(5,question.getQuestionDate());
			
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
	
	/**
	 * 修改一个问题
	 * @param question 修改后的回答
	 * @param questionId 待修改问题的编号
	 * @return 修改是否成功：true 成功；false 失败
	 */

	@Override
	public boolean updataQuestion(Question question) {
		// TODO Auto-generated method stub
		String sql = "update question "
					+ "SET questionTitle=?,questionContent=?,questionLastUpdateTime=? "
					+ "WHERE questionId=?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1,question.getQuestionTitle());
			ps.setString(2,question.getQuestionContent());	
			ps.setTimestamp(3,question.getQuestionDate());
			ps.setInt(4,question.getQuestionId());
			
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
	
	/**
	 * 从question表删除一个问题
	 * @param quetion 待删除问题
	 * @return 删除是否成功：true 成功；false 失败
	 * 
	 */
	@Override
	public boolean deleteQuestion(int questionId) {
		
		
		String sql="delete Q.*,A.* "
				+ "from question Q,answer A "
				+ "WHERE Q.questionId=? or A.questionId=?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1,questionId);
			ps.setInt(2,questionId);	
			
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
	
	
	/**
	 * 通过问题编号搜索问题
	 * @param questionId 问题编号
	 * @return 问题编号对应的问题
	 */
	@Override
	public Question searchQuestionById(int questionId) {
		Question question =null;
		User user = null;
		
		
		String sql = "select Q.*,U.userName,U.userImg "
				+ "from question Q,users U "
				+ "WHERE Q.questionId=? and Q.userId=U.userId";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1,questionId);		
		
			rs=ps.executeQuery();
			if(rs.next()){
			
				question = new Question();
				question.setQuestionId(rs.getInt("questionId"));
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setQuestionContent(rs.getString("questionContent"));
				question.setQuestionDate(rs.getTimestamp("questionDate"));
				question.setQuestionLastUpdateTime(rs.getTimestamp("questionLastUpdateTime"));
				question.setqIsAno(rs.getBoolean("qIsAno"));
				
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setImage(rs.getString("userImg"));
				
				question.setUser(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return question;
	}
	
	
	/**
	 * 通过字符串搜索问题
	 * @param str 输入的字符串
	 * @return 与字符串匹配的问题列表
	 */
	@Override
	public List<Question> searchQuestion(String str) {
		List<Question> questions = new ArrayList<>();
		Question question = null;
		User user = null;

		String sql = "select Q.*,U.userName,U.userImg "
				+ "from question Q,users U "
				+ "WHERE Q.questionTitle REGEXP ?"
				+ "or Q.questionContent REGEXP ?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1,"'["+str+"]'");
			ps.setString(2,"'["+str+"]'");
		//这里考虑怎么使用正则表达式还是like,使用正则表达式的话到底怎么样进行匹配，是直接将输入的字符串匹配，还是分词以后再匹配
			
			rs=ps.executeQuery();
			while(rs.next()){
				//跳转到搜索结果页面，根据发布时间/回答数来展示tile或者内容里面有str的问题
				question = new Question();
				question.setQuestionId(rs.getInt("questionId"));
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setQuestionContent(rs.getString("questionContent"));
				question.setQuestionDate(rs.getTimestamp("questionDate"));
				question.setQuestionLastUpdateTime(rs.getTimestamp("questionLastUpdateTime"));
				question.setqIsAno(rs.getBoolean("qIsAno"));
				
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setImage(rs.getString("userImg"));
				
				question.setUser(user);
				
				questions.add(question);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return questions;
	}
	
	
	/**
	 * 根据用户编号查找该用户的所有提问
	 * @param userID 用户编号
	 * @return 用户的所有提问列表
	 */
	@Override
	public List<Question> listByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Question> questions = new ArrayList<>();
		Question question = null;
		User user = null;
		
		
		String sql = "select * "
				+ "from question "
				+ "where userId=?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1,userId);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				question = new Question();//在此处只希望展示title和Date的内容
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setQuestionDate(rs.getTimestamp("questionDate"));
				question.setQuestionId(rs.getInt("questionId"));
				question.setQuestionContent(rs.getString("questionContent"));
				question.setQuestionLastUpdateTime(rs.getTimestamp("questionLastUpdateTime"));
				question.setqIsAno(rs.getBoolean("qIsAno"));
				
				
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setImage(rs.getString("userImg"));
				
				question.setUser(user);
				
				questions.add(question);
				
				} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				
		return questions;	
	}

	@Override
	public boolean focusQuestion(int questionId, int userId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
