<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@include file="inc/header.jsp"%>
 <section class="content-section">
 <h1 id="titre-principal">Liste des utilisateurs</h1>
<%
 ArrayList<Utilisateur> users = (ArrayList<Utilisateur>)request.getAttribute("utilisateurs");
 if(users.isEmpty()){
	 out.print("Désolé la liste des utilisateurs est vide !");
	 
 }
 else
 {%>
 	<table border="1" cellspacing="0" cellpadding="10">
 	<tr>
 	<th>ID</th>
 	<th>Nom</th>
 	<th>Prenom</th>
 	<th>Login</th>
 	<th>Password</th>
 	<th colspan="2">Actions</th>
 	</tr><%
	 for(Utilisateur user : users )
		 {%>
		  <tr>
		    <td><%= user.getId() %></td>	
		    <td><%= user.getNom() %></td>	
		    <td><%= user.getPrenom() %></td>	
		    <td><%= user.getLogin() %></td>	
		    <td><%= user.getPassword() %></td>	
		    <td><a href="update?id=<%= user.getId() %>">Modifier</a></td>
		   <td><a href="delete?id=<%= user.getId() %>" onclick="return confirm ('en êtes vous sûr ?')">Supprimer</a></td>
		   </tr><%
		 }%>
		   </table><%
	 }
 %>

 </section>
 <%@include file="inc/footer.jsp"%>
