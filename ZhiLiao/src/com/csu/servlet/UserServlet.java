package com.csu.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.csu.bean.User;
import com.csu.dao.UserDao;
import com.csu.dao.impl.UserDaoImpl;
import com.csu.util.MailUitls;
import com.csu.util.Randomutil;
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao=new UserDaoImpl();
	public UserServlet(){	
		 super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub;
		  doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;Charset=utf-8");
		String action = request.getParameter("action");
		System.out.println("action="+action);
		if(action==null||"".equals(action))
		{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else if("userAdd".equals(action))
		{
			userAdd(request, response);//新增用户
		}else if("userLogin".equals(action)){
			userLogin(request, response);//用户登录
		}else if("checkEmail".equals(action)){
			checkEmail(request, response);//检查邮箱是否存在
		}else if("modifyPwd".equals(action)){
			modifyPwd(request,response);
		}else if("checkCode".equals(action)){
			checkCode(request,response);
		}else if("userExit".equals(action)){
			userExit(request,response);
		}
		System.out.println("action="+action);
	}
	/**
	 * author:刘巧
	 * 退出登录
	 * @param request
	 * @param response
	 * 创建时间：2016-12-16  最后修改时间：2016-12-16
	 * @throws IOException 
	 */
	private void userExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//获取session
		HttpSession session=request.getSession();
		//清空session
		session.invalidate();
		//跳转到登录页面
		response.sendRedirect("http://localhost:8080/ZhiLiao/pages/login.jsp");
	}

	private void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;Charset=utf-8");
		PrintWriter  out=response.getWriter();
		String checkEmailCode= request.getParameter("checkEmailCode");
		HttpSession session = request.getSession();
	    String Code=(String)session.getAttribute("code");
		if(!(checkEmailCode.equals(Code))){
			out.println("<script>alert('对不起，您输入的验证码错误!');</script>");
			System.out.println("输入的验证码为:"+checkEmailCode);
			System.out.println("系统产生的验证码为:"+Code);
			response.setHeader("refresh","0;url=inputCode.jsp");
		}else{
			 RequestDispatcher dispatcher = request.getRequestDispatcher("modifyPwd.jsp");
			 dispatcher .forward(request, response);
		}
		
	}

	private void modifyPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;Charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession();
		User user=new User();
		String  password= request.getParameter("password");
		String UserName=(String)s.getAttribute("UserName");
		user.setPassWord(password);
		user.setUserName(UserName);
		boolean flag=userDao.modifyPwd(user);
		if(flag){
		out.println("<script>alert('修改密码成功!');</script>");
		response.setHeader("refresh","0;url=login.jsp");
		}else{
			out.println("<script>alert('修改密码失败!');</script>");
			response.setHeader("refresh","0;url=login.jsp");
		}
	}

	private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;Charset=utf-8");
		PrintWriter out = response.getWriter();
		MailUitls mailUitl=new MailUitls();
		User user=new User();
		String  username= request.getParameter("username");
		String  email= request.getParameter("email");
		user.setUserName(username);
		user.setEmail(email);
		boolean flag=userDao.isCheckEmail(user);
		if(!flag){
			out.println("<script> alert('用户名和邮箱不匹配!');</script>");
			response.setHeader("refresh","0;url=checkEmail.jsp");
		}else{
			request.getSession().setAttribute("UserName",user.getUserName());
			//imageServlet.doGet(request, response);
			String code=Randomutil.getRandom();
			HttpSession session = request.getSession();
		    session.setAttribute("code",code);
		    session.setMaxInactiveInterval(900);
		    mailUitl.sendMail(user.getEmail(),code);
			out.println("<script> alert('验证码已经发送到您的邮箱!');</script>");
			response.setHeader("refresh","0;url=inputCode.jsp");
		}
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;Charset=utf-8");
		PrintWriter out = response.getWriter();
		User user=new User();
		String  username= request.getParameter("username");
		String  password= request.getParameter("password");
		user.setUserName(username);
		user.setPassWord(password);
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		user=userDao.login(user);
		if(user!=null){
			HttpSession session = request.getSession();
		    session.setAttribute("loginUser", user);
		    session.setMaxInactiveInterval(3000);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		    dispatcher .forward(request, response);
		}else{
			out.println("<script> alert('用户名或者密码错误!');</script>");
		}
		response.setHeader("refresh","0;url=login.jsp");
		out.flush();
		out.close();
	}

	
	
	private void userAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;Charset=utf-8");
		PrintWriter out = response.getWriter();
		User user=new User();
		String  username= request.getParameter("username");
		String  password= request.getParameter("password");
		String  email= request.getParameter("email");
		String checkCode=request.getParameter("checkcode");  //取值
		HttpSession s = request.getSession();
		String piccode=(String)s.getAttribute("piccode");//取出之前生成的验证码，与输入的作比较
		user.setUserName(username);
		user.setPassWord(password);
		user.setEmail(email);
		boolean isUserName=userDao.isUserName(user);
		boolean isEmail=userDao.isEmail(user);
		if(isUserName){
			out.println("<script> alert('该用户名已经存在!');</script>");
		}else if(isEmail){
			out.println("<script> alert('该邮箱已经存在!');</script>");
		}else if(!(checkCode.equalsIgnoreCase(piccode))){
			out.println("<script>alert('验证码输入错误');</script>");
		}else {
			userDao.add(user);
			out.println("<script> alert('注册成功');</script>");
		}
		response.setHeader("refresh","0;url=./regist.jsp");
		out.flush();
		out.close();
		}	
	}