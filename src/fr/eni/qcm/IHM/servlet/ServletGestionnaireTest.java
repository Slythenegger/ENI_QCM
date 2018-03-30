package fr.eni.qcm.IHM.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.TestManager;
import fr.eni.qcm.BO.Test;


@WebServlet("/gestionnaire-test")
public class ServletGestionnaireTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/gestionnaireTest.jsp");
		TestManager tm = new TestManager();
		
		try {
			List<Test> tests = tm.getAll();
			request.setAttribute("tests", tests);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		rq.forward(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in");
		this.doGet(req, resp);
		
	}
	
	
}
