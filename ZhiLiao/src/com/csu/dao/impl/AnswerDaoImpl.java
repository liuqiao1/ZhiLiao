package com.csu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csu.bean.Answer;
import com.csu.bean.Question;
import com.csu.bean.User;
import com.csu.dao.AnswerDao;
import com.csu.util.DBUtil;
import com.mysql.jdbc.PreparedStatement;

/**
 * 回答接口实现类
 * @author 刘巧
 * @time 创建时间：2016年12月8日 最后修改时间：2016年12月8日
 */
public class AnswerDaoImpl implements AnswerDao{

	PreparedStatement ps;
	ResultSet rs;
	Connection connection;
	int result;
	
	/**
	 * 插入一条新回答进入answer表
	 * @param answer 待插入回答
	 * @return 插入结果 
	 */
	@Override
	public boolean insertAnswer(Answer answer) {
		// TODO Auto-generated method stub
		String sql="insert into "
				+ "answer(answerContent,answerDate,answerUser,support,questionId,asIsAnoy) "
				+ "values(?,?,?,?,?,?)";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, answer.getAnswerContent());
			ps.setString(2, answer.getAnswerDate());
			ps.setInt(3, 1);//用户编号 
			ps.setInt(4, answer.getAnswerSupport());
			ps.setInt(5, 1);//问题编号 
			ps.setInt(6, answer.getIsAnoy());
			
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
	 * 删除一条回答从answer表
	 * @param answer 待删除回答
	 * @return 插入结果 
	 * delete from answer WHERE answer.answerId=5
	 */
	@Override
	public boolean deleteAnswer(Answer answer) {
		// TODO Auto-generated method stub
		String sql="delete from answer WHERE answer.answerId=4";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, answer.getAnswerId());			
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
	 * 更新一条回答
	 * @param answer 更新后的回答
	 * @param answerId 待更新回答的编号
	 * @return 更新结果 
	 * update answer SET answerContent='this is new' WHERE answerId=3
	 */
	@Override
	public boolean updateAnswer(int answerId, Answer answer) {
		// TODO Auto-generated method stub
		System.out.println("new answer:"+answer);
		String sql="update answer SET answerContent=?,asLatsUpdateDate=?,asIsAnoy=? WHERE answerId=?";
				
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, answer.getAnswerContent());		
			ps.setString(2, answer.getAnswerDate());
			ps.setInt(3, answer.getIsAnoy());
			ps.setInt(4, answerId);
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
	 * 根据回答编号查找该回答
	 * @param answerId 回答编号
	 * @return 找到的回答
	 * SELECT A.answerId,A.answerContent,A.answerDate,A.asIsAnoy,A.support,
		Q.questionTitle,Q.questionDes,Q.questionDate,
		U.userName ,U.userImage
		FROM answer A,question Q,users U
		WHERE A.answerId=3 AND A.questionId=Q.questionId AND A.answerUser=U.userId
	 */
	@Override
	public Answer getAnswerById(int answerId) {
		// TODO Auto-generated method stub
		Answer answer=null;
		Question question=null;
		User user=null;
		
		String sql="SELECT A.answerId,A.answerContent,A.answerDate,A.asIsAnoy,A.support,"
				+ "Q.questionTitle,Q.questionDes,Q.questionDate,"
				+ "U.userName ,U.userImage  "
				+ "FROM answer A,question Q,users U  "
				+ "WHERE A.answerId=? AND A.questionId=Q.questionId AND A.answerUser=U.userId";
				
		connection = DBUtil.getConnection();
		
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);			
			ps.setInt(1, answerId);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				answer=new Answer();
				answer.setAnswerId(rs.getInt("answerId"));
				answer.setAnswerContent(rs.getString("answerContent"));
				answer.setAnswerDate(rs.getString("answerDate"));
				answer.setAnswerSupport(rs.getInt("support"));
				answer.setIsAnoy(rs.getInt("asIsAnoy"));
				
				question=new Question();
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setQuestionDes(rs.getString("questionDes"));
				question.setQuestionDate(rs.getString("questionDate"));
				
				//绑定用户域数据
				user=new User();
				user.setUserName(rs.getString("userName"));
				user.setImage(rs.getString("userImage"));
				
				answer.setQuestion(question);
				answer.setUser(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return answer;
	}

	/**
	 * 根据回答编号查找该回答
	 * @param answerId 回答编号
	 * @return 找到的回答
	 * SELECT answer.*, question.questionTitle, users.userName,users.userImage
		FROM answer,question,users
		WHERE answer.questionId=1 AND
		 answer.questionId=question.questionId AND
		  answer.answerUser=users.userId
	 */
	@Override
	public List<Answer> getAnswerByQuestionId(int questionId) {
		// TODO Auto-generated method stub
		String sql="SELECT answer.*, question.questionTitle, questionDes,"
				+ "users.userName,users.userImage,users.simpleIntro  "
				+ "FROM answer,question,users  "
				+ "WHERE answer.questionId=? AND "
				+ "answer.questionId=question.questionId AND "
				+ "answer.answerUser=users.userId";
		
		List<Answer> answers=new ArrayList<>();
		Answer answer=null;
		Question question=null;
		//用户
		
		connection = DBUtil.getConnection();
		
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, questionId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				answer=new Answer();
				answer.setAnswerId(rs.getInt("answerId"));
				answer.setAnswerContent(rs.getString("answerContent"));
				answer.setAnswerDate(rs.getString("answerDate"));
				answer.setAnswerSupport(rs.getInt("support"));
				answer.setIsAnoy(rs.getInt("asIsAnoy"));
				
				question=new Question();
				question.setQuestionTitle(rs.getString("questionTitle"));
				question.setQuestionDes(rs.getString("questionDes"));
				
				//用户部分：用户名，头像，一句话介绍			
				answer.setQuestion(question);
				answers.add(answer);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	/**
	 * 根据用户编号查找该用户的所有回答
	 * @param userId 用户编号
	 * @return 找到的回答
	 * SELECT answer.*,question.questionTitle
		FROM answer,question
		WHERE answer.answerUser=1 AND answer.questionId=question.questionId
	 */
	@Override
	public List<Answer> getAnswerByUserId(int userId) {
		// TODO Auto-generated method stub
		String sql="SELECT answer.*,question.questionTitle  "
				+ "FROM answer,question  "
				+ "WHERE answer.answerUser=? AND answer.questionId=question.questionId";
		
		List<Answer> answers=new ArrayList<>();
		Answer answer=null;
		Question question=null;
		
		connection = DBUtil.getConnection();
		
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				answer=new Answer();
				answer.setAnswerId(rs.getInt("answerId"));
				answer.setAnswerContent(rs.getString("answerContent"));
				answer.setAnswerDate(rs.getString("answerDate"));
				answer.setAnswerSupport(rs.getInt("support"));
				answer.setIsAnoy(rs.getInt("asIsAnoy"));
				answer.setAsLastUpdateDate(rs.getString("asLatsUpdateDate"));
				
				question=new Question();
				question.setQuestionTitle(rs.getString("questionTitle"));
				//question.setQuestionDes(rs.getString("questionDes"));					
				
				answer.setQuestion(question);
				answers.add(answer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	/**
	 * 根据编号删除一条回答
	 * @author 刘巧
	 * @param answer 待删除的回答
	 * @return 是否删除成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-15 修改时间：2016-12-15
	 */
	@Override
	public boolean deleteAnswerById(int answerId) {
		// TODO Auto-generated method stub
		String sql="delete from answer WHERE answer.answerId=?";
		connection = DBUtil.getConnection();
		try {
			ps=(PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, answerId);			
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
	
}
