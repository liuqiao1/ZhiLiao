package com.csu.test;


import java.util.List;

import com.csu.bean.Answer;
import com.csu.dao.AnswerDao;
import com.csu.dao.impl.AnswerDaoImpl;
import com.csu.util.TimeUtil;

/**
 * 测试answer接口实现 
 * @author 刘巧
 *
 */
public class testAnswer {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	    testAnswer test=new testAnswer();
	   // test.testInsert();
	   // test.testDelete();
	   // test.testUpdate();
	   // test.testFindAnswerById();
	   // test.testFindAnswersByQuestion();
	   // test.testFindAnswersByUser();
	    testUpdateSupport();
	}
	
	public void testInsert() {
		Answer answer=new Answer();
	   answer.setAnswerContent("这是我插入的一条回答");
	   answer.setAnswerDate(TimeUtil.getCurrentTime());
	   answer.setAnswerSupport(0);
	   answer.setIsAnoy(0);
	   
	   AnswerDao answerDao=new AnswerDaoImpl();
	   boolean result=answerDao.insertAnswer(answer);
	   System.out.println(result);
	}
	
	public void testDelete() {
		AnswerDao answerDao=new AnswerDaoImpl();
		Answer answer=new Answer();
		answer.setAnswerId(5);
		boolean result=answerDao.deleteAnswer(answer);
		System.out.println(result);
	}
	
	public void testUpdate() {
	   Answer answer=new Answer();
	   answer.setAnswerContent("这是新的");
	   answer.setAnswerDate(TimeUtil.getCurrentTime());
	   //answer.setAnswerSupport(0);
	   answer.setIsAnoy(1);
	   
	   AnswerDao answerDao=new AnswerDaoImpl();
	   boolean result=answerDao.updateAnswer(3, answer);
	   System.out.println(result);
	}
	
	public void testFindAnswerById() {
		AnswerDao answerDao=new AnswerDaoImpl();
		Answer answer=answerDao.getAnswerById(3);
		System.out.println(answer);
	}
	
	public void testFindAnswersByQuestion() {
		AnswerDao answerDao=new AnswerDaoImpl();
		List<Answer> answers=answerDao.getAnswerByQuestionId(1);
		System.out.println(answers);
	}
	
	public static void testFindAnswersByUser() {
		AnswerDao answerDao=new AnswerDaoImpl();
		List<Answer> answers=answerDao.getAnswerByUserId(1);
		System.out.println(answers);
	}
	
	public static void testUpdateSupport() {
		AnswerDao answerDao=new AnswerDaoImpl();
		boolean result=answerDao.updateAnswerSupport(2);
		System.out.println(result);
	}

}
