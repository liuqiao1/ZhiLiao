package com.csu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csu.bean.Question;
import com.csu.bean.User;
import com.csu.dao.QuestionDAO;
import com.csu.dao.impl.QuestionDAOImpl;
import com.csu.util.TimeUtil;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDAO questionDAO = new QuestionDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String methodName = request.getParameter("method");
		System.out.println(methodName);
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
	
	/**
	 * 提交问题
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void submitQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Question question = new Question();
//		System.out.println("我现在是在问题新增页面");
		HttpSession session = request.getSession();
				
		String qIsAnoy = request.getParameter("qIsAno");
		
		//----测试段----
		User user = new User();
		user.setUserId(6);
		user.setUserName("测试用户");
	
		question.setQuestionTitle(request.getParameter("questionTitle"));
		question.setQuestionContent(request.getParameter("questionContent"));
		question.setQuestionDate(Timestamp.valueOf(TimeUtil.getCurrentTime()));
//		question.setUser(session.getAttribute("user"));
		question.setUser(user);//测试
		
		question.setQuestionLastUpdateTime(Timestamp.valueOf(TimeUtil.getCurrentTime()));
		
		 if (qIsAnoy==null) {
		    	question.setqIsAno(false);
			}
		    else question.setqIsAno(true);
		 
		 boolean result = questionDAO.addQuestion(question);
		 
		 if(result){
			request.setAttribute("question", question);
			request.getRequestDispatcher("pages/qDisplay.jsp").forward(request, response);
		 }
		 else {//提交失败
		
		 }
	
	}
	
	
	/**
	 * 通过页面传递过来的内容更新问题的标题，内容和最近一个修改时间
	 * @param request
	 * @param response
	 */
	public void updateQuestion(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		Question question = new Question();
		int questionId =Integer.parseInt(request.getParameter("questionId"));
		
		question.setQuestionId(questionId);
		question.setQuestionTitle(request.getParameter("questionTitle"));
		question.setQuestionContent(request.getParameter("questionContent"));
		question.setQuestionLastUpdateTime(Timestamp.valueOf(TimeUtil.getCurrentTime()));
		
		boolean result = questionDAO.updataQuestion(question);
		
		if (result){
			//修改成功，跳转到修改后的问题页面
			System.out.println("修改成功");
			response.sendRedirect("pages/qDisplay.jsp");
		}
		else{
			//修改失败，跳转回原来的qDisplay.jsp
			System.out.println("修改不成功");
		}
	}
	
	/**
	 * 通过页面传过来的问题id来删除该问题，
	 * @param request
	 * @param response
	 * @return true：成功，跳转listByUserId方法； false：失败，跳转回原来的问题界面
	 * 			
	 */
	public void deleteQuestion(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
//		int questionId = Integer.parseInt(request.getParameter("questionId"));
//		HttpSession session = request.getSession();
		boolean result = questionDAO.deleteQuestion(50);
//		boolean result = questionDAO.deleteQuestion(questionId);
		if(result){
			//调用listByUserId()方法
			System.out.println("删除成功");
//			listByUserId(request,response);
		}
		else{
			//跳出窗口提示失败
			//跳转到qDisplay.jsp
			System.out.println("删除不成功");
//			response.sendRedirect("pages/qDisplay.jsp");
		}
		
	}
	
	public void goEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int questionId =Integer.parseInt(request.getParameter("questionId"));
		Question question = questionDAO.searchQuestionById(questionId);
		request.setAttribute("questionWaitToUpdate", question);
		request.getRequestDispatcher("pages/qSubmit.jsp").forward(request, response);
	}
	
	/**
	 * 通过问题ID来对问题进行搜索
	 * @param request
	 * @param response
	 * @return true：成功，显示搜索的结果；false：失败，跳转到搜索失败的页面
	 */
	public Question searchQuestionById(HttpServletRequest request, HttpServletResponse response){
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		
		Question result = questionDAO.searchQuestionById(questionId);
		
		if(result!=null){
			return result;
		}
		else return null;
	}
	
	/**
	 * 通过搜索框传递过来的字符串进行搜索
	 * @param request
	 * @param response
	 * @return：List<Question> 返回搜索到的问题列表
	 */
	public List<Question> searchQuestion(HttpServletRequest request, HttpServletResponse response){
		
		
		String str = request.getParameter("keyString");
		
		List<Question> list = questionDAO.searchQuestion(str);
		
		if(list!=null){
			return list;
		}
		else return null;
	}
	
	
	
	/**
	 * 将用户的所有问题都通过用户ID搜索以后展示
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Question> listByUserId(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		
		int userId = 
//				session.getUserId();
		Integer.parseInt(request.getParameter("userId"));
		
		List<Question> list = questionDAO.listByUserId(userId);
		
		if(list != null){
			return list;
		}
		else return null;
	}
	
}
