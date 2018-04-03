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

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.EpreuveManager;
import fr.eni.qcm.BLL.TestManager;
import fr.eni.qcm.BO.Epreuve;
import fr.eni.qcm.BO.Question;
import fr.eni.qcm.BO.Reponse;
import fr.eni.qcm.BO.ReponseUser;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int numQuestion = 0;
	int nbQuestions;

	/**
	 * Méthode en charge de
	 * 
	 * @throws ServletException
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TestManager tm = new TestManager();
		EpreuveManager em = new EpreuveManager();
		HttpSession session = request.getSession();
		List<Question> listeQuestions = null;
		Epreuve userEpreuve = null;
		Question ques = null;
		List<ReponseUser> reponsesUser = null;

		if (request.getParameter("id") != null) {
			try {
				int idTest = Integer.parseInt(request.getParameter("id"));

				List<Epreuve> epreuves = (List<Epreuve>) session.getAttribute("epreuves");
				for (Epreuve epr : epreuves) {
					if (epr.getIdTest() == idTest) {
						userEpreuve = epr;
					}
				}
				if (request.getParameter("numQuestion") == null) {
					listeQuestions = tm.getQuesRepByIdTest(idTest, userEpreuve.getIdEpreuve());
					nbQuestions = listeQuestions.size();
					session.setAttribute("listeQuestions", listeQuestions);
					session.setAttribute("idEpreuveEnCours", userEpreuve.getIdEpreuve());
					session.setAttribute("nbQuestions", nbQuestions);
					ques = listeQuestions.get(0);

				} else {
					listeQuestions = (List<Question>) session.getAttribute("listeQuestions");
					numQuestion = Integer.parseInt(request.getParameter("numQuestion"));
					ques = listeQuestions.get(numQuestion);
				}

				List<Reponse> rep = ques.getReponses();
				
				reponsesUser = em.getReponsesUser(userEpreuve.getIdEpreuve());				
				
				request.setAttribute("reponsesUser", reponsesUser);
				request.setAttribute("idTest", idTest);
				request.setAttribute("numQuestion", numQuestion);
				request.setAttribute("question", ques);
				request.setAttribute("reponses", rep);

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/test.jsp");
				rd.forward(request, response);

			} catch (NumberFormatException | BusinessException e) {

				request.setAttribute("exception", BusinessError.QUESTIONS_NO_MATCH.getDescription());
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
				rd.forward(request, response);
			}

		} else {
			request.setAttribute("exception", BusinessError.TEST_NO_MATCH.getDescription());
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EpreuveManager em = new EpreuveManager();

		if (request.getParameter("reponseRadio") != null) {

			String[] parts = request.getParameter("reponse").split("-");
			try {
				em.ajoutReponse(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
			
			
			} catch (NumberFormatException | BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
