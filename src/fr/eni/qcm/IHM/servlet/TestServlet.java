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
import fr.eni.qcm.BLL.TestManager;
import fr.eni.qcm.BO.QuestionReponses;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TestManager tm = new TestManager();
		HttpSession session = request.getSession();
		List<QuestionReponses> liste = null;

		if (request.getParameter("id") != null) {
			try {
				
				liste = tm.getQuesRepByIdTest(Integer.parseInt(request.getParameter("id")));
				session.setAttribute("liste", liste);
				System.out.println("j'ai bien une liste");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/test.jsp");
				rd.forward(request, response);

			} catch (NumberFormatException | BusinessException e) {
				System.out.println("Probleme");
				request.setAttribute("exception", BusinessError.QUESTIONS_NO_MATCH.getDescription());
				System.out.println(request.getAttribute("exception"));
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp");
				rd.forward(request, response);
			}

		} else {
			System.out.println("else");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
