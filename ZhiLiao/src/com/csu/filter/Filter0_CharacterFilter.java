package com.csu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharacterFilter
 * @author 刘巧
 * @time 创建时间 2016-12-9 最后修改时间 2016-12-9
 */
@WebFilter
("/*")
public class Filter0_CharacterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public Filter0_CharacterFilter() {
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
		// place your code here

		// pass the request along the filter chain
		System.out.println("CharacterFilter...");
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");

		// 接着执行后面的代码（下一个过滤器或者是servlet）
		chain.doFilter(request, response);

		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
