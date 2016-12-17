package com.csu.dao;

import java.util.List;

import com.csu.bean.Comment;

/**
 * 回答 接口
 * @author 董作进
 * 对应数据库回答表：comment
 * @use 对表 comment 进行增删改查操作，并对相关表进行级联操作
 * @time 创建时间：2016-12-8 修改时间：2016-12-8
 */
public interface CommentDao {
	/**
	 * 插入一条新评论
	 * @author 董作进
	 * @param comment 待插入的评论
	 * @return 是否插入成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public boolean insertComment(Comment comment);
	
	/**
	 * 删除一条评论
	 * @author 董作进
	 * @param answer 待删除的评论
	 * @return 是否删除成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public boolean deleteComment(int commentId);
	
	/**
	 * 修改一条评论
	 * @author 董作进
	 * @param answer 新评论
	 * @return 是否修改成功：true代表成功，false代表失败
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public boolean updateComment(Comment comment);
	
	/**
	 * 根据用户编号查找该用户的所有评论
	 * @author 董作进
	 * @param questionId 用户的编号
	 * @return List<Answer> 查找到的评论列表：如果为null说明无法查找
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */	
	public List<Comment> getCommentByUserId(int userId);
	
	/**
	 * 根据回答编号查找该回答所有评论
	 * @author 董作进
	 * @param questionId 回答的编号
	 * @return List<Answer> 查找到的评论列表：如果为null说明无法查找
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public List<Comment> getCommentByAnswerId(int answerId);
	
	/**
	 * 根据评论编号查找一条回答
	 * @author 董作进
	 * @param answerId 待查找评论的编号
	 * @return Answer 查找到的评论：如果为null说明无法查找
	 * @time 创建时间：2016-12-8 修改时间：2016-12-8
	 */
	public Comment getCommentById(int commentId);

}
