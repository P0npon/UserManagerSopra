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
        <br />
        <c:import url="/WEB-INF/user/form.jsp" />
        <br />
        <c:if test="${ !errorStatus }">
        <c:import url="/WEB-INF/user/card.jsp" />
        </c:if>
                    
    </body>
</html>