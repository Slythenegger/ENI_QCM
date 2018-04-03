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
		Test selected = new Test();
		
		try {
			List<Test> tests = tm.getAll();
			request.setAttribute("tests", tests);
			request.setAttribute("selected", selected);
			
			String mode = request.getParameter("mode");
			String testIDstr = request.getParameter("testID");
			
			// Page par default
			if (mode == null && testIDstr == null) {
				rq.forward(request, response);
				return;
			}
			
			
			request.setAttribute("mode", mode);
			
			if ("create".equals(mode)) {				
				rq.forward(request, response);
				return;
			}

			if ("update".equals(mode)) {
				int testID = Integer.parseInt(testIDstr);
				Test test = tm.getById(testID);
				
				if (test != null) {
					request.setAttribute("selected", test);
				}
				
				rq.forward(request, response);
				return;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO page erreur
		rq.forward(request, response);
	}


	@Override
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
		
		this.doGet(request, response);
	}
	
	
}
