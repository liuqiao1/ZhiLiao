
package com.csu.dao;

import java.util.List;
import com.csu.bean.Answer;

/**
 * 回答 接口
 * @author 刘巧
 * 对应数据库回答表：answer
 * @use 对表 answer 进行增删改查操作，并对相关表进行级联操作
 * @time 创建时间：2016-12-8 修改时间：2016-12-8
 */
public interface AnswerDao {
	/**
	 * 插入一条新回答
	 * @author 刘巧
	 * @param answer 待插入的回答
	 * @return 是否插入成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public boolean insertAnswer(Answer answer);
	
	/**
	 * 删除一条回答
	 * @author 刘巧
	 * @param answer 待删除的回答
	 * @return 是否删除成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public boolean deleteAnswer(Answer answer);
	
	/**
	 * 根据编号删除一条回答
	 * @author 刘巧
	 * @param answer 待删除的回答
	 * @return 是否删除成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-15 修改时间：2016-12-15
	 */
	public boolean deleteAnswerById(int answerId);
	
	/**
	 * 修改一条回答
	 * @author 刘巧
	 * @param answerId 原回答编号
	 * @param answer 新回答
	 * @return 是否修改成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public boolean updateAnswer(int answerId,Answer answer);
	
	/**
	 * 根据回答编号查找一条回答
	 * @author 刘巧
	 * @param answerId 待查找回答的编号
	 * @return Answer 查找到的回答：如果为null说明无法查找
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public Answer getAnswerById(int answerId);
	
	/**
	 * 根据问题编号查找该问题所有回答
	 * @author 刘巧
	 * @param questionId 问题的编号
	 * @return List<Answer> 查找到的回答列表：如果为null说明无法查找
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public List<Answer> getAnswerByQuestionId(int questionId);
	
	/**
	 * 根据用户编号查找该用户的所有回答
	 * @author 刘巧
	 * @param questionId 问题的编号
	 * @return List<Answer> 查找到的回答列表：如果为null说明无法查找
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */	
	public List<Answer> getAnswerByUserId(int userId);

}
