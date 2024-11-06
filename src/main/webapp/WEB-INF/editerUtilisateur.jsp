<%@page import="beans.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@include file="inc/header.jsp"%>
 <section class="content-section">
<h1 id="titre-principale">Modification d'un utilisateur</h1>

<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
<form method="post" class="main">
  <div class="formItem">
     <label>Nom:</label>
      <input type="text" name="nom" value="<%=utilisateur.getNom()%>">
  </div>
  
   <div class="formItem">
     <label>Prénom:</label>
      <input type="text" name="prenom" value="<%=utilisateur.getPrenom()%>">
  </div>

  <div class="formItem">
     <label>Login:</label>
      <input type="text" name="login" value="<%=utilisateur.getLogin()%>">
  </div>

  <div class="formItem">
     <label>Mot de passe:</label>
      <input type="password" name="password" value="<%=utilisateur.getPassword()%>" >
  </div>
 <input type="submit" value="Modifier">
</form>
</section>
 <%@include file="inc/footer.jsp"%>