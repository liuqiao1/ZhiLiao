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

import com.csu.bean.Save;
import com.csu.bean.User;
import com.csu.dao.SaveDao;
import com.csu.dao.impl.SaveDaoImpl;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet.do")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SaveDao saveDao = new SaveDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
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
	
	public void addFold(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("loginUser");
		
		String fold_title = request.getParameter("title");
		String fold_desc = request.getParameter("desc");
		String is_public = request.getParameter("is");
		
		System.out.println("fold_title   "+fold_title);
		
		Save fold = new Save();
		
		if (is_public == null) {
			fold.setIsPublic(0);
		}else{
			fold.setIsPublic(1);
		}
		fold.setFoldName(fold_title);
		fold.setFoldDes(fold_desc);
		fold.setUser(user);
		
		boolean result=saveDao.addFold(fold);
		
		if (result) {
			System.out.println("创建收藏夹成功！");
			showMyFolds(request,response);
		}
		else{
			System.out.println("创建收藏夹失败！");
		}
		
		
	}
	
	public void deleteFold(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String fold_ID = request.getParameter("folderId");
		System.out.println("fold_ID"+fold_ID);
		
		Save fold = new Save();
		fold.setFoldId(Integer.parseInt(fold_ID));
		
		boolean result = saveDao.deleteFold(fold);
		if (result) {
			showMyFolds(request,response);
		}
		
	}
	
	public void updateFold(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("gggggggg");
		String fold_ID = request.getParameter("folderId2");
		String fold_title = request.getParameter("foldNameChange");
		String fold_desc = request.getParameter("foldDesChange");
		
		Save fold = new Save();
		fold.setFoldId(Integer.parseInt(fold_ID));
		fold.setFoldName(fold_title);
		fold.setFoldDes(fold_desc);
		fold.setIsPublic(0);
		System.out.println("foldID:"+fold_ID+fold_title+fold_desc);
		boolean result = saveDao.updateFold(fold);
		if (result) {
			showMyFolds(request, response);
		}
		
		
	}
	
	//根据用户编号找到该用户所有收藏夹 list 放到session里面  跳转到Save.jsp  <c:foreach> 
	
	public void showMyFolds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("loginUser");
		
		System.out.println("show my folds...");
		List<Save> myfolds=saveDao.getSaveByuserId(user.getUserId());
		System.out.println("myfolds:"+myfolds);
		System.out.println("size+"+myfolds.size());
		if (myfolds.size()==0) {
			System.out.println("你还没有收藏夹");
			response.sendRedirect("pages/noFold.jsp");	
		}else{
			
			session.setAttribute("myfolds", myfolds);
			response.sendRedirect("http://localhost:8080/ZhiLiao/pages/admin/Save.jsp");
		}
		
	}
	
	

}
