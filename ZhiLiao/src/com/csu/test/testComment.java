package com.csu.test;

import java.util.ArrayList;
import java.util.List;

import com.csu.bean.Answer;
import com.csu.bean.Comment;
import com.csu.dao.CommentDao;
import com.csu.dao.impl.CommentDaoImpl;
import com.csu.util.TimeUtil;

//2016年12月16 日 AdministratortestComment.java
public class testComment {
	public static void main(String[] args) {
		CommentDao commentDao=new CommentDaoImpl();
		testComment test=new testComment();
		//test.testInsert(commentDao);
		//test.testDeleteOne(commentDao);
		//test.testUpdate(commentDao);
		//test.testGetCommentById(commentDao);
		test.testGetCommentByAnswerId(commentDao);
		
	}
	
	
	public void testInsert(CommentDao commentDao) {
		Comment comment=new Comment();
		comment.setCommentContent("这是第一条评论");
		comment.setCommentDate(TimeUtil.getCurrentTime());
		comment.setCommentSupport(0);
		comment.setFromUser("a");
		comment.setToUser("刘巧");
		comment.setAnswerId(1);
		
		commentDao.insertComment(comment);
	}
	
	public void testDeleteOne(CommentDao commentDao) {
		commentDao.deleteComment(1);
	}
	
	public void testUpdate(CommentDao commentDao) {
		Comment comment=new Comment();
		comment.setCommentContent("这是修改第一条评论");
		//comment.setCommentDate(TimeUtil.getCurrentTime());
		//comment.setCommentSupport(0);
		//comment.setFromUser("a");
		//comment.setToUser("刘巧");
		comment.setCommentId(2);
		
		commentDao.updateComment(comment);
	}
	
	public void testGetCommentById(CommentDao commentDao) {
		Comment comment=commentDao.getCommentById(2);
		System.out.println(comment);
	}
	
	public void testGetCommentByAnswerId(CommentDao commentDao) {
		List<Comment> comments=commentDao.getCommentByAnswerId(1);
		System.out.println(comments);
	}

}
