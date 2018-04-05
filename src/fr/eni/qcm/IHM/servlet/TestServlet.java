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
import fr.eni.qcm.BO.QuestionTirage;
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
		QuestionTirage questT=null;
		List<ReponseUser> reponsesUser = null;
		int idTest = 0;
		ReponseUser repUserEnCours = null;

		if (request.getParameter("id") != null || session.getAttribute("idTest") != null) {
			try {
				if (request.getParameter("id") != null)
					idTest = Integer.parseInt(request.getParameter("id"));
				else if (session.getAttribute("idTest") != null)
					idTest = Integer.parseInt((String.valueOf(session.getAttribute("idTest"))));

				List<Epreuve> epreuves = (List<Epreuve>) session.getAttribute("epreuves");
				for (Epreuve epr : epreuves) {
					if (epr.getIdTest() == idTest) {
						userEpreuve = epr;
					}
				}
				if (session.getAttribute("numQuestion") == null && request.getParameter("numQuestion") == null) {
					listeQuestions = tm.getQuesRepByIdTest(idTest, userEpreuve.getIdEpreuve());
					nbQuestions = listeQuestions.size();
					session.setAttribute("listeQuestions", listeQuestions);
					session.setAttribute("idEpreuveEnCours", userEpreuve.getIdEpreuve());
					session.setAttribute("nbQuestions", nbQuestions);
					session.setAttribute("idTest", idTest);
					ques = listeQuestions.get(0);
					questT=tm.getQuestionTirage(userEpreuve.getIdEpreuve(), ques.getIdQuestion());
					
					session.setAttribute("questionTir", questT);
				} else {
					listeQuestions = (List<Question>) session.getAttribute("listeQuestions");
					if (request.getParameter("numQuestion") != null) {
						numQuestion = Integer.parseInt(request.getParameter("numQuestion"));
						
						session.setAttribute("numQuestion", numQuestion);
						
					} else {
						numQuestion = Integer.parseInt((String.valueOf(session.getAttribute("numQuestion"))));
						
					}
					
					ques = listeQuestions.get(numQuestion);
					questT=tm.getQuestionTirage(userEpreuve.getIdEpreuve(), ques.getIdQuestion());
					session.setAttribute("questionTir", questT);
				}

				List<Reponse> rep = ques.getReponses();
				reponsesUser = em.getReponsesUser(userEpreuve.getIdEpreuve());

				for (Reponse r : rep) {
					for (ReponseUser ru : reponsesUser) {
						if (r.getIdReponse() == ru.getIdReponse()) {
							r.setEstRepondu(true);
						} else {
							r.setEstRepondu(false);
						}

					}

				}

				session.setAttribute("question", ques);
				session.setAttribute("reponses", rep);
				session.setAttribute("nbRep", rep.size());
				session.setAttribute("numQuestion", numQuestion);

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/test.jsp");
				rd.forward(request, response);

			} catch (NumberFormatException | BusinessException e) {
				e.printStackTrace();

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

		HttpSession session = request.getSession();
		TestManager tm = new TestManager();

		EpreuveManager em = new EpreuveManager();
		int numQuestion;

		if (request.getParameter("numQuestion") != null) {
			numQuestion = Integer.parseInt(request.getParameter("numQuestion"));
			session.setAttribute("numQuestion", numQuestion);
		}

		if (request.getParameter("reponseRadio") != null) {

			String[] parts = request.getParameter("reponseRadio").split("-");
			try {
				em.ajoutReponse(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));

				response.sendRedirect("test");

			} catch (NumberFormatException | BusinessException e) {
				request.setAttribute("exception", BusinessError.QUESTIONS_NO_MATCH.getDescription());
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
				rd.forward(request, response);
			}

		}

		int nbRep = Integer.parseInt(String.valueOf(session.getAttribute("nbRep")));
		boolean cpt = false;
		for (int i = 1; i <= nbRep; i++) {
			if (request.getParameter("reponseBox" + i) != null) {
				cpt = true;

				System.out.println("Reponse Box" + request.getParameter("reponseBox" + i));
				String[] parts = request.getParameter("reponseBox" + i).split("-");

				try {
					em.ajouterReponseBox(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
							Integer.parseInt(parts[2]));

				} catch (NumberFormatException | BusinessException e) {
					request.setAttribute("exception", e.getMessage());
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
					rd.forward(request, response);
				}

			}

		}
		if (cpt)
			response.sendRedirect("test");

		if (!"".equals(request.getParameter("coche")) && request.getParameter("coche") != null) {

			String[] parts = request.getParameter("coche").split("-");
			try {
				if( "Marquer la question".equals(request.getParameter("coche"))) {
					
						tm.cocheQuest(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
						
					
				}else if("Retirer la marque".equals(request.getParameter("coche"))) {
					
						tm.decocheQuest(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
						
					}
			} catch (NumberFormatException | BusinessException e) {
				request.setAttribute("exception", BusinessError.QUESTIONS_NO_MATCH.getDescription());
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
				rd.forward(request, response);
			}

		}

	}

}
