<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.database.entity.Provincia" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/table-style.css">
	<title>Province JSP</title>
</head>
<body>
	<h1>Elenco delle Province</h1>
	<%
	// questo è uno scriptlet: codice java embedded in HTML
	List<Provincia> province = (List<Provincia>)request.getAttribute("lista.province");
	// ciclo per stampare tutti gli elementi
	// Regione, provincia, sigla
	%>
	<!-- qui sono in HTML (linguaggio principale della pagina) -->
	<!-- Devo rappresentare i dati delle province in formato tabulare -->
	<table>
		<tr>
			<th>#</th>
			<th>Regione</th>
			<th>Provincia</th>
			<th>Sigla</th>
		</tr>
		<!-- repeating group di TR una per ciascuna provincia -->
		<%for(Provincia p: province) { %>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getRegione().getNome()%></td>
			<td><%=p.getNome() %></td>
			<td><%=p.getSiglaAutomobilistica() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>