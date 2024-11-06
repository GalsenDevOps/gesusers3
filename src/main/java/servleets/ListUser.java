package servleets;

import java.io.IOException;
import java.util.ArrayList;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/list",""})
public class ListUser extends HttpServlet {

	private static final String VUE_LIST_UTILISATEUR = "/WEB-INF/listerUtilisateurs.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
       
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR);
		ArrayList<Utilisateur> listUtilisateurs = UtilisateurDAO.lister();
		request.setAttribute("utilisateurs", listUtilisateurs);
		dispatcher.forward(request, response);
	}
	
	 
}
