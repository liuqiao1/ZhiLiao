package com.csu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csu.bean.User;

/**
 * Servlet Filter implementation class AccessPurviewFilter
 * 
 * @author 刘巧
 * @time 创建时间 2016-12-16 最后修改时间 2016-12-16
 * 
 */
 
@WebFilter("/pages/admin/*")
public class Filter1_AccessPurviewFilter implements Filter {
	 /**   
     *  重定向的URL   
     */    
    private String redirectURl = null;  

    /**
     * Default constructor. 
     */
    
    public Filter1_AccessPurviewFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("AccessPurviewFilter....");
		HttpServletRequest myRequest = (HttpServletRequest) request;  
		HttpServletResponse myResponse = (HttpServletResponse) response;
		
		HttpSession session=myRequest.getSession();
		User user=(User) session.getAttribute("loginUser");
		
		String currentURL = myRequest.getRequestURI(); // 取得根目录所对应的绝对路径:  
	    String targetURL = currentURL.substring(currentURL.indexOf("/", 1),  
		    currentURL.length()); // 截取到当前文件名用于比较  
	    
	    System.out.println("currentURL"+currentURL);
	    System.out.println("targetURL"+targetURL);

	    if (!"/pages/user".equals(targetURL) && !"/pages/login.jsp".equals(targetURL)) { 
	    	System.out.println("不是请求登录");
	    	if(user!=null){
			  //filter.doFilter(request, response);
			  //
			  System.out.println("已登录，可继续访问");
		  	}else{
			  System.out.println("未登录，请先登录");
			  //myResponse.setContentType("text/html;charset=utf-8");
			  myResponse.sendRedirect("http://localhost:8080/ZhiLiao/pages/login.jsp");//myRequest.getContextPath()+
			  return;
		  	}
	    }
	    else{
	    	System.out.println("是请求登录");
	    }
		 chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 redirectURl = "http://localhost:8080/ZhiLiao/pages/login.jsp"; 
	}

}
