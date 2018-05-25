package cn.edu.nyist.bookmanv01.authfilter;

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
@WebFilter("/*")
public class AuthFilter implements Filter {
//过滤器
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest  rq=(HttpServletRequest) request;
		HttpServletResponse rsp=(HttpServletResponse) response;
		//这时候的注解是拦截所有，要告诉它什么不拦
		//loginservlet、login.jsp、bower-components文件下的(css、js)和验证码的vcode.png不拦
		String url=rq.getRequestURI();
		System.out.println(url);
		if (url.endsWith("/login")||url.endsWith("login.jsp")||url.contains("/bower_components/")||url.endsWith("vcode.png")) {
			//rsp.sendRedirect("login.jsp");不需要在指定执行到那个页面，而是让它执行。
			chain.doFilter(request, response);
			return;
		}
		if (rq.getSession().getAttribute("loginSession")==null||!rq.getSession().getAttribute("loginSession").equals("1")) {
			rsp.sendRedirect("login.jsp");
			return;
		}else {
			chain.doFilter(request, response);//登录成功后往下执行
		}

	}

	@Override
	public void destroy() {

	}

}
