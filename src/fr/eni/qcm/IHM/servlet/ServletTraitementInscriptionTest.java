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
import fr.eni.qcm.BLL.UserManager;
import fr.eni.qcm.BO.User;

/**
 * Servlet implementation class ServletTraitementInscriptionTest
 */
@WebServlet("/ServletTraitementInscriptionTest")
public class ServletTraitementInscriptionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (	request.getParameter("testDateDebut")== "" ||
				request.getParameter("testDateFin")==""||
				request.getParameter("testId")==""||
				request.getParameter("testHeureDebut")==""||
				request.getParameter("testHeureFin")==""
				) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscriptionTest.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("codePromo")!= "" && request.getParameter("codePromo")!=null) {
			UserManager umger= new UserManager();
			EpreuveManager emger= new EpreuveManager();
			List<User> users= new ArrayList<>();
			try {
				users=umger.findPromo(request.getParameter("codePromo"));
				for (User user : users) {
					
					
					int idtest = Integer.parseInt(request.getParameter("idTest"));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
					Date dateDebut, dateFin = new Date();
					try {
						dateDebut=sdf.parse(request.getParameter("testDateDebut")
											+" "+request.getParameter("testHeureDebut"));
						
						dateFin=sdf.parse(request.getParameter("testDateFin")
											+" "+request.getParameter("testHeureFin"));
						
						Instant i = dateDebut.toInstant();
						Instant i2 =dateFin.toInstant();
						emger.createEpreuve(i,
											i2,
											idtest,
											user.getIdUser());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(request.getParameter("stagname")!= "") {
				System.out.println("c'est un stagiaire");
			}
		}
	}

}
