package servleets;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateUser extends HttpServlet{
	private static final String VUE_UPDATE_UTILISATEUR ="/WEB-INF/editerUtilisateur.jsp";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if (id != null && id.matches("[0-9]+")){
			
			Utilisateur utilisateur = UtilisateurDAO.get(Integer.parseInt(id));
			
		        if(utilisateur != null) {
		        	request.setAttribute("utilisateur", utilisateur);
		        	getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request,response);
		        	return;
		      	
		  }
		}
		response.sendRedirect("list");
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Utilisateur utilisateur = new Utilisateur( Integer.parseInt(id),nom, prenom, login,password);
		UtilisateurDAO.modifier(utilisateur);
		response.sendRedirect("list");
	}
}
