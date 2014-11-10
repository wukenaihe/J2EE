package cn.edu.zju.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import cn.edu.zju.common.CommonConstant;
import cn.edu.zju.entity.User;


public class LoginFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	private static final String[] INHERENT_ESCAPE_URIS = { "/resources", "login", "doLogin"};
	
	private ThreadLocal<User> threadLocal=new ThreadLocal<User>();

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			User userContext = getSessionUser(httpRequest);
			// Is logined
			if (!isLogin(userContext, httpRequest, httpResponse)) {
				return;
			}
			//save to localThread
			UserTool.set(userContext);			
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	private User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(CommonConstant.USER_ATTR);
	}

	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURI) || (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
			return true;
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 
	 * 
	 * @param user
	 * @param httpRequest
	 * @param httpResponse
	 * @return
	 * @throws IOException
	 */
	private boolean isLogin(User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
		if (user == null && !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
			String toUrl = httpRequest.getRequestURL().toString();
			if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
				toUrl += "?" + httpRequest.getQueryString();
			}

			httpRequest.getSession().setAttribute(CommonConstant.LOGIN_TO_URL, toUrl);

			// request.getRequestDispatcher("/login.jsp").forward(request,
			// response);
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
			return false;
		}
		return true;
	}

}
