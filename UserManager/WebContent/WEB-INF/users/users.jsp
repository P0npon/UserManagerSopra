<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="styleRegister.css" />
    </head>
    <body>
    <c:import url="/WEB-INF/menu/menu.jsp" />
    <c:choose>
    <c:when test="${ empty sessionScope.users }">
    <p class="erreur">Aucun utilisateur enregistré</p>
    </c:when>
    <c:otherwise>
    <table>
      <tr>
        <td>username</td>
        <td>email</td>
        <td>supprimer</td>
      </tr>
      <c:forEach var="item" items="${ sessionScope.users}" varStatus="status">
      <tr class="${status.index % 2 == 0 ? 'pair' : 'impair'}">
        <td>${item.value.email}</td>
        <td>${item.value.nom}</td>
        <td>
        <a href="
			<c:url value="/del-user" >
			<c:param name="email" value="${ item.key }" /></c:url>">
			<img src="<c:url value="/images/supprimer.png"/>" alt="Supprimer" />
		</a>
         </td>
        
      </tr>
      </c:forEach>
    </table>
    </c:otherwise>
    </c:choose>          
    </body>
</html>