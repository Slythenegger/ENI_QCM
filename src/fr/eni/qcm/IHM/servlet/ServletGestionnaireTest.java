package fr.eni.qcm.IHM.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gestionnaire-test")
public class ServletGestionnaireTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/gestionnaireTest.jsp");
		rq.forward(request, response);
	}

}
