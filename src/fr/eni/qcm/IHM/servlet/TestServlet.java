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

				} else {
					listeQuestions = (List<Question>) session.getAttribute("listeQuestions");
					if (request.getParameter("numQuestion") != null) {
						numQuestion = Integer.parseInt(request.getParameter("numQuestion"));
						session.setAttribute("numQuestion", numQuestion);
					} else {
						numQuestion = Integer.parseInt((String.valueOf(session.getAttribute("numQuestion"))));
					}

					ques = listeQuestions.get(numQuestion);
				}

				List<Reponse> rep = ques.getReponses();

				reponsesUser = em.getReponsesUser(userEpreuve.getIdEpreuve());
				if (reponsesUser != null) {
					
					for (ReponseUser ru : reponsesUser) {
						for (Reponse reponse : rep) {
							if (ru.getIdQuestion() == ques.getIdQuestion()
									&& reponse.getIdReponse() == ru.getIdReponse()) {
								repUserEnCours = ru;
							}
						}
					}
				}
				session.setAttribute("reponseUser", repUserEnCours);
				session.setAttribute("question", ques);
				session.setAttribute("reponses", rep);

				session.setAttribute("numQuestion", numQuestion);

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

		HttpSession session = request.getSession();
		TestManager tm= new TestManager();

		EpreuveManager em = new EpreuveManager();
		int numQuestion;

		if (request.getParameter("reponseRadio") != null) {

			String[] parts = request.getParameter("reponseRadio").split("-");
			try {
				em.ajoutReponse(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
				if (request.getParameter("numQuestion") != null) {
					numQuestion = Integer.parseInt(request.getParameter("numQuestion"));
					session.setAttribute("numQuestion", numQuestion);
				}
				

			} catch (NumberFormatException | BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println(request.getParameter("coche"));
		if (!"".equals(request.getParameter("coche")) && request.getParameter("coche")!=null) {
			System.out.println("yo");
			String[]parts = request.getParameter("coche").split("-");
			try {
				if( "Marquer la question".equals(parts[0])) {
					
						tm.cocheQuest(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
						System.out.println("je suis ici");
					
				}else if("Retirer la marque".equals(parts[0])) {
					
						tm.decocheQuest(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
						
					}
			} catch (NumberFormatException | BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (request.getParameter("numQuestion") != null) {
				numQuestion = Integer.parseInt(request.getParameter("numQuestion"));
				session.setAttribute("numQuestion", numQuestion);
			}
			
		}response.sendRedirect("test");
	}

}
