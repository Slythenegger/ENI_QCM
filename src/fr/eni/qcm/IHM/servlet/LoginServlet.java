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
import fr.eni.qcm.CodeRole;
import fr.eni.qcm.BLL.UserManager;
import fr.eni.qcm.BO.User;

/**
 * Classe en charge de la gestion de l'authentification pour l'application
 * @author stropee2017
 * @date 27 mars 2018
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * Méthode en charge de diriger l'utilsateur sur la page de connexion
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		RequestDispatcher rd  = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");		
		rd.forward(request, response);
				
	}

	/**
	 * Méthode en charge de valider les données reçus lors de l'authentification et le rediriger en fonction
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserManager um = new UserManager();
		User user = new User();
		HttpSession session = request.getSession();
		
		try {
			user = um.loginUser(request.getParameter("email"), request.getParameter("password"));
			session.setAttribute("user", user);
			
			session.setAttribute("stagiaire", CodeRole.CODE_STAGIAIRE);
			session.setAttribute("formateur", CodeRole.CODE_FORMATEUR);
			session.setAttribute("candidat", CodeRole.CODE_CANDIDAT);
			session.setAttribute("responsable", CodeRole.CODE_RESPONSABLE);
			
						
			RequestDispatcher rd  = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");		
			rd.forward(request, response);			
			
		} catch (BusinessException e) {
			request.setAttribute("exception", e.getError().getDescription());
			RequestDispatcher rd  = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
