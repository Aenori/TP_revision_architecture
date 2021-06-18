<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  import="org.formation.model.Formation" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<table class="table table-striped">
		<thead>
			<th>id</th>
			<th>date</th>
			<th>sujet</th>
			<th>formateur</th>
			<th>paieFormateur</th>
			<th>statut</th>
			<th>statutFormateur</th>
		</thead>
		<tbody>
			<%
			List formationsFusionnees = (List) request.getAttribute("formationsFusionnees");
			%>
			<%
			for (Object f : formationsFusionnees) {
			%>
			<tr>
				<td><%=((Formation) f).getId()%></td>
				<td><%=((Formation) f).getDate()%></td>
				<td><%=((Formation) f).getSujet().getNom()%></td>
				<td><%=((Formation) f).getFormateur().getNom()%></td>
				<td><%=((Formation) f).getPaieFormateur()%></td>
				<td><%=((Formation) f).getStatut()%></td>
				<td><%=((Formation) f).getStatutFormateur()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>