package fr.eni.qcm.IHM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.UserManager;
import fr.eni.qcm.BO.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd  = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");		
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserManager um = new UserManager();
		User user = new User();
		HttpSession session = request.getSession();
		
		try {
			user = um.loginUser(request.getParameter("email"), request.getParameter("password"));
			session.setAttribute("user", user);
			RequestDispatcher rd  = request.getRequestDispatcher("WEB-INF/jsp/accueilTest.jsp");		
			rd.forward(request, response);			
			
		} catch (BusinessException e) {
			request.setAttribute("exception", e.getError().getDescription());
			RequestDispatcher rd  = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
