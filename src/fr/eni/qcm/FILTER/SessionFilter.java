package fr.eni.qcm.FILTER;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionFilter implements Filter {
    public SessionFilter() {

    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}
	
	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;		
		HttpSession session = req.getSession();
		
		String loginURL = request.getServletContext().getContextPath() + "/login";
		String path = req.getRequestURI();
		
		if (session.getAttribute("user") != null || path.equals(loginURL)) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(loginURL);
		}
	}


}
