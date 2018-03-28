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


@WebServlet("/gestionnaire-question")
public class ServletGestionnaireQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestManager tm = new TestManager();
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/gestionnaireQuestion.jsp");
		
		Test selectedTest = null;
		
		try {
			int testID = Integer.parseInt(request.getParameter("test"));
			selectedTest = tm.getById(testID);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (selectedTest != null) {			
			request.setAttribute("test", selectedTest);			
			rq.forward(request, response);
			return;
		}
		
		
		
		
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
