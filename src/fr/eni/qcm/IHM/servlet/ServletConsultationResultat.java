package fr.eni.qcm.IHM.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.EpreuveManager;
import fr.eni.qcm.BLL.TestManager;
import fr.eni.qcm.BO.Resultat;
import fr.eni.qcm.BO.Test;


@WebServlet("/resultats")
public class ServletConsultationResultat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestManager tm = new TestManager();		
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/consultationResultat.jsp");
		
		
		
		try {
			if (request.getParameter("test") != null) {
				int testID = Integer.parseInt(request.getParameter("test"));
				Test selectedTest = tm.getById(testID);
				List<Resultat> resultats = new EpreuveManager().getResultatForTest(testID);
				
				request.setAttribute("test", selectedTest);
				request.setAttribute("resultats", resultats);
			}
			
			List<Test> tests = tm.getAll();
			request.setAttribute("tests", tests);			
		} 
		catch (BusinessException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		rq.forward(request, response);
	}
}
