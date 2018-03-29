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
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;		
		HttpSession session = req.getSession();
		
		String context = request.getServletContext().getContextPath();
		String path = req.getRequestURI();
		
		
		// URL public
		if (
			path.startsWith(context + "/vendor") ||
			path.startsWith(context + "/asset") ||
			path.startsWith(context + "/login")
		) {
			chain.doFilter(request, response);
			return;
		}
		
		// Pas authentifié
		if (session.getAttribute("user") == null) {
			res.sendRedirect(context + "/login");
			return;
		}
		
		// TODO: ajout du filtre url en fonction des roles
		chain.doFilter(request, response);
	}
	
    public SessionFilter() {

    }
    
	public void destroy() {
		
	}

}
