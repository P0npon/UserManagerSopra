<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link type="text/css" rel="stylesheet" href="styleRegister.css" />
	</head>
	<body>
		<c:import url="/WEB-INF/menu/menu.jsp" />
		<form method="post" action="login">
			<fieldset>
				<c:choose>
					<c:when test="${ empty erreurs }">
	    				<p class="${'succes'}">${resultat}</p>
	    				<p class="${'succes'}">connected</p>
	    			</c:when>
	    			<c:otherwise>
						<legend>Connexion</legend>
		
						<label for="email">Adresse Mail <span class="requis">*</span></label>
						<input type="text" id="email" name="email" value="${form['email']}" size="20"
							maxlength="60" />
						<span class="erreur">${erreurs['email']}</span> 
						<br /> 
						
						<label for="motdepasse">Mot de passe <span class="requis">*</span>
						</label>
					    <input type="password" id="motdepasse" name="motdepasse" value="${form['motdepasse']}"size="20" maxlength="20" /> 
					    <span class="erreur">${erreurs['motdepasse']}</span>
						<br /> 
						
						<input type="submit" value="login" class="sansLabel" /> 
						<br />
						<p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
					</c:otherwise>
				</c:choose>
			</fieldset>
		</form>
	</body>
</html>