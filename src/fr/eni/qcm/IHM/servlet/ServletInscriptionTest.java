package fr.eni.qcm.IHM.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.PromoManager;
import fr.eni.qcm.BLL.TestManager;
import fr.eni.qcm.BLL.UserManager;
import fr.eni.qcm.BO.Promo;
import fr.eni.qcm.BO.Test;


@WebServlet("/inscriptionTest")
public class ServletInscriptionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TestManager testmanager = new TestManager();
	//	UserManager usermanager = new UserManager();
		List<Test> tests= new ArrayList<Test>();
		PromoManager pmger = new PromoManager();
		List<Promo> promos= new ArrayList<Promo>();
		try {
			tests=testmanager.getAll();
			promos=pmger.getAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("promos", promos);
		request.setAttribute("tests", tests);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscriptionTest.jsp");
		rd.forward(request, response);	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
