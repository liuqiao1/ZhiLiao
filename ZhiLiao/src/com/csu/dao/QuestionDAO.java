package com.csu.dao;

import java.util.List;

import com.csu.bean.Question;

/**
 * 问题接口
 * @author 唐嘉良
 *对应数据库问题表：question
 *@use 对表question进行增删改查操作，并对相关表进行级联操作
 *@time 创建时间： 2016-12-9 修改时间 2016-12-10
 */

public interface QuestionDAO {

	/**
	 * 新增一个问题
	 * @author 唐嘉良
	 * @param question 待新增的问题
	 * @return 是否新增成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-9 修改时间 2016-12-10
	 */
	public boolean addQuestion(Question question);
	
	
	
	/**
	 * 修改一个问题
	 * @author 唐嘉良
	 * @param question	修改后的问题
	 * @return 是否修改成功：true表示成功，false代表失败
	 * @time 创建时间：2016-12-9 修改时间 2016-12-10
	 */
	public boolean updataQuestion(Question question);
	
	
	/**
	 * 删除一个问题
	 * @author 唐嘉良
	 * @param question 待删除的问题
	 * @return 是否删除成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-9 修改时间 2016-12-10
	 */
	public boolean deleteQuestion(int questionId);
	
	
	/**
	 * 通过问题ID来搜索问题
	 * @author 唐嘉良
	 * @param questionId 问题的ID
	 * @return questionId代表的问题
	 * @time 创建时间：2016-12-10 修改时间：2016-12-12
	 */
	public Question searchQuestionById(int questionId);

	
	/**
	 * 通过字符串来搜索相关问题
	 * @author 唐嘉良
	 * @param str 输入搜索框的字符串
	 * @return List<Question> 返回的相关问题列表
	 * @time 创建时间：2016-12-10 修改时间：2016-12-12
	 */
	public List<Question> searchQuestion(String str);
	
	
	/**
	 * 关注一个问题，将一个问题的id添加到用户的关注列表
	 * @author 唐嘉良
	 * @param userId 用户的ID 
	 * @param questionId  问题的id
	 * @return 是否关注成功：true表示关注成功，false表示关注失败
	 * @time 创建时间：2016-12-9 修改时间：2016-12-10
	 */
	public boolean focusQuestion(int questionId,int userId);
	
	
	/**
	 * 通过用户ID来搜索该作者的发表的全部问题
	 * @author 唐嘉良
	 * @param userID  
	 * @return userID下面的所有的问题
	 * @time 创建时间：2016-12-10 修改时间：2016-12-12
	 */
	public List<Question> listByUserId(int userId);
	

}
