package fr.eni.qcm.IHM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.qcm.BLL.TestManager;
import fr.eni.qcm.BO.Test;


@WebServlet("/creation-test")
public class ServletCreationTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/creationTest.jsp");
		
		Test test = new Test();
		request.setAttribute("test", test);
		
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test test = new Test();
		TestManager tm = new TestManager();
		
		try {
			test.setLibelle(request.getParameter("libelle"));
			test.setDescription(request.getParameter("description"));
			test.setDuree(Integer.parseInt(request.getParameter("duree")));
			test.setSeuilHaut(Float.parseFloat(request.getParameter("seuilhaut")));
			test.setSeuilBas(Float.parseFloat(request.getParameter("seuilbas")));
			
			tm.insert(test);
		} catch (Exception e) {

		}
		
		response.sendRedirect(this.getServletContext().getContextPath() + "/gestionnaire-question");
	}

}
