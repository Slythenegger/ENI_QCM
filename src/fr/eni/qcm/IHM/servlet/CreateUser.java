package fr.eni.qcm.IHM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	}

}
