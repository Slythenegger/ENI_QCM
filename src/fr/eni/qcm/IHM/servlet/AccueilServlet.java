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
import fr.eni.qcm.CodeRole;
import fr.eni.qcm.BLL.EpreuveManager;
import fr.eni.qcm.BO.EpreuveCandidat;
import fr.eni.qcm.BO.User;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode en charge de récupérer et d'envoyer à la servlet les épreuves d'un
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

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");		
		List<EpreuveCandidat> epreuves = null;

		EpreuveManager em = new EpreuveManager();
		

		if (user.getRole().equals(CodeRole.CODE_STAGIAIRE) || user.getRole().equals(CodeRole.CODE_CANDIDAT)) {
			try {
				epreuves = em.getUserTest(user.getIdUser());
				
			} catch (BusinessException e) {
				request.setAttribute("exception", e.getError().getDescription());
			}
		}
		session.setAttribute("epreuves", epreuves);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
