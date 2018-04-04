package fr.eni.qcm.IHM.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.EpreuveManager;
import fr.eni.qcm.BLL.PromoManager;
import fr.eni.qcm.BLL.TestManager;
import fr.eni.qcm.BLL.UserManager;
import fr.eni.qcm.BO.Promo;
import fr.eni.qcm.BO.Test;
import fr.eni.qcm.BO.User;

/**
 * Servlet implementation class ServletTraitementInscriptionTest
 */
@WebServlet("/ServletTraitementInscriptionTest")
public class ServletTraitementInscriptionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> users = new ArrayList<>();
		UserManager umger = new UserManager();
		TestManager testmanager = new TestManager();

		if (request.getParameter("testDateDebut") == "" || request.getParameter("testDateFin") == ""
				|| request.getParameter("idTest") == "" || request.getParameter("testHeureDebut") == ""
				|| request.getParameter("testHeureFin") == "") {

			request.setAttribute("exception", "Veuillez remplir tout les champs !");
			List<Test> tests = new ArrayList<Test>();
			PromoManager pmger = new PromoManager();

			List<Promo> promos = new ArrayList<Promo>();

			try {
				users = umger.getAll();
				tests = testmanager.getAll();
				promos = pmger.getAll();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("exception", e.getError().getDescription());
			}
			request.setAttribute("users", users);
			request.setAttribute("promos", promos);
			request.setAttribute("tests", tests);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscriptionTest.jsp");
			rd.forward(request, response);
		}

		else if (request.getParameter("codePromo") != "" && request.getParameter("codePromo") != null) {
			try {
				users = umger.findPromo(request.getParameter("codePromo"));

			} catch (BusinessException e) {
				request.setAttribute("exception", e.getError().getDescription());
				e.printStackTrace();
			}

		} else if (request.getParameter("userid") != "" && request.getParameter("userid") != null) {
			try {
				User user = umger.findUser(request.getParameter("userid"));
				users.add(user);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				request.setAttribute("exception", e.getError().getDescription());
				e.printStackTrace();
			}

		}

		if (users.size() >= 1) {

			for (User user : users) {

				try {
					int idtest = Integer.parseInt(request.getParameter("idTest"));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
					Date dateDebut, dateFin = new Date();

					dateDebut = sdf.parse(
							request.getParameter("testDateDebut") + " " + request.getParameter("testHeureDebut"));

					dateFin = sdf
							.parse(request.getParameter("testDateFin") + " " + request.getParameter("testHeureFin"));
					if (dateDebut.compareTo(dateFin) > 0) {

						request.setAttribute("exception", "La date de début doit être inférieur à la date de fin");

						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscriptionTest.jsp");

					} else {

						Instant i = dateDebut.toInstant();
						Instant i2 = dateFin.toInstant();

						createEpreuve(i, i2, idtest, user.getIdUser());
					}
				} catch (NumberFormatException | ParseException | BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("exception", ((BusinessException) e).getError().getDescription());
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
			rd.forward(request, response);
		}
	}

	public void createEpreuve(Instant dateDebut, Instant dateFin, int idTest, int id) throws BusinessException {
		EpreuveManager emger = new EpreuveManager();
		emger.createEpreuve(dateDebut, dateFin, idTest, id);
	}

}
