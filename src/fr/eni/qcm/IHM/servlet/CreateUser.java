package fr.eni.qcm.IHM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.UserManager;
import fr.eni.qcm.BO.Promo;
import fr.eni.qcm.BO.Role;
import fr.eni.qcm.BO.User;

/**
 * Classe en charge de permettre l'affichage traitant de la création d'un
 * nouveau candidat-user
 * 
 * @author stropee2017
 * @date 27 mars 2018
 */
@WebServlet("/nouveau-candidat")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode en charge de diriger l'utilisateur sur la page pour créer un nouveau
	 * candidat
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserManager um = new UserManager();
		List<Role> roles = null;
		List<Promo> promos = null;
		
		HttpSession session = request.getSession();

		try {
			roles = um.findRoles();
			promos = um.findPromos();

		} catch (BusinessException e) {
			request.setAttribute("exception", e.getError().getDescription());
		}
		session.setAttribute("roles", roles);
		session.setAttribute("promos", promos);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/creationCandidat.jsp");
		rd.forward(request, response);
	}

	/**
	 * Méthode en charge de receptionner les données du formulaire pour créer un
	 * nouveau candidat-user
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserManager um = new UserManager();
		User user = new User();
	
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		user.setIdPromo(request.getParameter("promo"));

		try {
			um.createUser(user);
			request.setAttribute("info", "Candidat ajouté avec succès !S");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
			rd.forward(request, response);

		} catch (BusinessException e) {
			request.setAttribute("newUser", user);
			request.setAttribute("exception", e.getError().getDescription());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/creationCandidat.jsp");
			rd.forward(request, response);
		}		
		

	}

}
