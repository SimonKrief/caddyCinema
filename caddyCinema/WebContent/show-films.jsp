<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>films</title>
</head>
<body>
	<h2>aaa ${titre }</h2>
	<c:forEach items="${films }" var="film">
		<form action="AchatServlet" METHOD="POST">
			<input type="hidden" name="id" id="id" value="${film.id }">
			<table>
				<tr>
					<td>${film.titre }</td>
					<td>${film.prixht }</td>
					<td><button type="submit" class="btn btn-light">ajouter
							au panier</button></td>
				</tr>
			</table>
		</form>
	</c:forEach>

	<div>
		<form action="ValidationCommandeServlet" METHOD="POST">
			<button type="submit">Valider la commande</button>
		</form>
	</div>

<a>Salut</a>

	<a href="index.jsp">Retour</a>
</body>
</html>