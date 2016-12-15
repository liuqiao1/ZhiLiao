package com.csu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csu.bean.Answer;
import com.csu.dao.AnswerDao;
import com.csu.dao.impl.AnswerDaoImpl;
import com.csu.util.TimeUtil;

/**
 * Servlet implementation class AnswerServlet
 */

@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnswerDao answerDao=new AnswerDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String methodName = request.getParameter("method");
		System.out.println("methodName:"+methodName);
	        try {
	            // 利用反射获取方法
	            Method method = getClass().getDeclaredMethod(methodName,
	                    HttpServletRequest.class, HttpServletResponse.class);
	            // 执行相应的方法
	            method.invoke(this, request, response);
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	}
	
	public void submitAnswer(HttpServletRequest request, HttpServletResponse response) {
		
		String word_content = request.getParameter("container");
		String isAnoy=request.getParameter("isAnoy");
		//System.out.println("word_content"+word_content);
		//System.out.println(request.getParameter("isAnoy"));
		//假装接收参数值
		Answer answer=new Answer();
	    answer.setAnswerContent(word_content);
	    answer.setAnswerDate(TimeUtil.getCurrentTime());
	    answer.setAnswerSupport(0);
	    if (isAnoy==null) {
	    	answer.setIsAnoy(0);
		}
	    else answer.setIsAnoy(1);
	    //取出当前问题的回答
	    //answer.setQuestion(question);
	    //从session中取出当前用户
	    //answer.setUser(user);
	    //调用dao 插入数据库
	    boolean result=answerDao.insertAnswer(answer);
	    //根据执行结果选择跳转
	    if (result) {//回答成功:跳转到 问题详情页
			//response.sendRedirect("");
	    	
		}
	    else{//回答失败 //可选择留在写回答页  或者 返回问题详情页
	    	//response.sendRedirect("");
	    	
	    }
		//return null;		
	}
	
	public void showMyAnswers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println("showMyAnswers....");
		List<Answer> myAnswers=answerDao.getAnswerByUserId(1);
		//System.out.println("myAnswers:"+myAnswers);
		if (myAnswers.size()==0) {
			System.out.println("你还没有回答过任何问题");
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("myAnswers", myAnswers);
			response.sendRedirect("pages/myAnswers.jsp");
		}
	}
	
	public void deleteAnswer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("deleteAnswer....");
		System.out.println(request.getParameter("answerId"));
		int answerId=Integer.parseInt(request.getParameter("answerId"));
		boolean result=answerDao.deleteAnswerById(answerId);
		if (result) {//删除成功；
			showMyAnswers(request, response);
		}
		else{//删除失败
			System.out.println("删除失败");
		}
	}
	
	public void updateAnswer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("updateAnswer....");
		String word_content = request.getParameter("container");
		String isAnoy=request.getParameter("isAnoy");
		//System.out.println(request.getParameter("answerIdInput"));
		int answerId=Integer.parseInt(request.getParameter("answerIdInput"));
		
		Answer answer=new Answer();
	    answer.setAnswerContent(word_content);
	    answer.setAnswerDate(TimeUtil.getCurrentTime());
	    //answer.setAnswerSupport(0);
	    if (isAnoy==null) {
	    	answer.setIsAnoy(0);
		}
	    else answer.setIsAnoy(1);
	    //取出当前问题的回答
	    //answer.setQuestion(question);
	    //从session中取出当前用户
	    //answer.setUser(user);
	    //调用dao 插入数据库
	    boolean result=answerDao.updateAnswer(answerId, answer);
	    //根据执行结果选择跳转
	    if (result) {//回答成功:跳转到 问题详情页
			//response.sendRedirect("");
	    	System.out.println("修改成功");
		}
	    else{//回答失败 //可选择留在写回答页  或者 返回问题详情页
	    	//response.sendRedirect("");
	    	System.out.println("修改失败");
	    }
		//return null;		
		
	}
	
	public void goEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int answerId=Integer.parseInt(request.getParameter("answerId"));
		Answer answer=answerDao.getAnswerById(answerId);
		System.out.println(answer);
		request.setAttribute("answerWaitToUpdate", answer);
		request.getRequestDispatcher("pages/writeAnswer.jsp").forward(request,response);
	}

}
